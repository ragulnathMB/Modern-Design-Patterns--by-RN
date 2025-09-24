// Strategy Pattern – C# Template

using System.Collections.Generic;

namespace StrategyTemplate
{
    interface IStrategy { IList<int> Execute(IList<int> data); }
    class ConcreteStrategyA : IStrategy { public IList<int> Execute(IList<int> data){ return data; } }
    class ConcreteStrategyB : IStrategy { public IList<int> Execute(IList<int> data){ return data; } }

    class Context
    {
        private IStrategy _strategy;
        public Context(IStrategy strategy){ _strategy = strategy; }
        public void SetStrategy(IStrategy strategy){ _strategy = strategy; }
        public IList<int> DoWork(IList<int> data) => _strategy.Execute(data);
    }

    class Program { static void Main(){ var ctx = new Context(new ConcreteStrategyA()); ctx.DoWork(new List<int>()); } }
}
