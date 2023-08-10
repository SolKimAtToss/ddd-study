package sol.kim.dddstudy.catalog.domain.entity

import sol.kim.dddstudy.shared.Entity

class Item(
    override val id: Long = 0,
    val name: String,
    val price: Long,
    val availableOptions: List<Option>
) : Entity