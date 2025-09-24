// Facade Pattern Example in TypeScript
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

class CPU { freeze(){ console.log('CPU: freeze') } jump(position: number){ console.log('CPU: jump to', position) } execute(){ console.log('CPU: execute') } }
class Memory { load(position: number, data: Uint8Array){ console.log('Memory: load', data.length, 'bytes at', position) } }
class HardDrive { read(lba: number, size: number): Uint8Array { console.log('HardDrive: read', size, 'bytes from LBA', lba); return new Uint8Array(size) } }

class Computer {
  private cpu = new CPU(); private memory = new Memory(); private hardDrive = new HardDrive();
  start(){ this.cpu.freeze(); const boot = this.hardDrive.read(0,1024); this.memory.load(0, boot); this.cpu.jump(0); this.cpu.execute(); }
  shutdown(){ console.log('Computer: shutdown sequence') }
}

(function main(){ const c = new Computer(); c.start(); c.shutdown(); })()

export {}
