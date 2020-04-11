package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ListView
import com.google.gson.Gson


class OrderConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        val products = callList()
        val productListView = findViewById(R.id.productListView) as ListView?
        val decisionImageButton = findViewById(R.id.decisionImageButton) as ImageButton?


        productListView?.adapter = ProductAdapter(this, products)

        decisionImageButton?.setOnClickListener {
            Log.d("productsSize",products.size.toString())
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("products.toJson", Gson().toJson(products))
            startActivity(intent)

        }


    }

}
