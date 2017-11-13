package com.santriprogrammer.museumapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var list: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentList()
    }

    private fun setFragmentList() {
        list = ListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, list, "List").commit()
        supportFragmentManager.popBackStack()
    }
}
