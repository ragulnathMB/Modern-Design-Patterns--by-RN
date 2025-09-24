// Template Method Pattern – TypeScript Template

abstract class AbstractClass {
  templateMethod(): void { this.stepOne(); this.stepTwo(); this.hook() }
  protected abstract stepOne(): void
  protected abstract stepTwo(): void
  protected hook(): void { /* optional override */ }
}

class ConcreteClassA extends AbstractClass {
  protected stepOne(): void { console.log('A: Step 1') }
  protected stepTwo(): void { console.log('A: Step 2') }
}

class ConcreteClassB extends AbstractClass {
  protected stepOne(): void { console.log('B: Step 1') }
  protected stepTwo(): void { console.log('B: Step 2') }
  protected hook(): void { console.log('B: Hook') }
}

;(function main() { new ConcreteClassA().templateMethod(); new ConcreteClassB().templateMethod() })()

export {}
