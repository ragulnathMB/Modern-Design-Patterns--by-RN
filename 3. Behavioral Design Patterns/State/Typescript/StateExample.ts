// State Pattern Example in TypeScript
// TrafficLight cycles through Red, Yellow, Green states

interface TrafficLightState { next(context: TrafficLight): void; getColor(): string }

class TrafficLight {
  private state: TrafficLightState = new RedState()
  setState(s: TrafficLightState){ this.state = s }
  next(){ this.state.next(this) }
  getColor(): string { return this.state.getColor() }
}

class RedState implements TrafficLightState { next(t: TrafficLight){ t.setState(new GreenState()) } getColor(){ return 'Red' } }
class YellowState implements TrafficLightState { next(t: TrafficLight){ t.setState(new RedState()) } getColor(){ return 'Yellow' } }
class GreenState implements TrafficLightState { next(t: TrafficLight){ t.setState(new YellowState()) } getColor(){ return 'Green' } }

;(function main(){
  const light = new TrafficLight()
  for(let i=0;i<6;i++){ console.log(`Light: ${light.getColor()}`); light.next() }
})()

export {}
