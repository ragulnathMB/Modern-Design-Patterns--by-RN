package main

import (
	"fmt"
	"strings"
)

// Visitor Pattern Example in Go
// Document structure with different element types processed by visitors

type DocumentVisitor interface {
	VisitParagraph(*Paragraph)
	VisitImage(*Image)
	VisitTable(*Table)
}

type DocumentElement interface {
	Accept(DocumentVisitor)
}

type Paragraph struct {
	Text string
}

func (p *Paragraph) Accept(visitor DocumentVisitor) {
	visitor.VisitParagraph(p)
}

type Image struct {
	Filename string
}

func (i *Image) Accept(visitor DocumentVisitor) {
	visitor.VisitImage(i)
}

type Table struct {
	Rows    int
	Columns int
}

func (t *Table) Accept(visitor DocumentVisitor) {
	visitor.VisitTable(t)
}

type WordCountVisitor struct {
	WordCount int
}

func (w *WordCountVisitor) VisitParagraph(p *Paragraph) {
	words := strings.Fields(p.Text)
	w.WordCount += len(words)
}

func (w *WordCountVisitor) VisitImage(i *Image) {
	// images don't contribute to word count
}

func (w *WordCountVisitor) VisitTable(t *Table) {
	w.WordCount += t.Rows * t.Columns // assume 1 word per cell
}

type PrintVisitor struct{}

func (pv *PrintVisitor) VisitParagraph(p *Paragraph) {
	fmt.Printf("Paragraph: %s\n", p.Text)
}

func (pv *PrintVisitor) VisitImage(i *Image) {
	fmt.Printf("Image: %s\n", i.Filename)
}

func (pv *PrintVisitor) VisitTable(t *Table) {
	fmt.Printf("Table: %dx%d\n", t.Rows, t.Columns)
}

func main() {
	elements := []DocumentElement{
		&Paragraph{"Hello world from paragraph one."},
		&Image{"photo.jpg"},
		&Table{3, 4},
		&Paragraph{"This is another paragraph."},
	}

	wordCounter := &WordCountVisitor{}
	printer := &PrintVisitor{}

	for _, element := range elements {
		element.Accept(wordCounter)
		element.Accept(printer)
	}

	fmt.Printf("Total word count: %d\n", wordCounter.WordCount)
}
