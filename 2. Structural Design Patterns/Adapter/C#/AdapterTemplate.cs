// Adapter Pattern – C# Template
// Convert the interface of a class into another interface clients expect.

namespace AdapterTemplate
{
    interface ITarget { void Request(); }

    class Adaptee { public void SpecificRequest() { /* ... */ } }

    class Adapter : ITarget
    {
        private readonly Adaptee _adaptee = new Adaptee();
        public void Request() => _adaptee.SpecificRequest();
    }

    class Program { static void Main(){ ITarget target = new Adapter(); target.Request(); } }
}
