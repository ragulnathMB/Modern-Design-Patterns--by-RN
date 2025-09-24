// Observer Pattern – C# Template

using System.Collections.Generic;

namespace ObserverTemplate
{
    interface IObserver { void Update(); }
    interface ISubject { void Attach(IObserver o); void Detach(IObserver o); void Notify(); }

    class ConcreteSubject : ISubject
    {
        private readonly List<IObserver> _observers = new();
        public void Attach(IObserver o) => _observers.Add(o);
        public void Detach(IObserver o) => _observers.Remove(o);
        public void Notify() { foreach (var o in _observers) o.Update(); }
        public void DoSomething() { /* change state */ Notify(); }
    }

    class ConcreteObserver : IObserver { public void Update() { /* react to change */ } }

    class Program { static void Main(){ var s = new ConcreteSubject(); s.Attach(new ConcreteObserver()); s.DoSomething(); } }
}
