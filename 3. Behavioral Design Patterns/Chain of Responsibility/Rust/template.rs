// Chain of Responsibility Pattern – Rust Template

trait Handler {
    fn set_next(&mut self, handler: Box<dyn Handler>);
    fn handle_request(&self, request: &Request);
}

struct Request {
    data: String,
}

struct ConcreteHandlerA {
    next: Option<Box<dyn Handler>>,
}

impl ConcreteHandlerA {
    fn new() -> Self { Self { next: None } }
    fn can_handle(&self, _request: &Request) -> bool { true /* condition */ }
    fn process_request(&self, _request: &Request) { /* handle */ }
}

impl Handler for ConcreteHandlerA {
    fn set_next(&mut self, handler: Box<dyn Handler>) {
        self.next = Some(handler);
    }

    fn handle_request(&self, request: &Request) {
        if self.can_handle(request) {
            self.process_request(request);
        } else if let Some(ref next) = self.next {
            next.handle_request(request);
        }
    }
}

struct ConcreteHandlerB {
    next: Option<Box<dyn Handler>>,
}

impl ConcreteHandlerB {
    fn new() -> Self { Self { next: None } }
    fn can_handle(&self, _request: &Request) -> bool { true /* condition */ }
    fn process_request(&self, _request: &Request) { /* handle */ }
}

impl Handler for ConcreteHandlerB {
    fn set_next(&mut self, handler: Box<dyn Handler>) {
        self.next = Some(handler);
    }

    fn handle_request(&self, request: &Request) {
        if self.can_handle(request) {
            self.process_request(request);
        } else if let Some(ref next) = self.next {
            next.handle_request(request);
        }
    }
}

fn main() {
    let mut handler_a = ConcreteHandlerA::new();
    let handler_b = ConcreteHandlerB::new();
    handler_a.set_next(Box::new(handler_b));
    handler_a.handle_request(&Request { data: "test".to_string() });
}
