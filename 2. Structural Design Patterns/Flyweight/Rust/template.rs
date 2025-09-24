// Flyweight Pattern – Rust Template

use std::collections::HashMap;

struct Flyweight {
    // intrinsic, immutable data
}

struct Factory {
    cache: HashMap<String, Flyweight>,
}

impl Factory {
    fn new() -> Self { Self { cache: HashMap::new() } }
    fn get(&mut self, key: &str) -> &Flyweight {
        self.cache.entry(key.to_string()).or_insert_with(|| Flyweight {})
    }
}

struct Context<'a> {
    fw: &'a Flyweight,
    // extrinsic fields here
}

fn main() {
    let mut factory = Factory::new();
    let fw = factory.get("key");
    let _ctx = Context { fw };
    // use _ctx with extrinsic state
}
