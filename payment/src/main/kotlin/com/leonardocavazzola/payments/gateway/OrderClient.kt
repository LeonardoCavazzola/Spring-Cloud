package com.leonardocavazzola.payments.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import java.util.*

@FeignClient("order-service/orders")
interface OrderClient {
    @PutMapping("/{id}/paid_out")
    fun setPaidOut(@PathVariable id: UUID): OrderOutput
}
