# Facade Pattern – Python Template

class SubsystemA:
    def operation_a(self):
        return "SubsystemA operation"

class SubsystemB:
    def operation_b(self):
        return "SubsystemB operation"

class SubsystemC:
    def operation_c(self):
        return "SubsystemC operation"

class Facade:
    def __init__(self):
        self.subsystem_a = SubsystemA()
        self.subsystem_b = SubsystemB()
        self.subsystem_c = SubsystemC()
    
    def operation(self):
        results = []
        results.append(self.subsystem_a.operation_a())
        results.append(self.subsystem_b.operation_b())
        results.append(self.subsystem_c.operation_c())
        return "\n".join(results)

def main():
    facade = Facade()
    print(facade.operation())

if __name__ == "__main__":
    main()
