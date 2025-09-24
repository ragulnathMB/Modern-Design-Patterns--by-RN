# Facade Pattern Example in Python
# Subsystems: CPU, Memory, HardDrive; Facade: Computer

class CPU:
    def freeze(self):
        return "CPU: freeze"
    
    def jump(self, position):
        return f"CPU: jump to {position}"
    
    def execute(self):
        return "CPU: execute"

class Memory:
    def load(self, position, data):
        return f"Memory: load {len(data)} bytes at {position}"

class HardDrive:
    def read(self, lba, size):
        return f"HardDrive: read {size} bytes from LBA {lba}"

class Computer:
    def __init__(self):
        self.cpu = CPU()
        self.memory = Memory()
        self.hard_drive = HardDrive()
    
    def start(self):
        results = []
        results.append(self.cpu.freeze())
        boot_data = [0] * 1024  # dummy boot data
        results.append(self.hard_drive.read(0, 1024))
        results.append(self.memory.load(0, boot_data))
        results.append(self.cpu.jump(0))
        results.append(self.cpu.execute())
        return "\n".join(results)
    
    def shutdown(self):
        return "Computer: shutdown sequence"

def main():
    computer = Computer()
    print(computer.start())
    print(computer.shutdown())

if __name__ == "__main__":
    main()
