package sol.kim.dddstudy.order.domain.entity

import sol.kim.dddstudy.order.domain.OrderStatus
import sol.kim.dddstudy.order.domain.event.OrderPlaced
import sol.kim.dddstudy.order.domain.event.OrderStatusUpdated
import sol.kim.dddstudy.shared.AggregateRoot

class Order(
    override val id: Long = 0,
    val customerId: Long,
    val lineItems: List<LineItem>,
    val address: String,
    var status: OrderStatus,
) : AggregateRoot() {
    init {
        registerEvent(
            OrderPlaced(
                orderId = id,
                customerId = customerId,
                amount = lineItems.sumOf { it.amount }
            )
        )
    }

    fun partiallyPaid() {
        status = OrderStatus.PAYMENT_ONGOING
        registerOrderStatusUpdatedEvent()
    }

    fun fullyPaid() {
        status = OrderStatus.PAYMENT_COMPLETED
        registerOrderStatusUpdatedEvent()
    }

    fun deliveryStarted() {
        status = OrderStatus.DELIVERING
        registerOrderStatusUpdatedEvent()
    }

    fun deliveryCompleted() {
        status = OrderStatus.COMPLETED
        registerOrderStatusUpdatedEvent()
    }

    private fun registerOrderStatusUpdatedEvent() {
        registerEvent(
            OrderStatusUpdated(
                orderId = id,
                status = status
            )
        )
    }
}
