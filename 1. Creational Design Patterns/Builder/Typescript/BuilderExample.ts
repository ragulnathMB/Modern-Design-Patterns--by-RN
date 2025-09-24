// Builder Pattern – TypeScript Example
interface Computer {
  cpu: string;
  ram: number;
}

class ComputerBuilder {
  private computer: Computer = { cpu: '', ram: 0 };
  buildCPU(cpu: string) { this.computer.cpu = cpu; return this; }
  buildRAM(ram: number) { this.computer.ram = ram; return this; }
  getResult() { return this.computer; }
}

const builder = new ComputerBuilder().buildCPU('M2').buildRAM(16);
console.log(builder.getResult());
