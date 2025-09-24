// Memento Pattern – JavaScript Template

class Memento {
  constructor(state) { this.state = state }
  getState() { return this.state }
}

class Originator {
  constructor() { this.state = '' }
  setState(state) { this.state = state }
  getState() { return this.state }
  createMemento() { return new Memento(this.state) }
  restoreMemento(memento) { this.state = memento.getState() }
}

class Caretaker {
  constructor() { this.mementos = [] }
  saveState(originator) { this.mementos.push(originator.createMemento()) }
  restoreState(originator) { if (this.mementos.length > 0) originator.restoreMemento(this.mementos.pop()) }
}

;(function main() {
  const originator = new Originator()
  const caretaker = new Caretaker()
  originator.setState('State1')
  caretaker.saveState(originator)
  originator.setState('State2')
  caretaker.restoreState(originator)
})()
