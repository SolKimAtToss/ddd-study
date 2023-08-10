package sol.kim.dddstudy.payment.domain.entity

import sol.kim.dddstudy.shared.Entity

class Payment(
    override val id: Long = 0,
    val amount: Long,
) : Entity