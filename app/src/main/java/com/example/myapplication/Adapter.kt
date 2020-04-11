package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.product.view.*

class ProductAdapter(context: Context ,val products: List<Product>): BaseAdapter() {

    var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }


    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(position: Int): Any {
        return products[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var documentView = inflater.inflate(R.layout.product, null)
        var numberOfOrder = 0

        documentView.product.text = products[position].name + "\n" +products[position].price.toString() + "yen"
        documentView.number.text = "0"

        documentView.countUp.setOnClickListener {
            numberOfOrder += 1

            callList().apply {
                products[position].numberOfOrder = numberOfOrder
            }
            documentView.number.text = numberOfOrder.toString()
        }

        documentView.countDown.setOnClickListener {
            numberOfOrder -= 1

            callList().apply {
                products[position].numberOfOrder = numberOfOrder
            }
            documentView.number.text = numberOfOrder.toString()
        }


        return documentView!!
    }



}


class OrderAdapter(context: Context ,val order: List<Product>): BaseAdapter() {

    var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }


    override fun getCount(): Int {
        return order.size
    }

    override fun getItem(position: Int): Any {
        return order[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var documentView = inflater.inflate(R.layout.product, null)
        val eachTotalPrice = order[position].price * order[position].numberOfOrder

        documentView.eachTotalPrice.text = eachTotalPrice.toString()+"yen"
        documentView.product.text = order[position].name + "\n" +order[position].price.toString() + "yen"
        documentView.number.text = order[position].numberOfOrder.toString()

        documentView.countUp.visibility = View.INVISIBLE
        documentView.countDown.visibility = View.INVISIBLE


        return documentView!!
    }


}


