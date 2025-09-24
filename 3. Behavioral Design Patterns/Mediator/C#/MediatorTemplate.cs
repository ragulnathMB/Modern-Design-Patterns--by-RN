// Mediator Pattern – C# Template

using System.Collections.Generic;

namespace MediatorTemplate
{
    interface IMediator { void Notify(object sender, string eventType); }

    abstract class Colleague
    {
        protected IMediator mediator;
        public Colleague(IMediator mediator) { this.mediator = mediator; }
        public abstract void DoSomething();
    }

    class ConcreteColleagueA : Colleague
    {
        public ConcreteColleagueA(IMediator mediator) : base(mediator) {}
        public override void DoSomething() { mediator.Notify(this, "EventA"); }
    }

    class ConcreteColleagueB : Colleague
    {
        public ConcreteColleagueB(IMediator mediator) : base(mediator) {}
        public override void DoSomething() { mediator.Notify(this, "EventB"); }
    }

    class ConcreteMediator : IMediator
    {
        private readonly List<Colleague> colleagues = new();
        public void AddColleague(Colleague colleague) { colleagues.Add(colleague); }
        public void Notify(object sender, string eventType) { /* handle event */ }
    }

    class Program
    {
        static void Main()
        {
            var mediator = new ConcreteMediator();
            var colleagueA = new ConcreteColleagueA(mediator);
            var colleagueB = new ConcreteColleagueB(mediator);
            mediator.AddColleague(colleagueA);
            mediator.AddColleague(colleagueB);
            colleagueA.DoSomething();
        }
    }
}
