# Memento Pattern – Python Template

class Memento:
    def __init__(self, state):
        self._state = state
    
    def get_state(self):
        return self._state

class Originator:
    def __init__(self):
        self._state = ""
    
    def set_state(self, state):
        self._state = state
    
    def get_state(self):
        return self._state
    
    def create_memento(self):
        return Memento(self._state)
    
    def restore_memento(self, memento):
        self._state = memento.get_state()

class Caretaker:
    def __init__(self):
        self._mementos = []
    
    def save_state(self, originator):
        self._mementos.append(originator.create_memento())
    
    def restore_state(self, originator):
        if self._mementos:
            memento = self._mementos.pop()
            originator.restore_memento(memento)

def main():
    originator = Originator()
    caretaker = Caretaker()
    
    originator.set_state("State1")
    caretaker.save_state(originator)
    
    originator.set_state("State2")
    caretaker.restore_state(originator)
    print(f"Restored state: {originator.get_state()}")

if __name__ == "__main__":
    main()
