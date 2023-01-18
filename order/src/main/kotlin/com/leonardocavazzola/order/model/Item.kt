package com.leonardocavazzola.order.model

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
class Item(
    val amount: BigDecimal,
    val name: String,
)
