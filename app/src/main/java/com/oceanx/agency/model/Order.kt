package com.oceanx.agency.model

data class Order(
    val id: String,
    val vehicleType: String,
    val dateTime: String,
    val orderId: String,
    val pickupLocation: String,
    val dropLocation: String,
    val amount: String,
    val status: OrderStatus
)

enum class OrderStatus {
    CANCELLED, COMPLETED, ONGOING
}