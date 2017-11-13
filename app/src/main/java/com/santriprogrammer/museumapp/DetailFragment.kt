package com.santriprogrammer.museumapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    var v: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater!!.inflate(R.layout.fragment_detail, container, false)
        var bundle: Bundle? = arguments
        var image = bundle?.getString("image")
        var title = bundle?.getString("title")
        imgDetail?.setOnClickListener {
            txt_detail?.text = title
        }
//        Picasso.with(activity)
//                .load(Helper.IMAGE_URL_POSTER + image)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(imgDetail)
        if (bundle == null) {
            Toast.makeText(activity, "no bundle", Toast.LENGTH_SHORT).show()
        } else {
            txt_detail?.text = title
            Log.i("nama", title)
            Toast.makeText(activity, title, Toast.LENGTH_SHORT).show()
        }
        return v
    }
}
