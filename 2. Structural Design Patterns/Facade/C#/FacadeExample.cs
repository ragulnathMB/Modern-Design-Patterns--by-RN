// Facade Pattern Example in C#
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

using System;

namespace FacadeExample
{
    class CPU { public void Freeze(){ Console.WriteLine("CPU: freeze"); } public void Jump(long position){ Console.WriteLine($"CPU: jump to {position}"); } public void Execute(){ Console.WriteLine("CPU: execute"); } }
    class Memory { public void Load(long position, byte[] data){ Console.WriteLine($"Memory: load {data.Length} bytes at {position}"); } }
    class HardDrive { public byte[] Read(long lba, int size){ Console.WriteLine($"HardDrive: read {size} bytes from LBA {lba}"); return new byte[size]; } }

    class Computer
    {
        private readonly CPU cpu = new();
        private readonly Memory memory = new();
        private readonly HardDrive hardDrive = new();
        public void Start(){ cpu.Freeze(); var boot = hardDrive.Read(0, 1024); memory.Load(0, boot); cpu.Jump(0); cpu.Execute(); }
        public void Shutdown(){ Console.WriteLine("Computer: shutdown sequence"); }
    }

    class Program
    {
        static void Main(){ var computer = new Computer(); computer.Start(); computer.Shutdown(); }
    }
}
