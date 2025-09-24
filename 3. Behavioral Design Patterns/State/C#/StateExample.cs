// State Pattern Example in C#
// TrafficLight cycles through Red, Yellow, Green states

using System;

namespace StateExample
{
    interface ITrafficLightState { void Next(TrafficLight context); string GetColor(); }

    class TrafficLight
    {
        private ITrafficLightState _state;
        public TrafficLight() { _state = new RedState(); }
        public void SetState(ITrafficLightState state) { _state = state; }
        public void Next() { _state.Next(this); }
        public string GetColor() => _state.GetColor();
    }

    class RedState : ITrafficLightState
    {
        public void Next(TrafficLight context) { context.SetState(new GreenState()); }
        public string GetColor() => "Red";
    }

    class YellowState : ITrafficLightState
    {
        public void Next(TrafficLight context) { context.SetState(new RedState()); }
        public string GetColor() => "Yellow";
    }

    class GreenState : ITrafficLightState
    {
        public void Next(TrafficLight context) { context.SetState(new YellowState()); }
        public string GetColor() => "Green";
    }

    class Program
    {
        static void Main()
        {
            var light = new TrafficLight();
            for (int i = 0; i < 6; i++)
            {
                Console.WriteLine($"Light: {light.GetColor()}");
                light.Next();
            }
        }
    }
}
