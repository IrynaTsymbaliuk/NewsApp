package com.tsymbaliuk.tsymbaliuk_israel_it.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import com.tsymbaliuk.tsymbaliuk_israel_it.main.ArticleAdapter
import com.tsymbaliuk.tsymbaliuk_israel_it.main.MainViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.subscription.SubscriptionViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_source.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SourceFragment: Fragment() {

    private val subscriptionViewModel: SubscriptionViewModel by sharedViewModel()
    private val articleViewModel: MainViewModel by sharedViewModel()
    private val args: SourceFragmentArgs by navArgs()
    private lateinit var sourceAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_source, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpArticleRV()
        setUpCurrentSource(args.sourceIndex)
        setUpTopBar()

    }

    private fun setUpArticleRV() {
        sourceAdapter = ArticleAdapter(requireContext())

        sourceAdapter.setItemClickListener { position ->
            Toast.makeText(requireContext(), "Item $position Click", Toast.LENGTH_SHORT).show()
        }

        sourceAdapter.setMoreClickListener { position ->
            Toast.makeText(requireContext(), "More $position Click", Toast.LENGTH_SHORT).show()
        }

        rvSourceSubscribeNewsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sourceAdapter
        }

        /*articleViewModel.articleList.observe(viewLifecycleOwner, Observer {
            sourceAdapter.updateData(it)
        })*/
    }

    private fun setUpCurrentSource(index: Int) {
        val currentSource = subscriptionViewModel.sourceSubscriptionList.value?.get(index)
        tvSourceName.text = currentSource?.name?: "Error"
    }

    private fun setUpTopBar() {
        ivArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }
        ivStar.setOnClickListener {  }
    }

}