package com.leonardocavazzola.order.repository

import com.leonardocavazzola.order.model.Order
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface OrderRepository : MongoRepository<Order, UUID>
