package com.jesuitasrioja.android_entrega11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.jesuitasrioja.android_entrega11.databinding.FragmentDetailMovieBinding
import com.jesuitasrioja.android_entrega11.viewModel.MoviesViewModel


class detail_movie : Fragment() {
    private lateinit var binding: FragmentDetailMovieBinding
    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailMovieBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewmodel=viewModel
        binding.button.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_detail_movie_to_search_movies)
        }
        return binding.root
    }
}