// Memento Pattern – TypeScript Template

class Memento {
  constructor(private state: string) {}
  getState(): string { return this.state }
}

class Originator {
  private state = ''
  setState(state: string): void { this.state = state }
  getState(): string { return this.state }
  createMemento(): Memento { return new Memento(this.state) }
  restoreMemento(memento: Memento): void { this.state = memento.getState() }
}

class Caretaker {
  private mementos: Memento[] = []
  saveState(originator: Originator): void { this.mementos.push(originator.createMemento()) }
  restoreState(originator: Originator): void { if (this.mementos.length > 0) originator.restoreMemento(this.mementos.pop()!) }
}

;(function main() {
  const originator = new Originator()
  const caretaker = new Caretaker()
  originator.setState('State1')
  caretaker.saveState(originator)
  originator.setState('State2')
  caretaker.restoreState(originator)
})()

export {}
