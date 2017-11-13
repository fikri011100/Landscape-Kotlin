package com.santriprogrammer.museumapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    var v: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater!!.inflate(R.layout.fragment_detail, container, false)

        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle: Bundle? = arguments
        var image = bundle?.getString("image")
        var title = bundle?.getString("title")
        txtDetailTitle?.text = title
        Picasso.with(activity)
                .load(Helper.IMAGE_URL_BACKDROP + image)
                .placeholder(R.mipmap.ic_launcher)
                .into(imgDetail)
    }
}
