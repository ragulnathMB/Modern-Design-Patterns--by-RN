// Prototype Pattern – C# Template
using System;
namespace PrototypeTemplate
{
    interface IPrototype<T>
    {
        T Clone();
    }
    class ConcretePrototype : IPrototype<ConcretePrototype>
    {
        public int Data;
        public ConcretePrototype Clone() => (ConcretePrototype) MemberwiseClone();
    }
    class Program{ static void Main(){ var original=new ConcretePrototype{Data=42}; var copy=original.Clone(); }}
}
