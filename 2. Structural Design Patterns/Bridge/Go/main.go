package main

import "fmt"

// Bridge Pattern Example in Go
// Abstraction: Remote; Implementor: Device

type Device interface {
	IsEnabled() bool
	Enable()
	Disable()
	SetVolume(int)
	GetVolume() int
}

type TV struct{ on bool; vol int }
func (d *TV) IsEnabled() bool { return d.on }
func (d *TV) Enable() { d.on = true }
func (d *TV) Disable() { d.on = false }
func (d *TV) SetVolume(v int) { if v<0 {v=0}; if v>100 {v=100}; d.vol = v }
func (d *TV) GetVolume() int { return d.vol }

type Radio struct{ on bool; vol int }
func (d *Radio) IsEnabled() bool { return d.on }
func (d *Radio) Enable() { d.on = true }
func (d *Radio) Disable() { d.on = false }
func (d *Radio) SetVolume(v int) { if v<0 {v=0}; if v>100 {v=100}; d.vol = v }
func (d *Radio) GetVolume() int { return d.vol }

// Abstraction

type Remote struct{ d Device }
func (r *Remote) TogglePower(){ if r.d.IsEnabled(){ r.d.Disable() } else { r.d.Enable() } }
func (r *Remote) VolumeUp(){ r.d.SetVolume(r.d.GetVolume()+10) }
func (r *Remote) VolumeDown(){ r.d.SetVolume(r.d.GetVolume()-10) }

type AdvancedRemote struct{ Remote }
func (a *AdvancedRemote) Mute(){ a.d.SetVolume(0) }

func main(){
	tv := &TV{vol:10}
	r := &Remote{d: tv}
	r.TogglePower(); r.VolumeUp()
	fmt.Println("TV on=", tv.IsEnabled(), "vol=", tv.GetVolume())

	radio := &Radio{vol:20}
	ar := &AdvancedRemote{Remote{d: radio}}
	ar.TogglePower(); ar.Mute()
	fmt.Println("Radio on=", radio.IsEnabled(), "vol=", radio.GetVolume())
}
