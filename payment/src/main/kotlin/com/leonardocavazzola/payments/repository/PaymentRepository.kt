package com.leonardocavazzola.payments.repository

import com.leonardocavazzola.payments.model.Payment
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PaymentRepository : MongoRepository<Payment, UUID>
