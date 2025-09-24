// Singleton Pattern – C# Template
using System;

sealed class Singleton
{
    private static readonly Lazy<Singleton> _instance = new(() => new Singleton());
    public static Singleton Instance => _instance.Value;
    private Singleton() { }
}

class Entry { static void Main(){ var s = Singleton.Instance; } }
