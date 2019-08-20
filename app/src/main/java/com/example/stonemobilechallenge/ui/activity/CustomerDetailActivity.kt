package com.example.stonemobilechallenge.ui.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.stonemobilechallenge.model.Customer
import com.example.stonemobilechallenge.R
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_customer_detail.*
import kotlinx.android.synthetic.main.activity_customer_detail.view.*

class CustomerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_detail)
        val customerDetailView = customer_detail_view

        val customer: Customer = intent.getParcelableExtra("CustomerDetailsKey")

        supportActionBar?.title = customer.name
        customerDetailView.CustomerDescription?.text = customer.description
        customerDetailView.CustomerId?.text = customer.id.toString()
        customerDetailView.CustomerStatus?.text = customer.status

        if (customer.status.equals("Reativação")) {
            Alerter.create(this)
                .setTitle("New Reactivation Customer :D ")
                .setText("This is one of then!")
                .show()
        }

    }
}
