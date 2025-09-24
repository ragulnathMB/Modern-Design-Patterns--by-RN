package main

import "fmt"

// Composite Pattern Example in Go
// File system: File (leaf) and Directory (composite)

type Component interface{ Display(int); GetSize() int }

type File struct{ name string; size int }
func (f File) Display(depth int){ fmt.Printf("%sFile: %s (%dKB)\n", indent(depth), f.name, f.size) }
func (f File) GetSize() int{ return f.size }

type Directory struct{ name string; items []Component }
func (d *Directory) Add(c Component){ d.items = append(d.items, c) }
func (d Directory) Display(depth int){
	fmt.Printf("%sDirectory: %s/\n", indent(depth), d.name)
	for _, item := range d.items{ item.Display(depth+1) }
}
func (d Directory) GetSize() int{
	total := 0
	for _, item := range d.items{ total += item.GetSize() }
	return total
}

func indent(depth int) string{ s := ""; for i:=0; i<depth*2; i++{ s += " " }; return s }

func main(){
	root := &Directory{name: "root"}
	docs := &Directory{name: "docs"}
	docs.Add(File{name: "readme.txt", size: 5})
	docs.Add(File{name: "manual.pdf", size: 150})
	root.Add(docs)
	root.Add(File{name: "config.ini", size: 2})
	root.Display(0)
	fmt.Printf("Total size: %dKB\n", root.GetSize())
}
