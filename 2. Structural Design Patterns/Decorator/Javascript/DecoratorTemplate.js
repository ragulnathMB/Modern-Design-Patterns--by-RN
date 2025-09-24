// Decorator Pattern – JavaScript Template

class Component {
  operation() {}
}

class ConcreteComponent extends Component {
  operation() {
    /* base work */
  }
}

class BaseDecorator extends Component {
  constructor(wrap) {
    super();
    this.wrap = wrap;
  }

  operation() {
    this.wrap.operation();
  }
}

class ConcreteDecoratorA extends BaseDecorator {
  operation() {
    /* extra A */
    super.operation();
  }
}

class ConcreteDecoratorB extends BaseDecorator {
  operation() {
    /* extra B */
    super.operation();
  }
}

(function main() {
  const c = new ConcreteDecoratorB(
    new ConcreteDecoratorA(new ConcreteComponent())
  );
  c.operation();
})();
