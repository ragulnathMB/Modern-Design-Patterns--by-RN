// Visitor Pattern – C# Template

namespace VisitorTemplate
{
    interface IVisitor
    {
        void Visit(ConcreteElementA element);
        void Visit(ConcreteElementB element);
    }

    interface IElement
    {
        void Accept(IVisitor visitor);
    }

    class ConcreteElementA : IElement
    {
        public void Accept(IVisitor visitor) { visitor.Visit(this); }
        public void OperationA() { /* specific to A */ }
    }

    class ConcreteElementB : IElement
    {
        public void Accept(IVisitor visitor) { visitor.Visit(this); }
        public void OperationB() { /* specific to B */ }
    }

    class ConcreteVisitor1 : IVisitor
    {
        public void Visit(ConcreteElementA element) { element.OperationA(); /* visitor 1 logic */ }
        public void Visit(ConcreteElementB element) { element.OperationB(); /* visitor 1 logic */ }
    }

    class ConcreteVisitor2 : IVisitor
    {
        public void Visit(ConcreteElementA element) { element.OperationA(); /* visitor 2 logic */ }
        public void Visit(ConcreteElementB element) { element.OperationB(); /* visitor 2 logic */ }
    }

    class Program
    {
        static void Main()
        {
            IElement[] elements = { new ConcreteElementA(), new ConcreteElementB() };
            var visitor = new ConcreteVisitor1();
            foreach (var element in elements) element.Accept(visitor);
        }
    }
}
