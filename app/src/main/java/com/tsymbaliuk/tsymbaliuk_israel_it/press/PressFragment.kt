package com.tsymbaliuk.tsymbaliuk_israel_it.press

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import kotlinx.android.synthetic.main.fragment_press.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class PressFragment : Fragment() {

    private lateinit var sourceAdapter: SourceAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    private val viewModel: PressViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_press, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSourceAdapter()
        setCategoryAdapter()

    }

    private fun setSourceAdapter() {
        sourceAdapter = SourceAdapter()

        sourceAdapter.setItemClickListener { position ->
            findNavController().navigate(
                PressFragmentDirections.actionPressFragmentToSourceFragment(
                    position
                )
            )
        }

        sourceAdapter.setAddToFavoriteClickListener { position ->
            viewModel.addToSubscriptions(position)
        }

        rvPopularSources.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = sourceAdapter
        }

        viewModel.mergedSourceList.observe(viewLifecycleOwner, Observer {list ->
            if (!list.isNullOrEmpty()) sourceAdapter.updateData(list)
        })
    }

    private fun setCategoryAdapter() {
        categoryAdapter = CategoryAdapter()

        categoryAdapter.setItemClickListener { position ->
            Toast.makeText(requireContext(), "Item $position Click", Toast.LENGTH_SHORT).show()
        }

        rvCategoriesList.apply {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
        }

    }

}