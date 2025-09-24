// Skeleton / Template file for Abstract Factory in C#
// Fill in concrete products and factories according to your use case.

using System;

namespace AbstractFactoryTemplate
{
    // TODO: Define Product interfaces
    interface IProductA { }
    interface IProductB { }

    // TODO: Implement Concrete Products
    class ConcreteProductA1 : IProductA { }
    class ConcreteProductB1 : IProductB { }

    // TODO: Define Abstract Factory
    interface IAbstractFactory
    {
        IProductA CreateProductA();
        IProductB CreateProductB();
    }

    // TODO: Implement Concrete Factories
    class ConcreteFactory1 : IAbstractFactory
    {
        public IProductA CreateProductA() => new ConcreteProductA1();
        public IProductB CreateProductB() => new ConcreteProductB1();
    }

    class Program
    {
        static void Main()
        {
            // TODO: Client code here
        }
    }
}
