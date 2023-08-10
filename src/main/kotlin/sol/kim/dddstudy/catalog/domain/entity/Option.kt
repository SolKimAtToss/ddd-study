package sol.kim.dddstudy.catalog.domain.entity

import sol.kim.dddstudy.shared.Entity

class Option(
    override val id: Long,
    val name: String,
    val price: Long,
) : Entity