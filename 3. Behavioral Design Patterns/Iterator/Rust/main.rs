// Iterator Pattern Example in Rust
// Book collection that can be iterated through

#[derive(Debug)]
struct Book {
    title: String,
    author: String,
}

impl Book {
    fn new(title: &str, author: &str) -> Self {
        Self {
            title: title.to_string(),
            author: author.to_string(),
        }
    }
}

impl std::fmt::Display for Book {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "{} by {}", self.title, self.author)
    }
}

trait Iterator<T> {
    fn has_next(&self) -> bool;
    fn next(&mut self) -> Option<&T>;
}

trait BookCollection {
    fn create_iterator(&self) -> BookIterator;
}

struct BookIterator<'a> {
    books: &'a [Book],
    index: usize,
}

impl<'a> BookIterator<'a> {
    fn new(books: &'a [Book]) -> Self {
        Self { books, index: 0 }
    }
}

impl<'a> Iterator<Book> for BookIterator<'a> {
    fn has_next(&self) -> bool {
        self.index < self.books.len()
    }

    fn next(&mut self) -> Option<&Book> {
        if self.has_next() {
            let book = &self.books[self.index];
            self.index += 1;
            Some(book)
        } else {
            None
        }
    }
}

struct ConcreteBookCollection {
    books: Vec<Book>,
}

impl ConcreteBookCollection {
    fn new() -> Self {
        Self { books: Vec::new() }
    }

    fn add_book(&mut self, book: Book) {
        self.books.push(book);
    }
}

impl BookCollection for ConcreteBookCollection {
    fn create_iterator(&self) -> BookIterator {
        BookIterator::new(&self.books)
    }
}

fn main() {
    let mut collection = ConcreteBookCollection::new();
    collection.add_book(Book::new("1984", "George Orwell"));
    collection.add_book(Book::new("To Kill a Mockingbird", "Harper Lee"));
    collection.add_book(Book::new("The Great Gatsby", "F. Scott Fitzgerald"));

    let mut iterator = collection.create_iterator();
    while iterator.has_next() {
        if let Some(book) = iterator.next() {
            println!("{}", book);
        }
    }
}
