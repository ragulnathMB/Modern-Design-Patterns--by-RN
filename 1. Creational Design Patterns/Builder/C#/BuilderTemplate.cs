// Builder Pattern – C# Template
using System;

namespace BuilderTemplate
{
    // Product
    class Product { /* ... */ }

    // Builder Interface
    interface IBuilder
    {
        void BuildPartA();
        void BuildPartB();
        Product GetResult();
    }

    // Concrete Builder
    class ConcreteBuilder : IBuilder
    {
        private readonly Product _product = new Product();
        public void BuildPartA() { /* ... */ }
        public void BuildPartB() { /* ... */ }
        public Product GetResult() => _product;
    }

    // Director
    class Director
    {
        public void Construct(IBuilder builder)
        {
            builder.BuildPartA();
            builder.BuildPartB();
        }
    }

    class Program
    {
        static void Main()
        {
            var builder = new ConcreteBuilder();
            new Director().Construct(builder);
            var product = builder.GetResult();
        }
    }
}
