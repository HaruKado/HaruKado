package com.example.myapplication

import java.io.Serializable

data class Product (
    val price: Int,
    val name: String,
    var numberOfOrder: Int
):Serializable



fun callList(/*position:Int, numberChange: Int*/):List<Product> {
    val products = mutableListOf(
        Product(500, "カルビ", 0),
        Product(800, "ハラミ", 0),
        Product(1000, "ロース", 0),
        Product(1000, "牛タン", 0),
        Product(700, "トンたん", 0),
        Product(600, "牛ホルモン", 0)
    )

    return products
}

fun calculate(order:List<Product>):Int {
    var totalPrice = 0

    for (i in 0..order.size-1)  {
        totalPrice += order[i].price * order[i].numberOfOrder
    }


    return totalPrice
}






