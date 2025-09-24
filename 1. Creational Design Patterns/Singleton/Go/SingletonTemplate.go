package main

// Singleton Pattern – Go Template
// Thread-safe lazy init using sync.Once

import "sync"

type singleton struct{}

var (
	inst *singleton
	once sync.Once
)

func Instance() *singleton {
	once.Do(func() { inst = &singleton{} })
	return inst
}

func main() { _ = Instance() }
