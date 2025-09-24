// Observer Pattern Example in C#
// WeatherStation notifies Display observers when temperature changes

using System;
using System.Collections.Generic;

namespace ObserverExample
{
    interface IObserver { void Update(float temperature); }

    interface ISubject { void Attach(IObserver o); void Detach(IObserver o); void Notify(); }

    class WeatherStation : ISubject
    {
        private readonly List<IObserver> _observers = new();
        private float _temperature;
        public void Attach(IObserver o) => _observers.Add(o);
        public void Detach(IObserver o) => _observers.Remove(o);
        public void Notify() { foreach (var o in _observers) o.Update(_temperature); }
        public void SetTemperature(float temp) { _temperature = temp; Notify(); }
    }

    class PhoneDisplay : IObserver
    {
        public void Update(float temperature) => Console.WriteLine($"Phone: Temperature is {temperature}°C");
    }

    class WindowDisplay : IObserver
    {
        public void Update(float temperature) => Console.WriteLine($"Window: Temperature is {temperature}°C");
    }

    class Program
    {
        static void Main()
        {
            var station = new WeatherStation();
            var phone = new PhoneDisplay();
            var window = new WindowDisplay();
            station.Attach(phone);
            station.Attach(window);
            station.SetTemperature(25.5f);
            station.SetTemperature(30.2f);
        }
    }
}
