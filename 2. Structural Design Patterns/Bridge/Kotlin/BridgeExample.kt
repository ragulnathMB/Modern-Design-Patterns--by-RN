// Bridge Pattern Example in Kotlin
// Abstraction: Remote; Implementor: Device (TV/Radio)

interface Device {
    fun isEnabled(): Boolean
    fun enable()
    fun disable()
    fun setVolume(v: Int)
    fun getVolume(): Int
}

class TV : Device {
    private var on = false
    private var vol = 10
    override fun isEnabled() = on
    override fun enable() { on = true }
    override fun disable() { on = false }
    override fun setVolume(v: Int) { vol = v.coerceIn(0, 100) }
    override fun getVolume() = vol
}

class Radio : Device {
    private var on = false
    private var vol = 20
    override fun isEnabled() = on
    override fun enable() { on = true }
    override fun disable() { on = false }
    override fun setVolume(v: Int) { vol = v.coerceIn(0, 100) }
    override fun getVolume() = vol
}

open class Remote(protected val device: Device) {
    fun togglePower() { if (device.isEnabled()) device.disable() else device.enable() }
    fun volumeUp() { device.setVolume(device.getVolume()+10) }
    fun volumeDown() { device.setVolume(device.getVolume()-10) }
}

class AdvancedRemote(device: Device): Remote(device) {
    fun mute() { device.setVolume(0) }
}

fun main() {
    val tv: Device = TV()
    val r = Remote(tv)
    r.togglePower(); r.volumeUp()
    println("TV on=${tv.isEnabled()} vol=${tv.getVolume()}")

    val radio: Device = Radio()
    val ar = AdvancedRemote(radio)
    ar.togglePower(); ar.mute()
    println("Radio on=${radio.isEnabled()} vol=${radio.getVolume()}")
}
