package com.santriprogrammer.museumapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var list: ListFragment? = null
    var detail: DetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentList()
        setFragmentDetail()
    }

    private fun setFragmentList() {
        list = ListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, list, "List").commit()
        supportFragmentManager.popBackStack()
    }

    private fun setFragmentDetail() {
        detail = DetailFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container_detail, detail, "Detail").commit()
        supportFragmentManager.popBackStack()
    }
}
