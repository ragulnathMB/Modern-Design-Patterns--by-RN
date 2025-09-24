package main

import "fmt"

// Flyweight Pattern Example in Go
// Forest reuses TreeType (intrinsic) via TreeFactory; Tree holds extrinsic x,y.

type TreeType struct{ name, color, texture string }
func (t TreeType) Draw(x, y int){ fmt.Printf("Draw %s [%s,%s] at (%d,%d)\n", t.name, t.color, t.texture, x, y) }

type TreeFactory struct{}
var cache = map[string]TreeType{}
func (TreeFactory) GetTreeType(name, color, texture string) TreeType {
	key := name+"-"+color+"-"+texture
	if t, ok := cache[key]; ok { return t }
	t := TreeType{name, color, texture}
	cache[key] = t
	return t
}

type Tree struct{ x, y int; t TreeType }
func (tr Tree) Draw(){ tr.t.Draw(tr.x, tr.y) }

type Forest struct{ trees []Tree; factory TreeFactory }
func (f *Forest) Plant(x, y int, name, color, texture string){
	t := f.factory.GetTreeType(name, color, texture)
	f.trees = append(f.trees, Tree{x,y,t})
}
func (f Forest) Draw(){ for _, tr := range f.trees { tr.Draw() } }

func main(){
	var forest Forest
	for i:=0;i<5;i++{ forest.Plant(i, i*2, "Oak", "Green", "Rough") }
	for i:=0;i<3;i++{ forest.Plant(i+10, i*3, "Pine", "DarkGreen", "Smooth") }
	forest.Draw()
}
