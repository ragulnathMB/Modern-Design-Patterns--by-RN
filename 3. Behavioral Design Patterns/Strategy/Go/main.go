package main

import "fmt"

// Strategy Pattern Example in Go
// Sorter with BubbleSort and QuickSort strategies

type SortStrategy interface{ Sort([]int) []int }

type BubbleSort struct{}
func (BubbleSort) Sort(data []int) []int {
	arr := append([]int(nil), data...)
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr)-i-1; j++ {
			if arr[j] > arr[j+1] { arr[j], arr[j+1] = arr[j+1], arr[j] }
		}
	}
	fmt.Println("BubbleSort used")
	return arr
}

type QuickSort struct{}
func (QuickSort) Sort(data []int) []int {
	arr := append([]int(nil), data...)
	// simple selection sort for demo brevity
	for i := 0; i < len(arr); i++ {
		minIdx := i
		for j := i+1; j < len(arr); j++ { if arr[j] < arr[minIdx] { minIdx = j } }
		arr[i], arr[minIdx] = arr[minIdx], arr[i]
	}
	fmt.Println("QuickSort used")
	return arr
}

type Sorter struct{ s SortStrategy }
func (so *Sorter) SetStrategy(s SortStrategy){ so.s = s }
func (so Sorter) Sort(data []int) []int { return so.s.Sort(data) }

func main(){
	data := []int{5,2,9,1,5,6}
	so := Sorter{ s: BubbleSort{} }
	fmt.Println(so.Sort(data))
	so.SetStrategy(QuickSort{})
	fmt.Println(so.Sort(data))
}
