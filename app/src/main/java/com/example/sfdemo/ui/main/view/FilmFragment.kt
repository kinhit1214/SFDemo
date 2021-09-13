package com.example.sfdemo.ui.main.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sfdemo.R
import com.example.sfdemo.ui.main.viewmodel.FilmViewModel

class FilmFragment : Fragment() {

    companion object {
        fun newInstance() = FilmFragment()
    }

    private lateinit var viewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.film_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}