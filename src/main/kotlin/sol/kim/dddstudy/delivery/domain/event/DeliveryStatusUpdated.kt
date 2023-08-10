package sol.kim.dddstudy.delivery.domain.event

import sol.kim.dddstudy.delivery.domain.DeliveryStatus
import sol.kim.dddstudy.shared.DomainEvent

data class DeliveryStatusUpdated(
    val deliveryId: Long,
    val status: DeliveryStatus,
) : DomainEvent