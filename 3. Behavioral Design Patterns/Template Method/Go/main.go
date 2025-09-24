package main

import "fmt"

// Template Method Pattern Example in Go
// DataProcessor with CSV and JSON implementations

type DataProcessor interface {
	ProcessData()
	LoadData()
	ProcessDataImpl()
	SaveData()
}

type BaseProcessor struct {
	impl DataProcessor
}

func (b *BaseProcessor) ProcessData() {
	b.impl.LoadData()
	b.impl.ProcessDataImpl()
	b.impl.SaveData()
}

type CSVProcessor struct {
	BaseProcessor
}

func NewCSVProcessor() *CSVProcessor {
	p := &CSVProcessor{}
	p.impl = p
	return p
}

func (c *CSVProcessor) LoadData()        { fmt.Println("Loading CSV data") }
func (c *CSVProcessor) ProcessDataImpl() { fmt.Println("Processing CSV data") }
func (c *CSVProcessor) SaveData()        { fmt.Println("Saving CSV data") }

type JSONProcessor struct {
	BaseProcessor
}

func NewJSONProcessor() *JSONProcessor {
	p := &JSONProcessor{}
	p.impl = p
	return p
}

func (j *JSONProcessor) LoadData()        { fmt.Println("Loading JSON data") }
func (j *JSONProcessor) ProcessDataImpl() { fmt.Println("Processing JSON data") }
func (j *JSONProcessor) SaveData()        { fmt.Println("Saving JSON data") }

func main() {
	csv := NewCSVProcessor()
	csv.ProcessData()
	fmt.Println()
	json := NewJSONProcessor()
	json.ProcessData()
}
