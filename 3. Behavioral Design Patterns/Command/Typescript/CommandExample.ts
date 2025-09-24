// Command Pattern Example in TypeScript
// Remote executes commands on Light and Stereo

interface Command { execute(): void; undo(): void }

class Light {
  on(){ console.log('Light ON') }
  off(){ console.log('Light OFF') }
}

class Stereo {
  on(){ console.log('Stereo ON') }
  off(){ console.log('Stereo OFF') }
}

class LightOnCommand implements Command {
  constructor(private l: Light){}
  execute(){ this.l.on() }
  undo(){ this.l.off() }
}

class LightOffCommand implements Command {
  constructor(private l: Light){}
  execute(){ this.l.off() }
  undo(){ this.l.on() }
}

class StereoOnCommand implements Command {
  constructor(private s: Stereo){}
  execute(){ this.s.on() }
  undo(){ this.s.off() }
}

class StereoOffCommand implements Command {
  constructor(private s: Stereo){}
  execute(){ this.s.off() }
  undo(){ this.s.on() }
}

class RemoteButton {
  constructor(private cmd: Command){}
  set(c: Command){ this.cmd = c }
  press(){ this.cmd.execute() }
  pressUndo(){ this.cmd.undo() }
}

;(function main(){
  const light = new Light();
  const stereo = new Stereo();
  const btn = new RemoteButton(new LightOnCommand(light));
  btn.press(); btn.pressUndo();
  btn.set(new StereoOnCommand(stereo));
  btn.press(); btn.pressUndo();
})()

export {}
