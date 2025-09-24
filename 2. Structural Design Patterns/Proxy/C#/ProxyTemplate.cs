// Proxy Pattern – C# Template

namespace ProxyTemplate
{
    interface ISubject { void Request(); }

    class RealSubject : ISubject
    {
        public void Request() { /* heavy work */ }
    }

    class Proxy : ISubject
    {
        private RealSubject _real;
        public void Request()
        {
            _real ??= new RealSubject();
            // extra checks/logging/caching
            _real.Request();
        }
    }

    class Program { static void Main(){ ISubject s = new Proxy(); s.Request(); } }
}
