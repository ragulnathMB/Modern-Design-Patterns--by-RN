// Factory Method Pattern – C# Template
using System;
namespace FactoryMethodTemplate
{
    interface IProduct { }
    abstract class Creator { public abstract IProduct FactoryMethod(); }
    class ConcreteCreator : Creator { public override IProduct FactoryMethod() => new ConcreteProduct(); }
    class ConcreteProduct : IProduct {}
    class Program { static void Main() { var creator = new ConcreteCreator(); var product = creator.FactoryMethod(); } }
}
