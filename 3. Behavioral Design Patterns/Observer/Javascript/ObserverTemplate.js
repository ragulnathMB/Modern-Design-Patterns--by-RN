// Observer Pattern – JavaScript Template

class Observer { update(){} }
class Subject { attach(o){}; detach(o){}; notify(){} }

class ConcreteSubject extends Subject {
  constructor(){ super(); this.observers = [] }
  attach(o){ this.observers.push(o) }
  detach(o){ this.observers = this.observers.filter(obs => obs !== o) }
  notify(){ for(const o of this.observers) o.update() }
  doSomething(){ /* change state */ this.notify() }
}

class ConcreteObserver extends Observer { update(){ /* react to change */ } }

;(function main(){ const s = new ConcreteSubject(); s.attach(new ConcreteObserver()); s.doSomething() })()
