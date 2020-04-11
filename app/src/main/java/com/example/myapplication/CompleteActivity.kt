package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete.*

class CompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        val returnMoney = intent.extras!!.getInt("returnMoney")
        returnMoneyTextView.text = returnMoney.toString() + "yen"
    }
}
