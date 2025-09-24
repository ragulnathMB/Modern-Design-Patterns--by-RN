package main

import "fmt"

// Facade Pattern Example in Go
// Subsystems: CPU, Memory, HardDrive; Facade: Computer

type CPU struct{}
func (CPU) Freeze(){ fmt.Println("CPU: freeze") }
func (CPU) Jump(position int64){ fmt.Println("CPU: jump to", position) }
func (CPU) Execute(){ fmt.Println("CPU: execute") }

type Memory struct{}
func (Memory) Load(position int64, data []byte){ fmt.Printf("Memory: load %d bytes at %d\n", len(data), position) }

type HardDrive struct{}
func (HardDrive) Read(lba int64, size int){ fmt.Printf("HardDrive: read %d bytes from LBA %d\n", size, lba) }

type Computer struct{ cpu CPU; mem Memory; hdd HardDrive }
func (c Computer) Start(){ c.cpu.Freeze(); c.hdd.Read(0, 1024); c.mem.Load(0, make([]byte, 1024)); c.cpu.Jump(0); c.cpu.Execute() }
func (c Computer) Shutdown(){ fmt.Println("Computer: shutdown sequence") }

func main(){ comp := Computer{}; comp.Start(); comp.Shutdown() }
