package com.imastudio.portalberita.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imastudio.portalberita.MainActivity
import com.imastudio.portalberita.R
import com.imastudio.portalberita.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tampilanberita.view.*

class BeritaAdapter(
    var mainActivity: MainActivity,
    var dataBerita: List<ArticlesItem?>?
) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(
        LayoutInflater.from(mainActivity).inflate(R.layout.tampilanberita, parent, false))

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItem(item: ArticlesItem) {
            with(itemView){
                txtjudulberita.text = item.title
                Picasso.get().load(item.urlToImage).placeholder(R.drawable.loading).error(
                    R.drawable.loading).into(imgberita)
            }
        }
    }

    override fun getItemCount(): Int = dataBerita!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(dataBerita?.get(position)!!)

}