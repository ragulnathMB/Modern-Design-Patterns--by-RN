// Facade Pattern Example in Java
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

class CPU {
    void freeze(){ System.out.println("CPU: freeze"); }
    void jump(long position){ System.out.println("CPU: jump to " + position); }
    void execute(){ System.out.println("CPU: execute"); }
}
class Memory { void load(long position, byte[] data){ System.out.println("Memory: load " + data.length + " bytes at " + position); } }
class HardDrive { byte[] read(long lba, int size){ System.out.println("HardDrive: read " + size + " bytes from LBA " + lba); return new byte[size]; } }

class Computer {
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();
    void start(){ cpu.freeze(); byte[] boot = hardDrive.read(0, 1024); memory.load(0, boot); cpu.jump(0); cpu.execute(); }
    void shutdown(){ System.out.println("Computer: shutdown sequence"); }
}

public class FacadeExample {
    public static void main(String[] args){ Computer c = new Computer(); c.start(); c.shutdown(); }
}
