package main

import "fmt"

// Command Pattern Example in Go
// Remote executes commands on Light and Stereo

type Command interface{ Execute(); Undo() }

type Light struct{}
func (Light) On(){ fmt.Println("Light ON") }
func (Light) Off(){ fmt.Println("Light OFF") }

type Stereo struct{}
func (Stereo) On(){ fmt.Println("Stereo ON") }
func (Stereo) Off(){ fmt.Println("Stereo OFF") }

type LightOnCommand struct{ l Light }
func (c LightOnCommand) Execute(){ c.l.On() }
func (c LightOnCommand) Undo(){ c.l.Off() }

type LightOffCommand struct{ l Light }
func (c LightOffCommand) Execute(){ c.l.Off() }
func (c LightOffCommand) Undo(){ c.l.On() }

type StereoOnCommand struct{ s Stereo }
func (c StereoOnCommand) Execute(){ c.s.On() }
func (c StereoOnCommand) Undo(){ c.s.Off() }

type StereoOffCommand struct{ s Stereo }
func (c StereoOffCommand) Execute(){ c.s.Off() }
func (c StereoOffCommand) Undo(){ c.s.On() }

type RemoteButton struct{ cmd Command }
func (r *RemoteButton) Set(c Command){ r.cmd = c }
func (r RemoteButton) Press(){ r.cmd.Execute() }
func (r RemoteButton) PressUndo(){ r.cmd.Undo() }

func main(){
	l := Light{}; s := Stereo{}
	btn := RemoteButton{ cmd: LightOnCommand{l} }
	btn.Press(); btn.PressUndo()
	btn.Set(StereoOnCommand{s})
	btn.Press(); btn.PressUndo()
}
