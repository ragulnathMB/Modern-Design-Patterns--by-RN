// Template Method Pattern – Java Template

abstract class AbstractClass {
    public final void templateMethod() { stepOne(); stepTwo(); hook(); }
    protected abstract void stepOne();
    protected abstract void stepTwo();
    protected void hook() { /* optional override */ }
}

class ConcreteClassA extends AbstractClass {
    protected void stepOne() { System.out.println("A: Step 1"); }
    protected void stepTwo() { System.out.println("A: Step 2"); }
}

class ConcreteClassB extends AbstractClass {
    protected void stepOne() { System.out.println("B: Step 1"); }
    protected void stepTwo() { System.out.println("B: Step 2"); }
    protected void hook() { System.out.println("B: Hook"); }
}

public class TemplateMethodTemplate {
    public static void main(String[] args) { new ConcreteClassA().templateMethod(); new ConcreteClassB().templateMethod(); }
}
