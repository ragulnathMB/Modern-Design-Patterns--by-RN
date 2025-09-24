// Observer Pattern – TypeScript Template

interface Observer { update(): void }
interface Subject { attach(o: Observer): void; detach(o: Observer): void; notify(): void }

class ConcreteSubject implements Subject {
  private observers: Observer[] = []
  attach(o: Observer){ this.observers.push(o) }
  detach(o: Observer){ this.observers = this.observers.filter(obs => obs !== o) }
  notify(){ for(const o of this.observers) o.update() }
  doSomething(){ /* change state */ this.notify() }
}

class ConcreteObserver implements Observer { update(){ /* react to change */ } }

;(function main(){ const s = new ConcreteSubject(); s.attach(new ConcreteObserver()); s.doSomething() })()

export {}
