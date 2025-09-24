package main

import (
	"fmt"
	"sync"
)

// Singleton Pattern Example in Go
// Thread-safe lazy initialization using sync.Once

type singleton struct{
	value int
}

var (
	instance *singleton
	once sync.Once
)

func GetInstance() *singleton {
	once.Do(func(){
		instance = &singleton{value: 42}
	})
	return instance
}

func main(){
	a := GetInstance()
	b := GetInstance()
	fmt.Println(a == b) // true
	fmt.Println("value=", a.value)
}
