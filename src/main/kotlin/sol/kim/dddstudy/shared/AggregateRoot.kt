package sol.kim.dddstudy.shared

abstract class AggregateRoot : Entity {
    private val domainEvents: MutableList<DomainEvent> = mutableListOf()

    protected fun registerEvent(event: DomainEvent) {
        domainEvents.add(event)
    }

    fun getUnpublishedEvents(): List<DomainEvent> {
        return domainEvents.toList()
    }

    fun clearEvents() {
        domainEvents.clear()
    }
}