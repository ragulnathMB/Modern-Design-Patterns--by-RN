# Builder Pattern Example in Python
# Computer assembly with different configurations

class Computer:
    def __init__(self):
        self.cpu = None
        self.ram = None
        self.storage = None
        self.gpu = None
    
    def __str__(self):
        return f"Computer[CPU: {self.cpu}, RAM: {self.ram}, Storage: {self.storage}, GPU: {self.gpu}]"

class ComputerBuilder:
    def __init__(self):
        self.computer = Computer()
    
    def set_cpu(self, cpu):
        self.computer.cpu = cpu
        return self
    
    def set_ram(self, ram):
        self.computer.ram = ram
        return self
    
    def set_storage(self, storage):
        self.computer.storage = storage
        return self
    
    def set_gpu(self, gpu):
        self.computer.gpu = gpu
        return self
    
    def build(self):
        return self.computer

class ComputerDirector:
    def __init__(self, builder):
        self.builder = builder
    
    def build_gaming_computer(self):
        return (self.builder
                .set_cpu("Intel i9")
                .set_ram("32GB DDR4")
                .set_storage("1TB NVMe SSD")
                .set_gpu("RTX 4080")
                .build())
    
    def build_office_computer(self):
        return (self.builder
                .set_cpu("Intel i5")
                .set_ram("16GB DDR4")
                .set_storage("512GB SSD")
                .build())

def main():
    # Gaming computer
    gaming_builder = ComputerBuilder()
    gaming_director = ComputerDirector(gaming_builder)
    gaming_pc = gaming_director.build_gaming_computer()
    print("Gaming PC:", gaming_pc)
    
    # Office computer
    office_builder = ComputerBuilder()
    office_director = ComputerDirector(office_builder)
    office_pc = office_director.build_office_computer()
    print("Office PC:", office_pc)
    
    # Custom build
    custom_pc = (ComputerBuilder()
                 .set_cpu("AMD Ryzen 7")
                 .set_ram("64GB DDR4")
                 .set_storage("2TB SSD")
                 .set_gpu("RTX 4090")
                 .build())
    print("Custom PC:", custom_pc)

if __name__ == "__main__":
    main()
