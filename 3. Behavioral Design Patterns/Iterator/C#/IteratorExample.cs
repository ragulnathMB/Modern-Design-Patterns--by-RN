// Iterator Pattern Example in C#
// Book collection that can be iterated through

using System;
using System.Collections.Generic;

namespace IteratorExample
{
    class Book
    {
        public string Title { get; }
        public string Author { get; }
        public Book(string title, string author) { Title = title; Author = author; }
        public override string ToString() => $"{Title} by {Author}";
    }

    interface IIterator<T>
    {
        bool HasNext();
        T Next();
    }

    interface IBookCollection
    {
        IIterator<Book> CreateIterator();
    }

    class BookIterator : IIterator<Book>
    {
        private readonly List<Book> books;
        private int index = 0;
        public BookIterator(List<Book> books) { this.books = books; }
        public bool HasNext() => index < books.Count;
        public Book Next() => books[index++];
    }

    class ConcreteBookCollection : IBookCollection
    {
        private readonly List<Book> books = new();
        public void AddBook(Book book) { books.Add(book); }
        public IIterator<Book> CreateIterator() => new BookIterator(books);
    }

    class Program
    {
        static void Main()
        {
            var collection = new ConcreteBookCollection();
            collection.AddBook(new Book("1984", "George Orwell"));
            collection.AddBook(new Book("To Kill a Mockingbird", "Harper Lee"));
            collection.AddBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

            var iterator = collection.CreateIterator();
            while (iterator.HasNext())
                Console.WriteLine(iterator.Next());
        }
    }
}
