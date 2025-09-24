// Builder Pattern – Kotlin Example

class Computer(var cpu: String = "", var ram: Int = 0) {
    override fun toString() = "Computer(cpu='$cpu', ram=$ram)"
}

interface ComputerBuilder {
    fun buildCPU()
    fun buildRAM()
    fun getResult(): Computer
}

class GamingPCBuilder : ComputerBuilder {
    private val computer = Computer()
    override fun buildCPU() { computer.cpu = "Intel i9" }
    override fun buildRAM() { computer.ram = 32 }
    override fun getResult() = computer
}

class Director {
    fun construct(builder: ComputerBuilder) {
        builder.buildCPU()
        builder.buildRAM()
    }
}

fun main() {
    val builder: ComputerBuilder = GamingPCBuilder()
    Director().construct(builder)
    println(builder.getResult())
}
