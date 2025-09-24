// Proxy Pattern Example in Kotlin
// Image viewer with lazy-loading proxy

interface Image { fun display() }

class RealImage(private val filename: String) : Image {
    init { println("Loading image: $filename") }
    override fun display() = println("Displaying: $filename")
}

class ProxyImage(private val filename: String) : Image {
    private var real: RealImage? = null
    override fun display() {
        if (real == null) real = RealImage(filename)
        real!!.display()
    }
}

fun main(){ val img: Image = ProxyImage("photo.jpg"); img.display(); img.display() }
