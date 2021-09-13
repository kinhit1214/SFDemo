package com.example.sfdemo.ui.main.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sfdemo.R
import com.example.sfdemo.ui.main.viewmodel.CatalogFilmsViewModel

class CatalogFilmsFragment : Fragment() {

    companion object {
        fun newInstance() = CatalogFilmsFragment()
    }

    private lateinit var viewModel: CatalogFilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.catalog_films_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogFilmsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}