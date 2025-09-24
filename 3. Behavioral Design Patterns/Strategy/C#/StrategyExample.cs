// Strategy Pattern Example in C#
// Sorter context with BubbleSort and QuickSort strategies

using System;
using System.Collections.Generic;

namespace StrategyExample
{
    interface ISortStrategy { IList<int> Sort(IList<int> data); }

    class BubbleSort : ISortStrategy
    {
        public IList<int> Sort(IList<int> data)
        {
            var arr = new List<int>(data);
            for (int i = 0; i < arr.Count; i++)
                for (int j = 0; j < arr.Count - i - 1; j++)
                    if (arr[j] > arr[j + 1]) { (arr[j], arr[j + 1]) = (arr[j + 1], arr[j]); }
            Console.WriteLine("BubbleSort used");
            return arr;
        }
    }

    class QuickSort : ISortStrategy
    {
        public IList<int> Sort(IList<int> data)
        {
            var arr = new List<int>(data);
            arr.Sort(); // use built-in for brevity
            Console.WriteLine("QuickSort used");
            return arr;
        }
    }

    class Sorter
    {
        private ISortStrategy _strategy;
        public Sorter(ISortStrategy strategy) { _strategy = strategy; }
        public void SetStrategy(ISortStrategy strategy) { _strategy = strategy; }
        public IList<int> Sort(IList<int> data) => _strategy.Sort(data);
    }

    class Program
    {
        static void Main()
        {
            var data = new List<int> { 5, 2, 9, 1, 5, 6 };
            var sorter = new Sorter(new BubbleSort());
            Console.WriteLine(string.Join(", ", sorter.Sort(data)));
            sorter.SetStrategy(new QuickSort());
            Console.WriteLine(string.Join(", ", sorter.Sort(data)));
        }
    }
}
