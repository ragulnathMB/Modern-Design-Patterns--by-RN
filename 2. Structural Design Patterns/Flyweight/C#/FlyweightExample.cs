// Flyweight Pattern Example in C#
// Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

using System;
using System.Collections.Generic;

namespace FlyweightExample
{
    class TreeType
    {
        public string Name { get; }
        public string Color { get; }
        public string Texture { get; }
        public TreeType(string name, string color, string texture)
        { Name = name; Color = color; Texture = texture; }
        public void Draw(int x, int y) => Console.WriteLine($"Draw {Name} [{Color},{Texture}] at ({x},{y})");
    }

    static class TreeFactory
    {
        private static readonly Dictionary<string, TreeType> cache = new();
        public static TreeType GetTreeType(string name, string color, string texture)
        {
            var key = $"{name}-{color}-{texture}";
            if (!cache.TryGetValue(key, out var t))
            {
                t = new TreeType(name, color, texture);
                cache[key] = t;
            }
            return t;
        }
    }

    class Tree
    {
        private readonly int _x;
        private readonly int _y;
        private readonly TreeType _type;
        public Tree(int x, int y, TreeType type) { _x = x; _y = y; _type = type; }
        public void Draw() => _type.Draw(_x, _y);
    }

    class Forest
    {
        private readonly List<Tree> _trees = new();
        public void PlantTree(int x, int y, string name, string color, string texture)
        {
            var type = TreeFactory.GetTreeType(name, color, texture);
            _trees.Add(new Tree(x, y, type));
        }
        public void Draw() { foreach (var t in _trees) t.Draw(); }
    }

    class Program
    {
        static void Main()
        {
            var forest = new Forest();
            for (int i = 0; i < 5; i++) forest.PlantTree(i, i * 2, "Oak", "Green", "Rough");
            for (int i = 0; i < 3; i++) forest.PlantTree(i + 10, i * 3, "Pine", "DarkGreen", "Smooth");
            forest.Draw();
        }
    }
}
