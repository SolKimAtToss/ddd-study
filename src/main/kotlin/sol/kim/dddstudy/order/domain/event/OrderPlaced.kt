package sol.kim.dddstudy.order.domain.event

import sol.kim.dddstudy.shared.DomainEvent

data class OrderPlaced(
    val orderId: Long,
    val customerId: Long,
    val amount: Long,
) : DomainEvent
