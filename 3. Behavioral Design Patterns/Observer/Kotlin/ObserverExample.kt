// Observer Pattern Example in Kotlin
// WeatherStation notifies Display observers when temperature changes

interface Observer { fun update(temperature: Float) }
interface Subject { fun attach(o: Observer); fun detach(o: Observer); fun notify() }

class WeatherStation : Subject {
    private val observers = mutableListOf<Observer>()
    private var temperature = 0f
    override fun attach(o: Observer) = observers.add(o).let{}
    override fun detach(o: Observer) = observers.remove(o).let{}
    override fun notify() = observers.forEach { it.update(temperature) }
    fun setTemperature(temp: Float) { temperature = temp; notify() }
}

class PhoneDisplay : Observer { override fun update(temp: Float) = println("Phone: Temperature is ${temp}°C") }
class WindowDisplay : Observer { override fun update(temp: Float) = println("Window: Temperature is ${temp}°C") }

fun main(){
    val station = WeatherStation()
    val phone = PhoneDisplay()
    val window = WindowDisplay()
    station.attach(phone)
    station.attach(window)
    station.setTemperature(25.5f)
    station.setTemperature(30.2f)
}
