// Bridge Pattern – C# Template
// Abstraction and Implementor are separated to vary independently.

namespace BridgeTemplate
{
    interface IImplementor { void OpImpl(); }
    class ConcreteImplementorA : IImplementor { public void OpImpl() { /* ... */ } }

    class Abstraction
    {
        protected readonly IImplementor impl;
        public Abstraction(IImplementor impl) { this.impl = impl; }
        public virtual void Operation() { impl.OpImpl(); }
    }

    class RefinedAbstraction : Abstraction
    {
        public RefinedAbstraction(IImplementor impl) : base(impl) {}
        public override void Operation() { base.Operation(); }
    }

    class Program { static void Main(){ var a = new RefinedAbstraction(new ConcreteImplementorA()); a.Operation(); } }
}
