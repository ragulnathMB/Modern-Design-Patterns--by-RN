# Flyweight Pattern – Python Template

class Flyweight:
    def __init__(self, intrinsic_state):
        self.intrinsic_state = intrinsic_state
    
    def operation(self, extrinsic_state):
        return f"Flyweight: intrinsic={self.intrinsic_state}, extrinsic={extrinsic_state}"

class FlyweightFactory:
    _flyweights = {}
    
    @classmethod
    def get_flyweight(cls, key):
        if key not in cls._flyweights:
            cls._flyweights[key] = Flyweight(key)
        return cls._flyweights[key]

class Context:
    def __init__(self, key, extrinsic_state):
        self.flyweight = FlyweightFactory.get_flyweight(key)
        self.extrinsic_state = extrinsic_state
    
    def operation(self):
        return self.flyweight.operation(self.extrinsic_state)

def main():
    context1 = Context("shared_key", "unique_state_1")
    context2 = Context("shared_key", "unique_state_2")
    print(context1.operation())
    print(context2.operation())

if __name__ == "__main__":
    main()
