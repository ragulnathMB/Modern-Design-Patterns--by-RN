// Singleton Pattern Example in C#
// Thread-safe, lazy initialization using .NET's Lazy<T>.
// Compile: csc SingletonExample.cs && SingletonExample.exe

using System;

sealed class AppConfig
{
    private static readonly Lazy<AppConfig> _instance = new(() => new AppConfig());
    public static AppConfig Instance => _instance.Value;

    // Example state
    public string ConnectionString { get; private set; }

    private AppConfig()
    {
        ConnectionString = "Server=.;Database=MyDb;Trusted_Connection=True;";
    }

    public void Print() => Console.WriteLine($"Connection: {ConnectionString}");
}

class Program
{
    static void Main()
    {
        var a = AppConfig.Instance;
        var b = AppConfig.Instance;
        Console.WriteLine(Object.ReferenceEquals(a, b)); // True
        a.Print();
    }
}
