package main

import "fmt"

// Iterator Pattern Example in Go
// Book collection that can be iterated through

type Book struct {
	Title  string
	Author string
}

func (b Book) String() string {
	return fmt.Sprintf("%s by %s", b.Title, b.Author)
}

type Iterator interface {
	HasNext() bool
	Next() interface{}
}

type BookCollection interface {
	CreateIterator() Iterator
}

type BookIterator struct {
	books []Book
	index int
}

func NewBookIterator(books []Book) *BookIterator {
	return &BookIterator{books: books, index: 0}
}

func (bi *BookIterator) HasNext() bool {
	return bi.index < len(bi.books)
}

func (bi *BookIterator) Next() interface{} {
	if bi.HasNext() {
		book := bi.books[bi.index]
		bi.index++
		return book
	}
	return nil
}

type ConcreteBookCollection struct {
	books []Book
}

func NewConcreteBookCollection() *ConcreteBookCollection {
	return &ConcreteBookCollection{books: make([]Book, 0)}
}

func (cbc *ConcreteBookCollection) AddBook(book Book) {
	cbc.books = append(cbc.books, book)
}

func (cbc *ConcreteBookCollection) CreateIterator() Iterator {
	return NewBookIterator(cbc.books)
}

func main() {
	collection := NewConcreteBookCollection()
	collection.AddBook(Book{"1984", "George Orwell"})
	collection.AddBook(Book{"To Kill a Mockingbird", "Harper Lee"})
	collection.AddBook(Book{"The Great Gatsby", "F. Scott Fitzgerald"})

	iterator := collection.CreateIterator()
	for iterator.HasNext() {
		book := iterator.Next().(Book)
		fmt.Println(book)
	}
}
