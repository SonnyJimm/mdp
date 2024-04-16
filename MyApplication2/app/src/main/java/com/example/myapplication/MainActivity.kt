package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val orders = generateDummyOrders()
        orderAdapter = OrderAdapter(orders)
        recyclerView.adapter = orderAdapter
    }

    private fun generateDummyOrders(): List<Order> {
        val orders = ArrayList<Order>()
        for (i in 20240301..20240320) {
            orders.add(Order("Order #$i", "Total", "$ ${i % 10 * 3 }"))
        }
        return orders
    }
}