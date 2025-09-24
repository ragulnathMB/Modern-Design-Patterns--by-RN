// Chain of Responsibility Pattern Example in Rust
// Support ticket system with different levels of handlers

trait SupportHandler {
    fn set_next(&mut self, handler: Box<dyn SupportHandler>);
    fn handle_request(&self, ticket: &SupportTicket);
}

struct SupportTicket {
    issue: String,
    priority: i32,
}

struct Level1Support {
    next: Option<Box<dyn SupportHandler>>,
}

impl Level1Support {
    fn new() -> Self { Self { next: None } }
}

impl SupportHandler for Level1Support {
    fn set_next(&mut self, handler: Box<dyn SupportHandler>) {
        self.next = Some(handler);
    }

    fn handle_request(&self, ticket: &SupportTicket) {
        if ticket.priority <= 1 {
            println!("Level 1: Handled '{}'", ticket.issue);
        } else if let Some(ref next) = self.next {
            next.handle_request(ticket);
        } else {
            println!("No handler available for '{}'", ticket.issue);
        }
    }
}

struct Level2Support {
    next: Option<Box<dyn SupportHandler>>,
}

impl Level2Support {
    fn new() -> Self { Self { next: None } }
}

impl SupportHandler for Level2Support {
    fn set_next(&mut self, handler: Box<dyn SupportHandler>) {
        self.next = Some(handler);
    }

    fn handle_request(&self, ticket: &SupportTicket) {
        if ticket.priority <= 2 {
            println!("Level 2: Handled '{}'", ticket.issue);
        } else if let Some(ref next) = self.next {
            next.handle_request(ticket);
        } else {
            println!("No handler available for '{}'", ticket.issue);
        }
    }
}

struct Level3Support;

impl SupportHandler for Level3Support {
    fn set_next(&mut self, _handler: Box<dyn SupportHandler>) {}

    fn handle_request(&self, ticket: &SupportTicket) {
        println!("Level 3: Handled '{}'", ticket.issue);
    }
}

fn main() {
    let mut level1 = Level1Support::new();
    let mut level2 = Level2Support::new();
    let level3 = Level3Support;

    level2.set_next(Box::new(level3));
    level1.set_next(Box::new(level2));

    level1.handle_request(&SupportTicket { issue: "Password reset".to_string(), priority: 1 });
    level1.handle_request(&SupportTicket { issue: "Software bug".to_string(), priority: 2 });
    level1.handle_request(&SupportTicket { issue: "System crash".to_string(), priority: 3 });
}
