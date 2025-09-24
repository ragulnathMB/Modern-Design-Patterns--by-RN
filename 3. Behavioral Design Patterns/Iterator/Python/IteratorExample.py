# Iterator Pattern Example in Python
# Book collection that can be iterated through

from abc import ABC, abstractmethod

class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author
    
    def __str__(self):
        return f"{self.title} by {self.author}"

class Iterator(ABC):
    @abstractmethod
    def has_next(self):
        pass
    
    @abstractmethod
    def next(self):
        pass

class BookCollection(ABC):
    @abstractmethod
    def create_iterator(self):
        pass

class BookIterator(Iterator):
    def __init__(self, books):
        self.books = books
        self.index = 0
    
    def has_next(self):
        return self.index < len(self.books)
    
    def next(self):
        if self.has_next():
            book = self.books[self.index]
            self.index += 1
            return book
        return None

class ConcreteBookCollection(BookCollection):
    def __init__(self):
        self.books = []
    
    def add_book(self, book):
        self.books.append(book)
    
    def create_iterator(self):
        return BookIterator(self.books)

def main():
    collection = ConcreteBookCollection()
    collection.add_book(Book("1984", "George Orwell"))
    collection.add_book(Book("To Kill a Mockingbird", "Harper Lee"))
    collection.add_book(Book("The Great Gatsby", "F. Scott Fitzgerald"))
    
    iterator = collection.create_iterator()
    while iterator.has_next():
        book = iterator.next()
        print(book)

if __name__ == "__main__":
    main()
