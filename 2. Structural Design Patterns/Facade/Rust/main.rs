// Facade Pattern Example in Rust
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

struct CPU;
impl CPU { fn freeze(&self){ println!("CPU: freeze"); } fn jump(&self, position: i64){ println!("CPU: jump to {}", position); } fn execute(&self){ println!("CPU: execute"); } }

struct Memory;
impl Memory { fn load(&self, position: i64, data_len: usize){ println!("Memory: load {} bytes at {}", data_len, position); } }

struct HardDrive;
impl HardDrive { fn read(&self, lba: i64, size: usize){ println!("HardDrive: read {} bytes from LBA {}", size, lba); } }

struct Computer { cpu: CPU, mem: Memory, hdd: HardDrive }
impl Computer {
    fn new() -> Self { Self { cpu: CPU, mem: Memory, hdd: HardDrive } }
    fn start(&self){ self.cpu.freeze(); self.hdd.read(0, 1024); self.mem.load(0, 1024); self.cpu.jump(0); self.cpu.execute(); }
    fn shutdown(&self){ println!("Computer: shutdown sequence"); }
}

fn main(){ let c = Computer::new(); c.start(); c.shutdown(); }
