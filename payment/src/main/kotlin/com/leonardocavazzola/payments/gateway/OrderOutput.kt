package com.leonardocavazzola.payments.gateway

import java.util.*

data class OrderOutput(
    val id: UUID,
    val status: StatusOutput,
    val items: List<ItemOutput>,
)
