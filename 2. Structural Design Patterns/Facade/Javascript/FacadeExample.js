// Facade Pattern Example in JavaScript
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

class CPU { freeze(){ console.log('CPU: freeze'); } jump(position){ console.log('CPU: jump to', position); } execute(){ console.log('CPU: execute'); } }
class Memory { load(position, data){ console.log('Memory: load', data.length, 'bytes at', position); } }
class HardDrive { read(lba, size){ console.log('HardDrive: read', size, 'bytes from LBA', lba); return new Array(size).fill(0); } }

class Computer {
  constructor(){ this.cpu = new CPU(); this.memory = new Memory(); this.hardDrive = new HardDrive(); }
  start(){ this.cpu.freeze(); const boot = this.hardDrive.read(0,1024); this.memory.load(0, boot); this.cpu.jump(0); this.cpu.execute(); }
  shutdown(){ console.log('Computer: shutdown sequence'); }
}

(function main(){ const c = new Computer(); c.start(); c.shutdown(); })();
