// Command Pattern Example in Java
// Remote control executes commands on Light and Stereo

interface Command { void execute(); void undo(); }

class Light { void on(){ System.out.println("Light ON"); } void off(){ System.out.println("Light OFF"); } }
class Stereo { void on(){ System.out.println("Stereo ON"); } void off(){ System.out.println("Stereo OFF"); } }

class LightOnCommand implements Command { private final Light l; LightOnCommand(Light l){ this.l = l; } public void execute(){ l.on(); } public void undo(){ l.off(); } }
class LightOffCommand implements Command { private final Light l; LightOffCommand(Light l){ this.l = l; } public void execute(){ l.off(); } public void undo(){ l.on(); } }
class StereoOnCommand implements Command { private final Stereo s; StereoOnCommand(Stereo s){ this.s = s; } public void execute(){ s.on(); } public void undo(){ s.off(); } }
class StereoOffCommand implements Command { private final Stereo s; StereoOffCommand(Stereo s){ this.s = s; } public void execute(){ s.off(); } public void undo(){ s.on(); } }

class RemoteButton { private Command cmd; RemoteButton(Command c){ cmd = c; } void set(Command c){ cmd = c; } void press(){ cmd.execute(); } void pressUndo(){ cmd.undo(); } }

public class CommandExample {
    public static void main(String[] args){
        Light light = new Light(); Stereo stereo = new Stereo();
        RemoteButton btn = new RemoteButton(new LightOnCommand(light));
        btn.press(); btn.pressUndo();
        btn.set(new StereoOnCommand(stereo));
        btn.press(); btn.pressUndo();
    }
}
