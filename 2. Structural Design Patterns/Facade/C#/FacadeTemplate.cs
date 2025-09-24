// Facade Pattern – C# Template

namespace FacadeTemplate
{
    class SubsystemA { public void OpA(){ /* ... */ } }
    class SubsystemB { public void OpB(){ /* ... */ } }
    class SubsystemC { public void OpC(){ /* ... */ } }

    class Facade
    {
        private readonly SubsystemA a = new();
        private readonly SubsystemB b = new();
        private readonly SubsystemC c = new();
        public void DoWork(){ a.OpA(); b.OpB(); c.OpC(); }
    }

    class Program { static void Main(){ var f = new Facade(); f.DoWork(); } }
}
