// Adapter Pattern Example in C#
// Scenario: RoundHole accepts RoundPeg. Adapt SquarePeg to fit.
// Compile: csc AdapterExample.cs && AdapterExample.exe

using System;

namespace AdapterDemo
{
    class RoundHole
    {
        public double Radius { get; }
        public RoundHole(double radius) { Radius = radius; }
        public bool Fits(IRoundPeg peg) => peg.GetRadius() <= Radius;
    }

    interface IRoundPeg
    {
        double GetRadius();
    }

    class RoundPeg : IRoundPeg
    {
        private readonly double _radius;
        public RoundPeg(double radius) { _radius = radius; }
        public double GetRadius() => _radius;
    }

    class SquarePeg
    {
        public double Width { get; }
        public SquarePeg(double width) { Width = width; }
    }

    // Adapter: exposes SquarePeg as IRoundPeg
    class SquarePegAdapter : IRoundPeg
    {
        private readonly SquarePeg _peg;
        public SquarePegAdapter(SquarePeg peg) { _peg = peg; }
        public double GetRadius() => (_peg.Width * Math.Sqrt(2)) / 2.0;
    }

    class Program
    {
        static void Main()
        {
            var hole = new RoundHole(5);
            var round = new RoundPeg(5);
            Console.WriteLine(hole.Fits(round)); // True

            var smallSquare = new SquarePeg(7);
            var largeSquare = new SquarePeg(11);
            Console.WriteLine(hole.Fits(new SquarePegAdapter(smallSquare))); // True
            Console.WriteLine(hole.Fits(new SquarePegAdapter(largeSquare))); // False
        }
    }
}
