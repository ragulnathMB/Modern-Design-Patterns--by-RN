# Builder Pattern – Python Template

class Product:
    def __init__(self):
        self.parts = []
    
    def add_part(self, part):
        self.parts.append(part)
    
    def show(self):
        return f"Product parts: {', '.join(self.parts)}"

class Builder:
    def __init__(self):
        self.product = Product()
    
    def build_part_a(self):
        self.product.add_part("PartA")
        return self
    
    def build_part_b(self):
        self.product.add_part("PartB")
        return self
    
    def build_part_c(self):
        self.product.add_part("PartC")
        return self
    
    def get_result(self):
        return self.product

class Director:
    def __init__(self, builder):
        self.builder = builder
    
    def construct(self):
        return (self.builder
                .build_part_a()
                .build_part_b()
                .build_part_c()
                .get_result())

def main():
    builder = Builder()
    director = Director(builder)
    product = director.construct()
    print(product.show())

if __name__ == "__main__":
    main()
