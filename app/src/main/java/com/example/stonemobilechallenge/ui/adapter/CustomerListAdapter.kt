package com.example.stonemobilechallenge.ui.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stonemobilechallenge.R
import com.example.stonemobilechallenge.model.Customer
import kotlinx.android.synthetic.main.customer_item.view.*
import com.example.stonemobilechallenge.ui.activity.CustomerDetailActivity
import com.tapadoo.alerter.Alerter


class CustomerListAdapter(private val customers: List<Customer>,
                          private val context: Context
) : Adapter<CustomerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.customer_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val customer = customers[position]
        holder?.bindView(customer)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(customer: Customer) {

            val title = itemView.customer_item_title
            val description = itemView.customer_item_description
            val status = itemView.customer_item_status

            if (customer.status.equals("Reativação")) {
                itemView.setBackgroundColor(Color.parseColor("#97ad80"))
            } else {
                itemView.setBackgroundColor(Color.WHITE)
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, CustomerDetailActivity::class.java)
                intent.putExtra("CustomerDetailsKey", customer)
                itemView.context.startActivity(intent)
            }

            title.text = customer.name
            description.text = customer.description
            status.text = customer.status

        }
    }

}