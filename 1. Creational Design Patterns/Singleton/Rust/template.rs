// Singleton Pattern – Rust Template
// Using OnceLock for thread-safe, lazy initialization.

use std::sync::OnceLock;

pub struct Singleton;

static INSTANCE: OnceLock<Singleton> = OnceLock::new();

pub fn instance() -> &'static Singleton {
    INSTANCE.get_or_init(|| Singleton)
}

fn main() {
    let _s = instance();
}
