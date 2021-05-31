package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilterAdapter:RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var filter_name = arrayOf("Mobile","Tablet","Ear-phone","Powerbank","EarBuds","Laptop","Computer","AC","Smart Watch")
    private var filter_image = arrayOf(R.drawable.filter_1,R.drawable.filter_2,R.drawable.filter_3,R.drawable.filter_4,R.drawable.filter_5,R.drawable.filter_2,R.drawable.filter_3,R.drawable.filter_4,R.drawable.filter_5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.filter_card,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FilterAdapter.ViewHolder, position: Int) {
        holder.filterName.text=filter_name[position]
        holder.filterImage.setImageResource(filter_image[position])
    }

    override fun getItemCount(): Int {
        return filter_name.size

    }
    
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var filterName:TextView
        var filterImage:ImageView

        init {
            filterName=itemView.findViewById(R.id.filterName)
            filterImage=itemView.findViewById(R.id.filterImage)
        }
    }
}