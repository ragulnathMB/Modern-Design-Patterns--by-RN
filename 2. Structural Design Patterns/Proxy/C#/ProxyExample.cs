// Proxy Pattern Example in C#
// Image viewer with lazy-loading proxy

using System;

namespace ProxyExample
{
    interface IImage { void Display(); }

    class RealImage : IImage
    {
        private readonly string _filename;
        public RealImage(string filename){ _filename = filename; LoadFromDisk(); }
        private void LoadFromDisk(){ Console.WriteLine($"Loading image: {_filename}"); }
        public void Display(){ Console.WriteLine($"Displaying: {_filename}"); }
    }

    class ProxyImage : IImage
    {
        private readonly string _filename;
        private RealImage _real;
        public ProxyImage(string filename){ _filename = filename; }
        public void Display(){ _real ??= new RealImage(_filename); _real.Display(); }
    }

    class Program
    {
        static void Main()
        {
            IImage img = new ProxyImage("photo.jpg");
            img.Display(); // loads then displays
            img.Display(); // displays without loading
        }
    }
}
