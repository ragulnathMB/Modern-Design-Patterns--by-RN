// Command Pattern Example in JavaScript
// Remote executes commands on Light and Stereo

class Command { execute(){} undo(){} }

class Light { on(){ console.log('Light ON') } off(){ console.log('Light OFF') } }
class Stereo { on(){ console.log('Stereo ON') } off(){ console.log('Stereo OFF') } }

class LightOnCommand extends Command { constructor(l){ super(); this.l=l } execute(){ this.l.on() } undo(){ this.l.off() } }
class LightOffCommand extends Command { constructor(l){ super(); this.l=l } execute(){ this.l.off() } undo(){ this.l.on() } }
class StereoOnCommand extends Command { constructor(s){ super(); this.s=s } execute(){ this.s.on() } undo(){ this.s.off() } }
class StereoOffCommand extends Command { constructor(s){ super(); this.s=s } execute(){ this.s.off() } undo(){ this.s.on() } }

class RemoteButton { constructor(cmd){ this.cmd=cmd } set(cmd){ this.cmd=cmd } press(){ this.cmd.execute() } pressUndo(){ this.cmd.undo() } }

;(function main(){
  const light=new Light(), stereo=new Stereo()
  const btn=new RemoteButton(new LightOnCommand(light))
  btn.press(); btn.pressUndo()
  btn.set(new StereoOnCommand(stereo))
  btn.press(); btn.pressUndo()
})()
