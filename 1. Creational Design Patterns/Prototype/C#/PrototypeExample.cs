// Prototype Pattern Example in C#
// Scenario: Clone Shapes without knowing their concrete classes at runtime.
// Compile: csc PrototypeExample.cs && PrototypeExample.exe

using System;

namespace PrototypeDemo
{
    abstract class Shape
    {
        public int X; public int Y; public string Color = "";
        public Shape(){}
        public Shape(Shape source) { X = source.X; Y = source.Y; Color = source.Color; }
        public abstract Shape Clone();
        public abstract void Draw();
    }

    class Rectangle : Shape
    {
        public int Width; public int Height;
        public Rectangle(){}
        public Rectangle(Rectangle r):base(r){ Width = r.Width; Height = r.Height; }
        public override Shape Clone() => new Rectangle(this);
        public override void Draw() => Console.WriteLine($"Rectangle: {X},{Y},{Width},{Height} color={Color}");
    }

    class Circle : Shape
    {
        public int Radius;
        public Circle(){}
        public Circle(Circle c):base(c){ Radius = c.Radius; }
        public override Shape Clone() => new Circle(this);
        public override void Draw() => Console.WriteLine($"Circle: {X},{Y},r={Radius} color={Color}");
    }

    class Program
    {
        static void Main()
        {
            var rect1 = new Rectangle { X=10, Y=20, Width=30, Height=40, Color="red" };
            var rect2 = (Rectangle)rect1.Clone();
            rect2.X += 100;
            rect1.Draw(); rect2.Draw();
        }
    }
}
