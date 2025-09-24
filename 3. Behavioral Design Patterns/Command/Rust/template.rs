// Command Pattern – Rust Template

trait Command {
    fn execute(&mut self);
    fn undo(&mut self);
}

struct Receiver;
impl Receiver {
    fn action(&self) { /* do something */ }
    fn undo_action(&self) { /* undo something */ }
}

struct ConcreteCommand { r: Receiver }
impl Command for ConcreteCommand {
    fn execute(&mut self) { self.r.action(); }
    fn undo(&mut self) { self.r.undo_action(); }
}

struct Invoker<C: Command> { cmd: Option<C> }
impl<C: Command> Invoker<C> {
    fn new() -> Self { Self { cmd: None } }
    fn set(&mut self, c: C) { self.cmd = Some(c) }
    fn run(&mut self) { if let Some(cmd) = self.cmd.as_mut() { cmd.execute(); } }
    fn undo(&mut self) { if let Some(cmd) = self.cmd.as_mut() { cmd.undo(); } }
}

fn main(){
    let r = Receiver;
    let c = ConcreteCommand { r };
    let mut inv = Invoker::new();
    inv.set(c);
    inv.run();
    inv.undo();
}
