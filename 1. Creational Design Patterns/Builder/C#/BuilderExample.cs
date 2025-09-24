// Builder Pattern Example in C#
// Scenario: Constructing a House step-by-step using a Director and Concrete Builders.
// Compile: csc BuilderExample.cs && BuilderExample.exe

using System;
using System.Text;

namespace BuilderPatternDemo
{
    // Product
    class House
    {
        public string Walls { get; set; } = "";
        public string Roof { get; set; } = "";
        public string Doors { get; set; } = "";
        public override string ToString() => new StringBuilder()
            .AppendLine($"Walls: {Walls}")
            .AppendLine($"Roof: {Roof}")
            .AppendLine($"Doors: {Doors}")
            .ToString();
    }

    // Builder Interface
    interface IHouseBuilder
    {
        void BuildWalls();
        void BuildRoof();
        void BuildDoors();
        House GetResult();
    }

    // Concrete Builder 1
    class WoodenHouseBuilder : IHouseBuilder
    {
        private readonly House _house = new House();
        public void BuildWalls() => _house.Walls = "Wooden Walls";
        public void BuildRoof() => _house.Roof = "Wooden Roof";
        public void BuildDoors() => _house.Doors = "Wooden Doors";
        public House GetResult() => _house;
    }

    // Concrete Builder 2
    class StoneHouseBuilder : IHouseBuilder
    {
        private readonly House _house = new House();
        public void BuildWalls() => _house.Walls = "Stone Walls";
        public void BuildRoof() => _house.Roof = "Stone Roof";
        public void BuildDoors() => _house.Doors = "Stone Doors";
        public House GetResult() => _house;
    }

    // Director
    class Director
    {
        public void Construct(IHouseBuilder builder)
        {
            builder.BuildWalls();
            builder.BuildRoof();
            builder.BuildDoors();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            IHouseBuilder builder = (args.Length > 0 && args[0].Equals("stone", StringComparison.OrdinalIgnoreCase))
                ? new StoneHouseBuilder() as IHouseBuilder
                : new WoodenHouseBuilder();
            var director = new Director();
            director.Construct(builder);
            Console.WriteLine(builder.GetResult());
        }
    }
}
