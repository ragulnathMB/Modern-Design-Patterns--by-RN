// Command Pattern Example in Rust
// Remote executes commands on Light and Stereo

trait Command {
    fn execute(&mut self);
    fn undo(&mut self);
}

struct Light;
impl Light { fn on(&self){ println!("Light ON"); } fn off(&self){ println!("Light OFF"); } }

struct Stereo;
impl Stereo { fn on(&self){ println!("Stereo ON"); } fn off(&self){ println!("Stereo OFF"); } }

struct LightOnCommand { l: Light }
impl Command for LightOnCommand {
    fn execute(&mut self){ self.l.on(); }
    fn undo(&mut self){ self.l.off(); }
}

struct LightOffCommand { l: Light }
impl Command for LightOffCommand {
    fn execute(&mut self){ self.l.off(); }
    fn undo(&mut self){ self.l.on(); }
}

struct StereoOnCommand { s: Stereo }
impl Command for StereoOnCommand {
    fn execute(&mut self){ self.s.on(); }
    fn undo(&mut self){ self.s.off(); }
}

struct StereoOffCommand { s: Stereo }
impl Command for StereoOffCommand {
    fn execute(&mut self){ self.s.off(); }
    fn undo(&mut self){ self.s.on(); }
}

struct RemoteButton<C: Command> { cmd: C }
impl<C: Command> RemoteButton<C> {
    fn new(cmd: C) -> Self { Self { cmd } }
    fn press(&mut self){ self.cmd.execute(); }
    fn press_undo(&mut self){ self.cmd.undo(); }
}

fn main(){
    let light = Light; let stereo = Stereo;
    let mut btn = RemoteButton::new(LightOnCommand { l: light });
    btn.press(); btn.press_undo();
    let mut btn2 = RemoteButton::new(StereoOnCommand { s: stereo });
    btn2.press(); btn2.press_undo();
}
