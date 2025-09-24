// Decorator Pattern Example in Rust
// Notifier: Basic + Email + SMS + Slack decorators

trait Notifier { fn send(&self, message: &str); }

struct BasicNotifier;
impl Notifier for BasicNotifier { fn send(&self, message: &str){ println!("Base notify: {}", message); } }

struct EmailDecorator<T: Notifier> { inner: T }
impl<T: Notifier> Notifier for EmailDecorator<T> { fn send(&self, message: &str){ println!("Email sent: {}", message); self.inner.send(message); } }

struct SMSDecorator<T: Notifier> { inner: T }
impl<T: Notifier> Notifier for SMSDecorator<T> { fn send(&self, message: &str){ println!("SMS sent: {}", message); self.inner.send(message); } }

struct SlackDecorator<T: Notifier> { inner: T }
impl<T: Notifier> Notifier for SlackDecorator<T> { fn send(&self, message: &str){ println!("Slack message sent: {}", message); self.inner.send(message); } }

fn main(){
    let n = SlackDecorator { inner: SMSDecorator { inner: EmailDecorator { inner: BasicNotifier } } };
    n.send("System maintenance at 2 AM");
}
