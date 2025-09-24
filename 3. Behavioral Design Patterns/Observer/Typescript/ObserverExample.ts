// Observer Pattern Example in TypeScript
// WeatherStation notifies Display observers when temperature changes

interface Observer { update(temperature: number): void }
interface Subject { attach(o: Observer): void; detach(o: Observer): void; notify(): void }

class WeatherStation implements Subject {
  private observers: Observer[] = []
  private temperature = 0
  attach(o: Observer){ this.observers.push(o) }
  detach(o: Observer){ this.observers = this.observers.filter(obs => obs !== o) }
  notify(){ for(const o of this.observers) o.update(this.temperature) }
  setTemperature(temp: number){ this.temperature = temp; this.notify() }
}

class PhoneDisplay implements Observer { update(temp: number){ console.log(`Phone: Temperature is ${temp}°C`) } }
class WindowDisplay implements Observer { update(temp: number){ console.log(`Window: Temperature is ${temp}°C`) } }

;(function main(){
  const station = new WeatherStation()
  const phone = new PhoneDisplay()
  const window = new WindowDisplay()
  station.attach(phone)
  station.attach(window)
  station.setTemperature(25.5)
  station.setTemperature(30.2)
})()

export {}
