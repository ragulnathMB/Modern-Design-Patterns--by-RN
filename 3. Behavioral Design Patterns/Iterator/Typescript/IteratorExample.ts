// Iterator Pattern Example in TypeScript
// Book collection that can be iterated through

class Book {
  constructor(public title: string, public author: string) {}
  toString(): string { return `${this.title} by ${this.author}` }
}

interface Iterator<T> { hasNext(): boolean; next(): T }
interface BookCollection { createIterator(): Iterator<Book> }

class BookIterator implements Iterator<Book> {
  private index = 0
  constructor(private books: Book[]) {}
  hasNext(): boolean { return this.index < this.books.length }
  next(): Book { return this.books[this.index++] }
}

class ConcreteBookCollection implements BookCollection {
  private books: Book[] = []
  addBook(book: Book): void { this.books.push(book) }
  createIterator(): Iterator<Book> { return new BookIterator(this.books) }
}

;(function main() {
  const collection = new ConcreteBookCollection()
  collection.addBook(new Book('1984', 'George Orwell'))
  collection.addBook(new Book('To Kill a Mockingbird', 'Harper Lee'))
  collection.addBook(new Book('The Great Gatsby', 'F. Scott Fitzgerald'))

  const iterator = collection.createIterator()
  while (iterator.hasNext()) console.log(iterator.next().toString())
})()

export {}
