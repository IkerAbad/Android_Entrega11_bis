package com.jesuitasrioja.android_entrega11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.jesuitasrioja.android_entrega11.databinding.FragmentDetailAlbumBinding
import com.jesuitasrioja.android_entrega11.viewModel.AlbumViewModel


class detail_album : Fragment() {
    private lateinit var binding: FragmentDetailAlbumBinding
    private val viewModel: AlbumViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailAlbumBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewmodel=viewModel
        binding.button.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_detail_album_to_search_album)
        }
        return binding.root
    }
}