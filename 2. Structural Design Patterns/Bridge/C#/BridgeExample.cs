// Bridge Pattern Example in C#
// Abstraction: Remote; Implementor: Device (TV/Radio)
// Compile: csc BridgeExample.cs && BridgeExample.exe

using System;

namespace BridgeDemo
{
    // Implementor
    interface IDevice
    {
        bool IsEnabled { get; }
        void Enable();
        void Disable();
        void SetVolume(int vol);
        int GetVolume();
    }

    // Concrete Implementors
    class TV : IDevice
    {
        private bool _on;
        private int _vol = 10;
        public bool IsEnabled => _on;
        public void Enable() => _on = true;
        public void Disable() => _on = false;
        public void SetVolume(int vol) => _vol = Math.Clamp(vol, 0, 100);
        public int GetVolume() => _vol;
    }

    class Radio : IDevice
    {
        private bool _on;
        private int _vol = 20;
        public bool IsEnabled => _on;
        public void Enable() => _on = true;
        public void Disable() => _on = false;
        public void SetVolume(int vol) => _vol = Math.Clamp(vol, 0, 100);
        public int GetVolume() => _vol;
    }

    // Abstraction
    class Remote
    {
        protected readonly IDevice device;
        public Remote(IDevice device) { this.device = device; }
        public void TogglePower() { if (device.IsEnabled) device.Disable(); else device.Enable(); }
        public void VolumeUp() => device.SetVolume(device.GetVolume() + 10);
        public void VolumeDown() => device.SetVolume(device.GetVolume() - 10);
    }

    // Refined Abstraction
    class AdvancedRemote : Remote
    {
        public AdvancedRemote(IDevice d) : base(d) {}
        public void Mute() => device.SetVolume(0);
    }

    class Program
    {
        static void Main()
        {
            IDevice tv = new TV();
            var remote = new Remote(tv);
            remote.TogglePower();
            remote.VolumeUp();
            Console.WriteLine($"TV on={tv.IsEnabled} vol={tv.GetVolume()}");

            IDevice radio = new Radio();
            var adv = new AdvancedRemote(radio);
            adv.TogglePower();
            adv.Mute();
            Console.WriteLine($"Radio on={radio.IsEnabled} vol={radio.GetVolume()}");
        }
    }
}
