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
import com.jesuitasrioja.android_entrega11.adapter.ListAlbumAdapter
import com.jesuitasrioja.android_entrega11.adapter.MyListener
import com.jesuitasrioja.android_entrega11.databinding.FragmentSearchAlbumBinding
import com.jesuitasrioja.android_entrega11.viewModel.AlbumViewModel

class search_album: Fragment() {
    private val viewModel: AlbumViewModel by activityViewModels()
    private lateinit var binding: FragmentSearchAlbumBinding

    private val adapter = ListAlbumAdapter(
        MyListener { album ->
            viewModel.changeSelected(album)
            NavHostFragment.findNavController(this).navigate(R.id.action_search_album_to_detail_album)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchAlbumBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        binding.list.adapter=adapter
        binding.searchButton.setOnClickListener {
            if (!binding.title.text.toString().isEmpty()){
                viewModel.getAlbums(binding.title.text.toString())
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