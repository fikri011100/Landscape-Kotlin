package com.santriprogrammer.museumapp

import android.app.Activity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.santriprogrammer.museumapp.Adapter.ViewHolder
import com.squareup.picasso.Picasso

/**
 * Created by fikriimaduddin on 13/11/17.
 */
class Adapter : Adapter<ViewHolder> {

    var list_data: List<POKO.ResultsBean>? = null
    var c: Activity? = null

    constructor(list_data: FragmentActivity, c: List<POKO.ResultsBean>?) : super() {
        this.list_data = c
        this.c = list_data
    }

    override fun getItemCount(): Int {

        return list_data?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var listitem : POKO.ResultsBean = list_data!!.get(position)
        Picasso.with(c)
                .load(Helper.IMAGE_URL_POSTER + listitem.poster_path)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder?.image)
        holder?.txtTitle?.text = listitem.title
        holder?.ratingBar?.rating = listitem.vote_average.toFloat() / 2
        holder?.vote_result?.text = listitem.vote_count.toString()
        holder?.consItem?.setOnClickListener {
            var bundle : Bundle? = Bundle()
            bundle?.putString("image", listitem.poster_path)
            bundle?.putString("title", listitem.title)
            var detail: DetailFragment? = DetailFragment()
            var fragment: FragmentActivity = c as FragmentActivity
            detail?.arguments = bundle
            fragment.supportFragmentManager.beginTransaction().replace(R.id.container_detail, detail, "detail").commit()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(c).inflate(R.layout.item_view, parent, false)

        return ViewHolder(inflater)
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var image = itemView?.findViewById<ImageView>(R.id.imgItem)
        var txtTitle = itemView?.findViewById<TextView>(R.id.txt_title)
        var consItem = itemView?.findViewById<ConstraintLayout>(R.id.consItem)
        var ratingBar = itemView?.findViewById<RatingBar>(R.id.rb_votes)
        var vote_result = itemView?.findViewById<TextView>(R.id.votes_result)
    }
}