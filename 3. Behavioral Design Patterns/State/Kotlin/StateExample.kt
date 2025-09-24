// State Pattern Example in Kotlin
// TrafficLight cycles through Red, Yellow, Green states

interface TrafficLightState { fun next(context: TrafficLight); fun getColor(): String }

class TrafficLight { private var state: TrafficLightState = RedState(); fun setState(s: TrafficLightState){ state = s }; fun next(){ state.next(this) }; fun getColor() = state.getColor() }

class RedState : TrafficLightState { override fun next(t: TrafficLight) = t.setState(GreenState()); override fun getColor() = "Red" }
class YellowState : TrafficLightState { override fun next(t: TrafficLight) = t.setState(RedState()); override fun getColor() = "Yellow" }
class GreenState : TrafficLightState { override fun next(t: TrafficLight) = t.setState(YellowState()); override fun getColor() = "Green" }

fun main(){
    val light = TrafficLight()
    repeat(6){ println("Light: ${light.getColor()}"); light.next() }
}
