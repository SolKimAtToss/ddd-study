package sol.kim.dddstudy.payment.domain.event

import sol.kim.dddstudy.shared.DomainEvent

data class PartiallyPaid(
    val orderId: Long,
) : DomainEvent