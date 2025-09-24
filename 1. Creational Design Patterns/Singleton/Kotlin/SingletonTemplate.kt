// Singleton Pattern – Kotlin Template
// Kotlin object declaration is a concise, thread-safe singleton.

object Singleton {
    fun doWork() { /* ... */ }
}

fun main() {
    val s = Singleton
    s.doWork()
}
