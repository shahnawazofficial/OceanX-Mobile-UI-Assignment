package com.oceanx.agency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.oceanx.agency.R
import com.oceanx.agency.databinding.ItemOrderBinding
import com.oceanx.agency.model.Order
import com.oceanx.agency.model.OrderStatus

class OrderAdapter(private var orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        with(holder.binding) {
            tvVehicleType.text = order.vehicleType
            tvDateTime.text = "${order.dateTime}  |  Order ID: ${order.orderId}"
            tvPickupLocation.text = order.pickupLocation
            tvDropLocation.text = order.dropLocation
            tvAmount.text = order.amount

            // Status badge
            when (order.status) {
                OrderStatus.CANCELLED -> {
                    tvStatus.text = "CANCELLED"
                    tvStatus.setTextColor(
                        ContextCompat.getColor(root.context, R.color.cancelled_red)
                    )
                    tvStatus.setBackgroundResource(R.drawable.bg_status_cancelled)
                    tvStatus.visibility = View.VISIBLE
                }
                OrderStatus.COMPLETED -> {
                    tvStatus.text = "COMPLETED"
                    tvStatus.setTextColor(
                        ContextCompat.getColor(root.context, R.color.green_dot)
                    )
                    tvStatus.setBackgroundResource(R.drawable.bg_status_completed)
                    tvStatus.visibility = View.VISIBLE
                }
                OrderStatus.ONGOING -> {
                    tvStatus.visibility = View.GONE
                }
            }

            btnInvoice.setOnClickListener {
                Toast.makeText(
                    root.context,
                    "Downloading Invoice: ${order.orderId}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            btnBookAgain.setOnClickListener {
                Toast.makeText(
                    root.context,
                    "Booking again: ${order.orderId}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            btnMore.setOnClickListener {
                Toast.makeText(root.context, "More options", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = orders.size

    fun updateList(newList: List<Order>) {
        orders = newList
        notifyDataSetChanged()
    }
}