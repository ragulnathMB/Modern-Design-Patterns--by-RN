// Singleton Pattern Example in Rust
// Thread-safe lazy initialization using std::sync::OnceLock (Rust 1.70+). If unavailable, use Once + Option.

use std::sync::OnceLock;

struct AppConfig {
    connection_string: String,
}

static INSTANCE: OnceLock<AppConfig> = OnceLock::new();

fn get_instance() -> &'static AppConfig {
    INSTANCE.get_or_init(|| AppConfig {
        connection_string: "postgres://localhost/app".into(),
    })
}

fn main() {
    let a = get_instance();
    let b = get_instance();
    println!("same instance: {}", std::ptr::eq(a, b)); // true
    println!("Connection: {}", a.connection_string);
}
