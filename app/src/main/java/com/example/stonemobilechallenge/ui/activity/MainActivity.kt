package com.example.stonemobilechallenge.ui.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.stonemobilechallenge.model.Customer
import com.example.stonemobilechallenge.ui.adapter.CustomerListAdapter
import com.example.stonemobilechallenge.R
import com.google.gson.Gson
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfCustomers = readJSONfromFile()

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = CustomerListAdapter(listOfCustomers, this)
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

        if (listOfCustomers.filter { it.status.equals("Reativação") }.isNotEmpty()) {
            Alerter.create(this)
                .setTitle("You have new Reactivation Customers!")
                .setText("You have " + listOfCustomers.filter { it.status.equals("Reativação") }.size +
                        " new reactivation customers and this is one of then")
                .show()
        }
    }

    private fun readJSONfromFile(): List<Customer> {
        val gson = Gson()

        val inputStream: InputStream = assets.open("customers.json")
        val inputString = inputStream.bufferedReader().use { it.readText() }

        return gson.fromJson(inputString, Array<Customer>::class.java).toList()
    }

}
