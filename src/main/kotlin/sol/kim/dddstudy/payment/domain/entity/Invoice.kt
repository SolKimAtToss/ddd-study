package sol.kim.dddstudy.payment.domain.entity

import sol.kim.dddstudy.payment.domain.event.FullyPaid
import sol.kim.dddstudy.shared.AggregateRoot

class Invoice(
    override val id: Long = 0,
    val customerId: Long,
    private val orderId: Long,
    private val amount: Long,
    private val payments: MutableList<Payment>
) : AggregateRoot() {
    val paymentRequiredAmount: Long
        get() = amount - payments.sumOf { it.amount }

    fun paymentPlaced(amount: Long) {
        check(amount <= paymentRequiredAmount) { "Payment amount exceeded required amount." }
        payments.add(Payment(amount = amount))

        if (amount == paymentRequiredAmount) {
            registerEvent(FullyPaid(orderId))
        }
    }
}
