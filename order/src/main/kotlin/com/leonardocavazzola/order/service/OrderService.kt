package com.leonardocavazzola.order.service

import com.leonardocavazzola.order.model.Order
import com.leonardocavazzola.order.model.Status
import com.leonardocavazzola.order.repository.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    fun findAll(): List<Order> = orderRepository.findAll()

    fun findById(id: UUID): Order = orderRepository.findByIdOrNull(id) ?: throw Exception()

    fun create(order: Order): Order = orderRepository.save(order)

    fun setAsPaidOut(id: UUID): Order = findById(id).setAsPaidOut()
        .let { orderRepository.save(it) }
}
