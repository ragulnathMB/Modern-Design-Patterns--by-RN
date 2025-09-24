package main

// Proxy Pattern – Go Template

type Subject interface{ Request() }

type RealSubject struct{}
func (RealSubject) Request(){ /* heavy work */ }

type Proxy struct{ real *RealSubject }
func (p *Proxy) Request(){ if p.real == nil { p.real = &RealSubject{} }; /* checks/logging */ p.real.Request() }

func main(){ var s Subject = &Proxy{}; s.Request() }
