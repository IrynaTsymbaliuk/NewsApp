package com.tsymbaliuk.tsymbaliuk_israel_it.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MainFragment: Fragment() {

    private lateinit var articleAdapter: ArticleAdapter

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRVAdapter()

    }

    private fun setRVAdapter() {
        articleAdapter =
            ArticleAdapter(requireContext())

        articleAdapter.setItemClickListener { position ->
            Toast.makeText(requireContext(), "Item $position Click", Toast.LENGTH_SHORT).show()
        }

        articleAdapter.setMoreClickListener { position ->
            Toast.makeText(requireContext(), "More $position Click", Toast.LENGTH_SHORT).show()
        }

        rvNewsList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = articleAdapter
        }

        viewModel.articleList.observe(viewLifecycleOwner, Observer {
            articleAdapter.updateData(it)
        })
    }

}