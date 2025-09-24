// Abstract Factory Pattern Example in C#
// Scenario: Cross-platform UI library that can create Windows and Mac style Buttons & Checkboxes.
// No external libraries are required. Compile with: csc AbstractFactoryExample.cs && AbstractFactoryExample.exe

using System;

namespace AbstractFactoryDemo
{
    // Product A
    interface IButton
    {
        void Paint();
    }

    // Product B
    interface ICheckbox
    {
        void Paint();
    }

    // Concrete Product A1
    class WindowsButton : IButton
    {
        public void Paint() => Console.WriteLine("Render a button in Windows style.");
    }

    // Concrete Product B1
    class WindowsCheckbox : ICheckbox
    {
        public void Paint() => Console.WriteLine("Render a checkbox in Windows style.");
    }

    // Concrete Product A2
    class MacButton : IButton
    {
        public void Paint() => Console.WriteLine("Render a button in macOS style.");
    }

    // Concrete Product B2
    class MacCheckbox : ICheckbox
    {
        public void Paint() => Console.WriteLine("Render a checkbox in macOS style.");
    }

    // Abstract Factory
    interface IGUIFactory
    {
        IButton CreateButton();
        ICheckbox CreateCheckbox();
    }

    // Concrete Factory 1
    class WindowsFactory : IGUIFactory
    {
        public IButton CreateButton() => new WindowsButton();
        public ICheckbox CreateCheckbox() => new WindowsCheckbox();
    }

    // Concrete Factory 2
    class MacFactory : IGUIFactory
    {
        public IButton CreateButton() => new MacButton();
        public ICheckbox CreateCheckbox() => new MacCheckbox();
    }

    // Client
    class Application
    {
        private readonly IButton _button;
        private readonly ICheckbox _checkbox;

        public Application(IGUIFactory factory)
        {
            _button = factory.CreateButton();
            _checkbox = factory.CreateCheckbox();
        }

        public void Paint()
        {
            _button.Paint();
            _checkbox.Paint();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            IGUIFactory factory;
            if (args.Length > 0 && args[0].Equals("mac", StringComparison.OrdinalIgnoreCase))
                factory = new MacFactory();
            else
                factory = new WindowsFactory();

            var app = new Application(factory);
            app.Paint();
        }
    }
}
