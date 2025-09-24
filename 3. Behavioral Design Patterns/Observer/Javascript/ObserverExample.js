// Observer Pattern Example in JavaScript
// WeatherStation notifies Display observers when temperature changes

class Observer { update(temperature){} }
class Subject { attach(o){}; detach(o){}; notify(){} }

class WeatherStation extends Subject {
  constructor(){ super(); this.observers = []; this.temperature = 0; }
  attach(o){ this.observers.push(o) }
  detach(o){ this.observers = this.observers.filter(obs => obs !== o) }
  notify(){ for(const o of this.observers) o.update(this.temperature) }
  setTemperature(temp){ this.temperature = temp; this.notify() }
}

class PhoneDisplay extends Observer { update(temp){ console.log(`Phone: Temperature is ${temp}°C`) } }
class WindowDisplay extends Observer { update(temp){ console.log(`Window: Temperature is ${temp}°C`) } }

;(function main(){
  const station = new WeatherStation()
  const phone = new PhoneDisplay()
  const window = new WindowDisplay()
  station.attach(phone)
  station.attach(window)
  station.setTemperature(25.5)
  station.setTemperature(30.2)
})()
