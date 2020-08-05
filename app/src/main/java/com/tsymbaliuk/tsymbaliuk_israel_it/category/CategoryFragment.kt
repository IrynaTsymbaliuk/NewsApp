package com.tsymbaliuk.tsymbaliuk_israel_it.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import com.tsymbaliuk.tsymbaliuk_israel_it.main.ArticleAdapter
import com.tsymbaliuk.tsymbaliuk_israel_it.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CategoryFragment: Fragment() {

    private lateinit var categoryAdapter: ArticleAdapter
    private val categoryViewModel: CategoryViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       setRVAdapter()

    }

    private fun setRVAdapter() {
        categoryAdapter =
            ArticleAdapter(requireContext())

        categoryAdapter.setItemClickListener { position ->
            Toast.makeText(requireContext(), "Item $position Click", Toast.LENGTH_SHORT).show()
        }

        categoryAdapter.setMoreClickListener { position ->
            Toast.makeText(requireContext(), "More $position Click", Toast.LENGTH_SHORT).show()
        }

        rvCategoryNewsList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = categoryAdapter
        }

        categoryViewModel.articleList.observe(viewLifecycleOwner, Observer {
            categoryAdapter.updateData(it)
        })
    }

}