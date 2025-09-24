// Template Method Pattern – JavaScript Template

class AbstractClass {
  templateMethod() { this.stepOne(); this.stepTwo(); this.hook() }
  stepOne() { throw new Error('Abstract method') }
  stepTwo() { throw new Error('Abstract method') }
  hook() { /* optional override */ }
}

class ConcreteClassA extends AbstractClass {
  stepOne() { console.log('A: Step 1') }
  stepTwo() { console.log('A: Step 2') }
}

class ConcreteClassB extends AbstractClass {
  stepOne() { console.log('B: Step 1') }
  stepTwo() { console.log('B: Step 2') }
  hook() { console.log('B: Hook') }
}

;(function main() { new ConcreteClassA().templateMethod(); new ConcreteClassB().templateMethod() })()
