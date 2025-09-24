// Iterator Pattern Example in Kotlin
// Book collection that can be iterated through

data class Book(val title: String, val author: String) {
    override fun toString() = "$title by $author"
}

interface Iterator<T> { fun hasNext(): Boolean; fun next(): T }
interface BookCollection { fun createIterator(): Iterator<Book> }

class BookIterator(private val books: List<Book>) : Iterator<Book> {
    private var index = 0
    override fun hasNext() = index < books.size
    override fun next() = books[index++]
}

class ConcreteBookCollection : BookCollection {
    private val books = mutableListOf<Book>()
    fun addBook(book: Book) = books.add(book)
    override fun createIterator(): Iterator<Book> = BookIterator(books)
}

fun main() {
    val collection = ConcreteBookCollection()
    collection.addBook(Book("1984", "George Orwell"))
    collection.addBook(Book("To Kill a Mockingbird", "Harper Lee"))
    collection.addBook(Book("The Great Gatsby", "F. Scott Fitzgerald"))

    val iterator = collection.createIterator()
    while (iterator.hasNext()) println(iterator.next())
}
