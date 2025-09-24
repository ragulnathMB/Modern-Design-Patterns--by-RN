// Decorator Pattern – TypeScript Template

abstract class Component {
  abstract operation(): void;
}

class ConcreteComponent extends Component {
  operation(): void {
    /* base work */
  }
}

abstract class BaseDecorator extends Component {
  constructor(protected wrap: Component) {
    super();
  }

  operation(): void {
    this.wrap.operation();
  }
}

class ConcreteDecoratorA extends BaseDecorator {
  operation(): void {
    /* extra A */
    super.operation();
  }
}

class ConcreteDecoratorB extends BaseDecorator {
  operation(): void {
    /* extra B */
    super.operation();
  }
}

(function main() {
  const c: Component = new ConcreteDecoratorB(
    new ConcreteDecoratorA(new ConcreteComponent())
  );
  c.operation();
})();

export {};
