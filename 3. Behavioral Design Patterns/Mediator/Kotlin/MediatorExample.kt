// Mediator Pattern Example in Kotlin
// Chat room where users send messages through a mediator

interface ChatRoom { fun sendMessage(message: String, user: User); fun addUser(user: User) }

abstract class User(val name: String, protected val chatRoom: ChatRoom) {
    abstract fun send(message: String)
    abstract fun receive(message: String, from: String)
}

class ConcreteUser(name: String, chatRoom: ChatRoom) : User(name, chatRoom) {
    override fun send(message: String) = chatRoom.sendMessage(message, this)
    override fun receive(message: String, from: String) = println("$name received: $message (from $from)")
}

class ConcreteChatRoom : ChatRoom {
    private val users = mutableListOf<User>()
    override fun addUser(user: User) = users.add(user).let {}
    override fun sendMessage(message: String, sender: User) {
        users.filter { it != sender }.forEach { it.receive(message, sender.name) }
    }
}

fun main() {
    val chatRoom = ConcreteChatRoom()
    val alice = ConcreteUser("Alice", chatRoom)
    val bob = ConcreteUser("Bob", chatRoom)
    val charlie = ConcreteUser("Charlie", chatRoom)
    chatRoom.addUser(alice)
    chatRoom.addUser(bob)
    chatRoom.addUser(charlie)

    alice.send("Hello everyone!")
    bob.send("Hi Alice!")
}
