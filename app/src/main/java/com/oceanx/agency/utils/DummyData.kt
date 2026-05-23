package com.oceanx.agency.utils

import com.oceanx.agency.model.Order
import com.oceanx.agency.model.OrderStatus

object DummyData {
    fun getOrders(): List<Order> = listOf(
        Order(
            id = "1",
            vehicleType = "Four Wheeler",
            dateTime = "05 Feb, 4:46 PM",
            orderId = "#ORD12345",
            pickupLocation = "741, Gumanwara",
            dropLocation = "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh 284001, India",
            amount = "₹ 229.0",
            status = OrderStatus.CANCELLED
        ),
        Order(
            id = "2",
            vehicleType = "Four Wheeler",
            dateTime = "05 Feb, 4:46 PM",
            orderId = "#ORD12346",
            pickupLocation = "741, Gumanwara",
            dropLocation = "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh 284001, India",
            amount = "₹ 229.0",
            status = OrderStatus.CANCELLED
        ),
        Order(
            id = "3",
            vehicleType = "Four Wheeler",
            dateTime = "05 Feb, 4:46 PM",
            orderId = "#ORD12347",
            pickupLocation = "332, Gumanwara",
            dropLocation = "GC72+GGV, Kamrari, Madhya Pradesh 475661, India",
            amount = "₹ 1515.0",
            status = OrderStatus.CANCELLED
        ),
        Order(
            id = "4",
            vehicleType = "Four Wheeler",
            dateTime = "05 Feb, 4:46 PM",
            orderId = "#ORD12348",
            pickupLocation = "332, Gumanwara",
            dropLocation = "GC72+GGV, Kamrari, Madhya Pradesh 475661, India",
            amount = "₹ 1634.0",
            status = OrderStatus.COMPLETED
        ),
        Order(
            id = "5",
            vehicleType = "Two Wheeler",
            dateTime = "06 Feb, 2:30 PM",
            orderId = "#ORD12349",
            pickupLocation = "MG Road, Bengaluru",
            dropLocation = "Indiranagar, Bengaluru, Karnataka 560038, India",
            amount = "₹ 89.0",
            status = OrderStatus.COMPLETED
        ),
        Order(
            id = "6",
            vehicleType = "Four Wheeler",
            dateTime = "07 Feb, 11:15 AM",
            orderId = "#ORD12350",
            pickupLocation = "Sector 18, Noida",
            dropLocation = "Connaught Place, New Delhi 110001, India",
            amount = "₹ 450.0",
            status = OrderStatus.CANCELLED
        )
    )
}