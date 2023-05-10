package com.jesuitasrioja.android_entrega11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesuitasrioja.android_entrega11.databinding.FragmentListAlbumBinding

class list_album : Fragment() {
    private lateinit var binding: FragmentListAlbumBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListAlbumBinding.inflate(layoutInflater)
        return binding.root

    }
}