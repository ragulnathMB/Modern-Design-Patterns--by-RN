// Iterator Pattern Example in JavaScript
// Book collection that can be iterated through

class Book {
  constructor(title, author) { this.title = title; this.author = author }
  toString() { return `${this.title} by ${this.author}` }
}

class Iterator { hasNext() {} next() {} }
class BookCollection { createIterator() {} }

class BookIterator extends Iterator {
  constructor(books) { super(); this.books = books; this.index = 0 }
  hasNext() { return this.index < this.books.length }
  next() { return this.books[this.index++] }
}

class ConcreteBookCollection extends BookCollection {
  constructor() { super(); this.books = [] }
  addBook(book) { this.books.push(book) }
  createIterator() { return new BookIterator(this.books) }
}

;(function main() {
  const collection = new ConcreteBookCollection()
  collection.addBook(new Book('1984', 'George Orwell'))
  collection.addBook(new Book('To Kill a Mockingbird', 'Harper Lee'))
  collection.addBook(new Book('The Great Gatsby', 'F. Scott Fitzgerald'))

  const iterator = collection.createIterator()
  while (iterator.hasNext()) console.log(iterator.next().toString())
})()
