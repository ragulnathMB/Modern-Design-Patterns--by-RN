// Visitor Pattern – Java Template

interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    public void accept(Visitor visitor) { visitor.visit(this); }
    public void operationA() { /* specific to A */ }
}

class ConcreteElementB implements Element {
    public void accept(Visitor visitor) { visitor.visit(this); }
    public void operationB() { /* specific to B */ }
}

class ConcreteVisitor1 implements Visitor {
    public void visit(ConcreteElementA element) { element.operationA(); /* visitor 1 logic */ }
    public void visit(ConcreteElementB element) { element.operationB(); /* visitor 1 logic */ }
}

class ConcreteVisitor2 implements Visitor {
    public void visit(ConcreteElementA element) { element.operationA(); /* visitor 2 logic */ }
    public void visit(ConcreteElementB element) { element.operationB(); /* visitor 2 logic */ }
}

public class VisitorTemplate {
    public static void main(String[] args) {
        Element[] elements = { new ConcreteElementA(), new ConcreteElementB() };
        Visitor visitor = new ConcreteVisitor1();
        for (Element element : elements) element.accept(visitor);
    }
}
