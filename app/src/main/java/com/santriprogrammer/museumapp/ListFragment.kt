package com.santriprogrammer.museumapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    var v: View? = null
    var poko: POKO? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater!!.inflate(R.layout.fragment_list, container, false)
        getData()
        return v
    }

    private fun getData() {
        val reqList: RequestQueue = Volley.newRequestQueue(activity)
        val strqList: StringRequest? = StringRequest(Request.Method.GET, Helper.URL, Response.Listener { response ->
            Log.i("response", response)
            var gsonBuilder = GsonBuilder()
            var gson: Gson = gsonBuilder.create()

            poko = gson.fromJson(response, POKO::class.java)

            val adapter = Adapter(activity, poko!!.getResults())
            recyclerList.adapter = adapter
            recyclerList.layoutManager = LinearLayoutManager(activity)
        }, Response.ErrorListener {

        })
        reqList.add<String>(strqList)
    }
}
