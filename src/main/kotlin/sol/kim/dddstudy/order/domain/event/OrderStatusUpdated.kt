package sol.kim.dddstudy.order.domain.event

import sol.kim.dddstudy.order.domain.OrderStatus
import sol.kim.dddstudy.shared.DomainEvent

data class OrderStatusUpdated(
    val orderId: Long,
    val status: OrderStatus,
) : DomainEvent
