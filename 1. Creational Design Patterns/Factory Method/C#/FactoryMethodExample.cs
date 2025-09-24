// Factory Method Pattern Example in C#
// Scenario: Logistics creates appropriate Transport (Truck or Ship) at runtime.
// Compile: csc FactoryMethodExample.cs && FactoryMethodExample.exe [sea]

using System;

namespace FactoryMethodDemo
{
    interface ITransport
    {
        void Deliver();
    }

    class Truck : ITransport
    {
        public void Deliver() => Console.WriteLine("Deliver by land in a box.");
    }

    class Ship : ITransport
    {
        public void Deliver() => Console.WriteLine("Deliver by sea in a container.");
    }

    abstract class Logistics
    {
        public void PlanDelivery()
        {
            var transport = CreateTransport();
            transport.Deliver();
        }
        protected abstract ITransport CreateTransport();
    }

    class RoadLogistics : Logistics
    {
        protected override ITransport CreateTransport() => new Truck();
    }

    class SeaLogistics : Logistics
    {
        protected override ITransport CreateTransport() => new Ship();
    }

    class Program
    {
        static void Main(string[] args)
        {
            Logistics logistics = (args.Length > 0 && args[0].Equals("sea", StringComparison.OrdinalIgnoreCase))
                ? new SeaLogistics()
                : new RoadLogistics();
            logistics.PlanDelivery();
        }
    }
}
