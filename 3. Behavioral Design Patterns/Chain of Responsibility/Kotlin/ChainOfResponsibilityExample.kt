// Chain of Responsibility Pattern Example in Kotlin
// Support ticket system with different levels of handlers

abstract class SupportHandler {
    protected var nextHandler: SupportHandler? = null
    fun setNext(handler: SupportHandler) { nextHandler = handler }
    abstract fun handleRequest(ticket: SupportTicket)
}

data class SupportTicket(val issue: String, val priority: Int)

class Level1Support : SupportHandler() {
    override fun handleRequest(ticket: SupportTicket) {
        when {
            ticket.priority <= 1 -> println("Level 1: Handled '${ticket.issue}'")
            nextHandler != null -> nextHandler!!.handleRequest(ticket)
            else -> println("No handler available for '${ticket.issue}'")
        }
    }
}

class Level2Support : SupportHandler() {
    override fun handleRequest(ticket: SupportTicket) {
        when {
            ticket.priority <= 2 -> println("Level 2: Handled '${ticket.issue}'")
            nextHandler != null -> nextHandler!!.handleRequest(ticket)
            else -> println("No handler available for '${ticket.issue}'")
        }
    }
}

class Level3Support : SupportHandler() {
    override fun handleRequest(ticket: SupportTicket) {
        println("Level 3: Handled '${ticket.issue}'")
    }
}

fun main() {
    val level1 = Level1Support()
    val level2 = Level2Support()
    val level3 = Level3Support()
    level1.setNext(level2)
    level2.setNext(level3)

    level1.handleRequest(SupportTicket("Password reset", 1))
    level1.handleRequest(SupportTicket("Software bug", 2))
    level1.handleRequest(SupportTicket("System crash", 3))
}
