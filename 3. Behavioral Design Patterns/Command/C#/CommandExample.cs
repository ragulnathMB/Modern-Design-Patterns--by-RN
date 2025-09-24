// Command Pattern Example in C#
// Remote control executes commands on Light and Stereo

using System;

namespace CommandExample
{
    interface ICommand { void Execute(); void Undo(); }

    class Light { public void On(){ Console.WriteLine("Light ON"); } public void Off(){ Console.WriteLine("Light OFF"); } }
    class Stereo { public void On(){ Console.WriteLine("Stereo ON"); } public void Off(){ Console.WriteLine("Stereo OFF"); } }

    class LightOnCommand : ICommand { private readonly Light _l; public LightOnCommand(Light l){ _l = l; } public void Execute(){ _l.On(); } public void Undo(){ _l.Off(); } }
    class LightOffCommand : ICommand { private readonly Light _l; public LightOffCommand(Light l){ _l = l; } public void Execute(){ _l.Off(); } public void Undo(){ _l.On(); } }
    class StereoOnCommand : ICommand { private readonly Stereo _s; public StereoOnCommand(Stereo s){ _s = s; } public void Execute(){ _s.On(); } public void Undo(){ _s.Off(); } }
    class StereoOffCommand : ICommand { private readonly Stereo _s; public StereoOffCommand(Stereo s){ _s = s; } public void Execute(){ _s.Off(); } public void Undo(){ _s.On(); } }

    class RemoteButton { private ICommand _cmd; public RemoteButton(ICommand cmd){ _cmd = cmd; } public void Set(ICommand cmd){ _cmd = cmd; } public void Press(){ _cmd.Execute(); } public void PressUndo(){ _cmd.Undo(); } }

    class Program
    {
        static void Main()
        {
            var light = new Light(); var stereo = new Stereo();
            var btn = new RemoteButton(new LightOnCommand(light));
            btn.Press(); btn.PressUndo();
            btn.Set(new StereoOnCommand(stereo));
            btn.Press(); btn.PressUndo();
        }
    }
}
