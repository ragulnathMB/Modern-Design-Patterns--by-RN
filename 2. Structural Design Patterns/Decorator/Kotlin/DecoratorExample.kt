// Decorator Pattern Example in Kotlin
// Notifier: Basic + Email + SMS + Slack decorators

interface Notifier {
    fun send(message: String)
}

class BasicNotifier : Notifier {
    override fun send(message: String) = println("Base notify: $message")
}

open class Decorator(protected val wrap: Notifier) : Notifier {
    override fun send(message: String) = wrap.send(message)
}

class EmailDecorator(w: Notifier) : Decorator(w) {
    override fun send(message: String) {
        println("Email sent: $message")
        super.send(message)
    }
}

class SMSDecorator(w: Notifier) : Decorator(w) {
    override fun send(message: String) {
        println("SMS sent: $message")
        super.send(message)
    }
}

class SlackDecorator(w: Notifier) : Decorator(w) {
    override fun send(message: String) {
        println("Slack message sent: $message")
        super.send(message)
    }
}

fun main() {
    var n: Notifier = BasicNotifier()
    n = EmailDecorator(n)
    n = SMSDecorator(n)
    n = SlackDecorator(n)
    n.send("System maintenance at 2 AM")
}
