// State Pattern Example in JavaScript
// TrafficLight cycles through Red, Yellow, Green states

class TrafficLightState { next(context){} getColor(){} }

class TrafficLight {
  constructor(){ this.state = new RedState() }
  setState(s){ this.state = s }
  next(){ this.state.next(this) }
  getColor(){ return this.state.getColor() }
}

class RedState extends TrafficLightState { next(t){ t.setState(new GreenState()) } getColor(){ return 'Red' } }
class YellowState extends TrafficLightState { next(t){ t.setState(new RedState()) } getColor(){ return 'Yellow' } }
class GreenState extends TrafficLightState { next(t){ t.setState(new YellowState()) } getColor(){ return 'Green' } }

;(function main(){
  const light = new TrafficLight()
  for(let i=0;i<6;i++){ console.log(`Light: ${light.getColor()}`); light.next() }
})()
