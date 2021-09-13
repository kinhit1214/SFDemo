package com.example.sfdemo.ui.main.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sfdemo.R
import com.example.sfdemo.ui.main.model.AppState
import com.example.sfdemo.ui.main.viewmodel.MainViewModel
import com.example.sfdemo.ui.main.model.RepFilm
import com.example.sfdemo.ui.main.model.FilmEntity
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val adapter = AdapterFilms()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view : View = inflater.inflate(R.layout.main_fragment, container, false)
        
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerview_main)
        initRecyclerView(recyclerView)
        return view
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true);
        val layoutManager : GridLayoutManager= GridLayoutManager(context,3)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(adapter)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner){data ->renderData(data)}

    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                view?.findViewById<View>(R.id.mainFragmentLoadingLayout)?.visibility = View.GONE
                adapter.setFilmsAdapter(appState.FilmData)
            }
            is AppState.Loading -> {
                view?.findViewById<View>(R.id.mainFragmentLoadingLayout)?.visibility = View.VISIBLE
            }
//            is AppState.Error -> {
//                view?.findViewById<View>(R.id.mainFragmentLoadingLayout)?.visibility = View.GONE
//                Snackbar
//                    .make(
//                        binding.mainFragmentFAB,
//                        getString(R.string.error),
//                        Snackbar.LENGTH_INDEFINITE
//                    )
//                    .setAction(getString(R.string.reload)) { viewModel.getFilmFromLocalSource() }
//                    .show()
//            }
        }
    }

}