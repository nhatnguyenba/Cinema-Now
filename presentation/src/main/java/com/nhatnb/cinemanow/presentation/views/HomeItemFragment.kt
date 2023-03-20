package com.nhatnb.cinemanow.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nhatnb.cinemanow.R
import com.nhatnb.cinemanow.databinding.FragmentHomeItemBinding
import com.nhatnb.cinemanow.presentation.adapter.MovieListItemAdapter
import com.nhatnb.cinemanow.presentation.util.launchAndRepeatWithViewLifecycle
import com.nhatnb.cinemanow.presentation.viewmodel.HomeItemViewModel
import com.nhatnb.cinemanow.presentation.views.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeItemFragment : BaseFragment<FragmentHomeItemBinding>() {

    private val viewModel: HomeItemViewModel by viewModels()
    private val movieListItemAdapter: MovieListItemAdapter by lazy {
        MovieListItemAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()
        setUpListeners()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.trendingMovies.observe{
            launchAndRepeatWithViewLifecycle {
                movieListItemAdapter.submitData(it)
            }
        }
    }

    private fun setUpListeners() {

    }

    private fun setUpViews() {
        setUpRecycleView()
    }

    private fun setUpRecycleView() = with(binding.rvTrendingMovies){
        adapter = movieListItemAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        setHasFixedSize(true)
    }

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentHomeItemBinding =
        FragmentHomeItemBinding.inflate(inflater)
}