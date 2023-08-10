package sol.kim.dddstudy.delivery.domain.entity

import sol.kim.dddstudy.delivery.domain.DeliveryStatus
import sol.kim.dddstudy.delivery.domain.event.DeliveryStatusUpdated
import sol.kim.dddstudy.shared.AggregateRoot

class Delivery(
    override val id: Long = 0,
    val orderId: Long,
    val customerId: Long,
    var deliveryPersonId: Long,
    var status: DeliveryStatus,
    val address: String,
) : AggregateRoot() {
    fun assignDeliveryPerson(deliveryPersonId: Long) {
        this.deliveryPersonId = deliveryPersonId
        status = DeliveryStatus.ASSIGNED
        registerDeliveryStatusUpdatedEvent()
    }

    fun startDelivery() {
        status = DeliveryStatus.DELIVERING
        registerDeliveryStatusUpdatedEvent()
    }

    fun completeDelivery() {
        status = DeliveryStatus.COMPLETED
        registerDeliveryStatusUpdatedEvent()
    }

    private fun registerDeliveryStatusUpdatedEvent() {
        registerEvent(
            DeliveryStatusUpdated(
                deliveryId = id,
                status = status
            )
        )
    }
}