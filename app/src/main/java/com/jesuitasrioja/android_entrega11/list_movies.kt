package com.jesuitasrioja.android_entrega11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesuitasrioja.android_entrega11.databinding.FragmentListMoviesBinding

class list_movies : Fragment() {
    private lateinit var binding: FragmentListMoviesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListMoviesBinding.inflate(layoutInflater)
        return binding.root

    }
}