// Singleton Pattern Example in Kotlin
// Uses Kotlin's object declaration which is thread-safe and lazy by default.

object AppConfig {
    val connectionString: String = "jdbc:sqlite:app.db"
    fun printConn() = println("Connection: $connectionString")
}

fun main() {
    val a = AppConfig
    val b = AppConfig
    println(a === b) // true
    a.printConn()
}
