// Mediator Pattern Example in Rust
// Chat room where users send messages through a mediator

use std::collections::HashMap;

trait ChatRoom {
    fn send_message(&mut self, message: &str, sender_id: usize);
    fn add_user(&mut self, user: User) -> usize;
}

struct User {
    id: usize,
    name: String,
}

impl User {
    fn new(id: usize, name: String) -> Self {
        Self { id, name }
    }

    fn send(&self, message: &str, chat_room: &mut dyn ChatRoom) {
        chat_room.send_message(message, self.id);
    }

    fn receive(&self, message: &str, from: &str) {
        println!("{} received: {} (from {})", self.name, message, from);
    }
}

struct ConcreteChatRoom {
    users: HashMap<usize, User>,
    next_id: usize,
}

impl ConcreteChatRoom {
    fn new() -> Self {
        Self {
            users: HashMap::new(),
            next_id: 0,
        }
    }
}

impl ChatRoom for ConcreteChatRoom {
    fn add_user(&mut self, user: User) -> usize {
        let id = self.next_id;
        self.next_id += 1;
        let user_with_id = User::new(id, user.name);
        self.users.insert(id, user_with_id);
        id
    }

    fn send_message(&mut self, message: &str, sender_id: usize) {
        let sender_name = self.users.get(&sender_id).map(|u| u.name.clone()).unwrap_or_default();
        for (id, user) in &self.users {
            if *id != sender_id {
                user.receive(message, &sender_name);
            }
        }
    }
}

fn main() {
    let mut chat_room = ConcreteChatRoom::new();
    let alice = User::new(0, "Alice".to_string());
    let bob = User::new(1, "Bob".to_string());
    let charlie = User::new(2, "Charlie".to_string());
    
    let alice_id = chat_room.add_user(alice);
    let bob_id = chat_room.add_user(bob);
    let _charlie_id = chat_room.add_user(charlie);

    // Simulate sending messages
    chat_room.send_message("Hello everyone!", alice_id);
    chat_room.send_message("Hi Alice!", bob_id);
}
