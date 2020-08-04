package com.tsymbaliuk.tsymbaliuk_israel_it.subscription

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import com.tsymbaliuk.tsymbaliuk_israel_it.main.ArticleAdapter
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.ArticleEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.CategoryEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.FullSourceEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_subscription.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SubscriptionFragment : Fragment() {

    private val viewModel: SubscriptionViewModel by sharedViewModel()
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var sourceSubscribeAdapter: SourceSubscribeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subscription, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categorySubscriptionList.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) setEmptyCategorySubscriptions() else setAvailableCategorySubscriptions()
        })

        viewModel.sourceSubscriptionList.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                setEmptySourceSubscriptions()
            } else {
                if (!::sourceSubscribeAdapter.isInitialized) initSourceSubscribeAdapter()
                    setAvailableSourceSubscriptions(it)
            }
        })

        viewModel.savedArticleList.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                setEmptySavedArticles()
            } else {
                if (!::articleAdapter.isInitialized) initArticleAdapter()
                setAvailableSavedArticles(it)
            }
        })

    }

    private fun setEmptyCategorySubscriptions() {
        rvCategorySubscribesList.visibility = View.INVISIBLE
        tvCategoryDescription.visibility = View.VISIBLE
        ivCategoryPhoto.visibility = View.VISIBLE
        tvCategorySubscribe.text = "Підписатися на теми"
    }

    private fun setAvailableCategorySubscriptions() {
        rvCategorySubscribesList.visibility = View.VISIBLE
        tvCategoryDescription.visibility = View.INVISIBLE
        ivCategoryPhoto.visibility = View.INVISIBLE
        tvCategorySubscribe.text = "Переглянути все й керувати"
    }

    private fun setEmptySourceSubscriptions() {
        rvSourceSubscribesList.visibility = View.INVISIBLE
        tvSourceDescription.visibility = View.VISIBLE
        ivSourcePhoto.visibility = View.VISIBLE
        tvSourceSubscribe.text = "Підписатися на джерела"
    }

    private fun setAvailableSourceSubscriptions(newData: List<SourceModel>) {
        sourceSubscribeAdapter.updateData(newData)
        rvSourceSubscribesList.visibility = View.VISIBLE
        tvSourceDescription.visibility = View.INVISIBLE
        ivSourcePhoto.visibility = View.INVISIBLE
        tvSourceSubscribe.text = "Переглянути все й керувати"
    }

    private fun setEmptySavedArticles() {
        rvSavedArticlesList.visibility = View.INVISIBLE
        tvSavedDescription.visibility = View.VISIBLE
    }

    private fun setAvailableSavedArticles(newData: List<ArticleModel>) {
        articleAdapter.updateData(newData)
        rvSavedArticlesList.visibility = View.VISIBLE
        tvSavedDescription.visibility = View.INVISIBLE
    }

    private fun initArticleAdapter() {
        articleAdapter = ArticleAdapter(requireContext())
        articleAdapter.setItemClickListener { position ->
            Toast.makeText(requireContext(), "Item $position Click", Toast.LENGTH_SHORT).show()
        }
        articleAdapter.setMoreClickListener { position ->
            Toast.makeText(requireContext(), "More $position Click", Toast.LENGTH_SHORT).show()
        }
        rvSavedArticlesList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = articleAdapter
        }
    }

    private fun initSourceSubscribeAdapter() {
        sourceSubscribeAdapter = SourceSubscribeAdapter(requireContext())
        sourceSubscribeAdapter.setItemClickListener { position ->
            findNavController().navigate(SubscriptionFragmentDirections.actionSubscriptionFragmentToSourceFragment(position))
        }
        sourceSubscribeAdapter.setMoreClickListener { position ->
            Toast.makeText(requireContext(), "More $position Click", Toast.LENGTH_SHORT).show()
        }
        rvSourceSubscribesList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = sourceSubscribeAdapter
        }
    }

}