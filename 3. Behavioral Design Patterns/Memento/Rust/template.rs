// Memento Pattern – Rust Template

#[derive(Clone)]
struct Memento {
    state: String,
}

impl Memento {
    fn new(state: String) -> Self {
        Self { state }
    }

    fn get_state(&self) -> &str {
        &self.state
    }
}

struct Originator {
    state: String,
}

impl Originator {
    fn new() -> Self {
        Self {
            state: String::new(),
        }
    }

    fn set_state(&mut self, state: String) {
        self.state = state;
    }

    fn get_state(&self) -> &str {
        &self.state
    }

    fn create_memento(&self) -> Memento {
        Memento::new(self.state.clone())
    }

    fn restore_memento(&mut self, memento: &Memento) {
        self.state = memento.get_state().to_string();
    }
}

struct Caretaker {
    mementos: Vec<Memento>,
}

impl Caretaker {
    fn new() -> Self {
        Self {
            mementos: Vec::new(),
        }
    }

    fn save_state(&mut self, originator: &Originator) {
        self.mementos.push(originator.create_memento());
    }

    fn restore_state(&mut self, originator: &mut Originator) {
        if let Some(memento) = self.mementos.pop() {
            originator.restore_memento(&memento);
        }
    }
}

fn main() {
    let mut originator = Originator::new();
    let mut caretaker = Caretaker::new();
    originator.set_state("State1".to_string());
    caretaker.save_state(&originator);
    originator.set_state("State2".to_string());
    caretaker.restore_state(&mut originator);
}
