// Composite Pattern Example in C#
// File system: File (leaf) and Directory (composite)
// Compile: csc CompositeExample.cs && CompositeExample.exe

using System;
using System.Collections.Generic;

namespace CompositeDemo
{
    abstract class FileSystemItem
    {
        public string Name { get; }
        protected FileSystemItem(string name) { Name = name; }
        public abstract void Display(int depth = 0);
        public abstract int GetSize();
    }

    class File : FileSystemItem
    {
        private readonly int _size;
        public File(string name, int size) : base(name) { _size = size; }
        public override void Display(int depth = 0) => Console.WriteLine(new string(' ', depth * 2) + $"File: {Name} ({_size}KB)");
        public override int GetSize() => _size;
    }

    class Directory : FileSystemItem
    {
        private readonly List<FileSystemItem> _items = new();
        public Directory(string name) : base(name) {}
        public void Add(FileSystemItem item) => _items.Add(item);
        public void Remove(FileSystemItem item) => _items.Remove(item);
        public override void Display(int depth = 0)
        {
            Console.WriteLine(new string(' ', depth * 2) + $"Directory: {Name}/");
            foreach (var item in _items) item.Display(depth + 1);
        }
        public override int GetSize() { int total = 0; foreach (var item in _items) total += item.GetSize(); return total; }
    }

    class Program
    {
        static void Main()
        {
            var root = new Directory("root");
            var docs = new Directory("docs");
            docs.Add(new File("readme.txt", 5));
            docs.Add(new File("manual.pdf", 150));
            root.Add(docs);
            root.Add(new File("config.ini", 2));
            root.Display();
            Console.WriteLine($"Total size: {root.GetSize()}KB");
        }
    }
}
