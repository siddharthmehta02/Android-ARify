package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.etebarian.meowbottomnavigation.MeowBottomNavigation


class BrowseFragment : Fragment() {

    private var layoutManager:RecyclerView.LayoutManager?=null
    private var adapter:RecyclerView.Adapter<FilterAdapter.ViewHolder>?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView= inflater.inflate(R.layout.fragment_browse, container, false)
        var recView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager=LinearLayoutManager(parentFragment?.context)
        recView.layoutManager=layoutManager
        adapter= FilterAdapter()
        recView.adapter=adapter
        return rootView
    }



    companion object {

        @JvmStatic
        fun newInstance() =
            BrowseFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}