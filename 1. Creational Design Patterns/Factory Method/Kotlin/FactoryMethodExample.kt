// Factory Method – Kotlin Example
interface Transport {
    fun deliver()
}

class Truck : Transport {
    override fun deliver() = println("Deliver by land in a box.")
}

class Ship : Transport {
    override fun deliver() = println("Deliver by sea in a container.")
}

abstract class Logistics {
    fun planDelivery() {
        createTransport().deliver()
    }
    protected abstract fun createTransport(): Transport
}

class RoadLogistics : Logistics() {
    override fun createTransport() = Truck()
}

class SeaLogistics : Logistics() {
    override fun createTransport() = Ship()
}

fun main(args: Array<String>) {
    val l: Logistics = if (args.isNotEmpty() && args[0] == "sea") {
        SeaLogistics()
    } else {
        RoadLogistics()
    }
    l.planDelivery()
}
