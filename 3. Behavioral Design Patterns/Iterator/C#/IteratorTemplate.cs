// Iterator Pattern – C# Template

using System.Collections.Generic;

namespace IteratorTemplate
{
    interface IIterator<T>
    {
        bool HasNext();
        T Next();
    }

    interface IAggregate<T>
    {
        IIterator<T> CreateIterator();
    }

    class ConcreteIterator<T> : IIterator<T>
    {
        private readonly List<T> items;
        private int index = 0;
        public ConcreteIterator(List<T> items) { this.items = items; }
        public bool HasNext() => index < items.Count;
        public T Next() => items[index++];
    }

    class ConcreteAggregate<T> : IAggregate<T>
    {
        private readonly List<T> items = new();
        public void Add(T item) { items.Add(item); }
        public IIterator<T> CreateIterator() => new ConcreteIterator<T>(items);
    }

    class Program
    {
        static void Main()
        {
            var aggregate = new ConcreteAggregate<string>();
            aggregate.Add("Item1");
            aggregate.Add("Item2");
            var iterator = aggregate.CreateIterator();
            while (iterator.HasNext()) { var item = iterator.Next(); }
        }
    }
}
