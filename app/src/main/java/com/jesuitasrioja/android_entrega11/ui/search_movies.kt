package com.jesuitasrioja.android_entrega11.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.jesuitasrioja.android_entrega11.R
import com.jesuitasrioja.android_entrega11.adapter.ListMoviesAdapter
import com.jesuitasrioja.android_entrega11.adapter.MyListener
import com.jesuitasrioja.android_entrega11.databinding.FragmentListMoviesBinding
import com.jesuitasrioja.android_entrega11.databinding.FragmentSearchMoviesBinding
import com.jesuitasrioja.android_entrega11.viewModel.MoviesViewModel

class search_movies : Fragment() {
    private val viewModel: MoviesViewModel by activityViewModels()
    private lateinit var binding: FragmentSearchMoviesBinding

    private val adapter = ListMoviesAdapter(
        MyListener { movie ->
            viewModel.changeSelected(movie)
            NavHostFragment.findNavController(this).navigate(R.id.action_search_movies_to_detail_movie)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchMoviesBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        binding.list.adapter=adapter
        binding.searchButton.setOnClickListener {
            if (!binding.title.text.toString().isEmpty()){
                viewModel.getMovies(binding.title.text.toString())
            }else{
                Toast.makeText(context,"Empty search term", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.response.observe(viewLifecycleOwner, Observer {newValue->
            adapter.submitList(newValue)
        })
        return binding.root
    }


}