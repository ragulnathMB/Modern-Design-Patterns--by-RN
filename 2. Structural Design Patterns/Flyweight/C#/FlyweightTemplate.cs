// Flyweight Pattern – C# Template

using System.Collections.Generic;

namespace FlyweightTemplate
{
    class Flyweight { /* intrinsic, immutable data */ }

    static class FlyweightFactory
    {
        private static readonly Dictionary<string, Flyweight> cache = new();
        public static Flyweight Get(string key)
        {
            if (!cache.TryGetValue(key, out var fw))
            {
                fw = new Flyweight();
                cache[key] = fw;
            }
            return fw;
        }
    }

    class Context
    {
        private readonly Flyweight _fw;
        public Context(string key) { _fw = FlyweightFactory.Get(key); }
        public void Operation(/* extrinsic params */) { /* use _fw + extrinsic */ }
    }

    class Program { static void Main(){ var c = new Context("key"); c.Operation(); } }
}
