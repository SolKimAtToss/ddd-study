package sol.kim.dddstudy.order.domain.entity

import sol.kim.dddstudy.order.domain.value.Option
import sol.kim.dddstudy.shared.Entity

class LineItem(
    override val id: Long = 0,
    val orderId: Long,
    val itemId: Long,
    val name: String,
    val itemPrice: Long,
    val options: List<Option>
) : Entity {
    val amount = itemPrice + options.sumOf { it.price }
}
