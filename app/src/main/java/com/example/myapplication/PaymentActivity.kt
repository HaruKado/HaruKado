package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_payment.*


class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val productsJson = intent.extras!!.getString("products.toJson")
        val listType = object : TypeToken<List<Product>>() {}.type
        val products = Gson().fromJson<List<Product>>(productsJson, listType)
        val order = products.filterNot { it.numberOfOrder==0}

        val totalPrice = calculate(order)
        totalPriceTextView.text = "本日のお会計総額は、" + totalPrice.toString() + "yen"

        orderListView?.adapter = OrderAdapter(this, order)

        payButton.setOnClickListener{
            val deposit = depositEditText.text.toString()
            val returnMoney =  Integer.parseInt(deposit) - totalPrice
            val intent = Intent(this, CompleteActivity::class.java)
            intent.putExtra("returnMoney", returnMoney)
            startActivity(intent)
        }


    }
}
