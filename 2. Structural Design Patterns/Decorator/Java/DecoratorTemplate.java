// Decorator Pattern – Java Template

interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    public void operation() {
        /* base work */
    }
}

abstract class BaseDecorator implements Component {
    protected final Component wrap;

    BaseDecorator(Component w) {
        this.wrap = w;
    }

    public void operation() {
        wrap.operation();
    }
}

class ConcreteDecoratorA extends BaseDecorator {
    ConcreteDecoratorA(Component w) {
        super(w);
    }

    public void operation() {
        /* extra A */
        super.operation();
    }
}

class ConcreteDecoratorB extends BaseDecorator {
    ConcreteDecoratorB(Component w) {
        super(w);
    }

    public void operation() {
        /* extra B */
        super.operation();
    }
}

public class DecoratorTemplate {
    public static void main(String[] args) {
        Component c = new ConcreteDecoratorB(
                new ConcreteDecoratorA(new ConcreteComponent())
        );
        c.operation();
    }
}
