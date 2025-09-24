// Mediator Pattern – Rust Template

trait Mediator {
    fn notify(&self, sender: &dyn Colleague, event_type: &str);
}

trait Colleague {
    fn do_something(&self, mediator: &dyn Mediator);
}

struct ConcreteColleagueA;

impl Colleague for ConcreteColleagueA {
    fn do_something(&self, mediator: &dyn Mediator) {
        mediator.notify(self, "EventA");
    }
}

struct ConcreteColleagueB;

impl Colleague for ConcreteColleagueB {
    fn do_something(&self, mediator: &dyn Mediator) {
        mediator.notify(self, "EventB");
    }
}

struct ConcreteMediator {
    colleagues: Vec<Box<dyn Colleague>>,
}

impl ConcreteMediator {
    fn new() -> Self {
        Self {
            colleagues: Vec::new(),
        }
    }

    fn add_colleague(&mut self, colleague: Box<dyn Colleague>) {
        self.colleagues.push(colleague);
    }
}

impl Mediator for ConcreteMediator {
    fn notify(&self, _sender: &dyn Colleague, _event_type: &str) {
        /* handle event */
    }
}

fn main() {
    let mut mediator = ConcreteMediator::new();
    let colleague_a = Box::new(ConcreteColleagueA);
    let colleague_b = Box::new(ConcreteColleagueB);
    
    colleague_a.do_something(&mediator);
    
    mediator.add_colleague(colleague_a);
    mediator.add_colleague(colleague_b);
}
