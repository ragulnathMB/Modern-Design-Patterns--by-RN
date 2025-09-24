// Decorator Pattern – C# Template

namespace DecoratorTemplate
{
    interface Component { void Operation(); }
    class ConcreteComponent : Component { public void Operation() { /* base work */ } }

    abstract class BaseDecorator : Component
    {
        protected readonly Component wrappee;
        protected BaseDecorator(Component wrappee) { this.wrappee = wrappee; }
        public virtual void Operation() { wrappee.Operation(); }
    }

    class ConcreteDecoratorA : BaseDecorator
    {
        public ConcreteDecoratorA(Component c) : base(c) {}
        public override void Operation() { /* extra A */ base.Operation(); }
    }

    class ConcreteDecoratorB : BaseDecorator
    {
        public ConcreteDecoratorB(Component c) : base(c) {}
        public override void Operation() { /* extra B */ base.Operation(); }
    }

    class Program { static void Main(){ Component c = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent())); c.Operation(); } }
}
