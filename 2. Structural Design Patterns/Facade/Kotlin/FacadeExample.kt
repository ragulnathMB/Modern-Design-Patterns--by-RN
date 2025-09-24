// Facade Pattern Example in Kotlin
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

class CPU { fun freeze()=println("CPU: freeze"); fun jump(position: Long)=println("CPU: jump to $position"); fun execute()=println("CPU: execute") }
class Memory { fun load(position: Long, data: ByteArray)=println("Memory: load ${data.size} bytes at $position") }
class HardDrive { fun read(lba: Long, size: Int): ByteArray { println("HardDrive: read $size bytes from LBA $lba"); return ByteArray(size) } }

class Computer {
    private val cpu = CPU(); private val memory = Memory(); private val hardDrive = HardDrive()
    fun start(){ cpu.freeze(); val boot = hardDrive.read(0,1024); memory.load(0, boot); cpu.jump(0); cpu.execute() }
    fun shutdown(){ println("Computer: shutdown sequence") }
}

fun main(){ val c = Computer(); c.start(); c.shutdown() }
