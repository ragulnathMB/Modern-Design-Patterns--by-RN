// Visitor Pattern Example in C#
// Document structure with different element types processed by visitors

using System;
using System.Collections.Generic;

namespace VisitorExample
{
    interface IDocumentVisitor
    {
        void Visit(Paragraph paragraph);
        void Visit(Image image);
        void Visit(Table table);
    }

    interface IDocumentElement
    {
        void Accept(IDocumentVisitor visitor);
    }

    class Paragraph : IDocumentElement
    {
        public string Text { get; }
        public Paragraph(string text) { Text = text; }
        public void Accept(IDocumentVisitor visitor) { visitor.Visit(this); }
    }

    class Image : IDocumentElement
    {
        public string Filename { get; }
        public Image(string filename) { Filename = filename; }
        public void Accept(IDocumentVisitor visitor) { visitor.Visit(this); }
    }

    class Table : IDocumentElement
    {
        public int Rows { get; }
        public int Columns { get; }
        public Table(int rows, int columns) { Rows = rows; Columns = columns; }
        public void Accept(IDocumentVisitor visitor) { visitor.Visit(this); }
    }

    class WordCountVisitor : IDocumentVisitor
    {
        public int WordCount { get; private set; }
        public void Visit(Paragraph paragraph) { WordCount += paragraph.Text.Split(' ', StringSplitOptions.RemoveEmptyEntries).Length; }
        public void Visit(Image image) { /* images don't contribute to word count */ }
        public void Visit(Table table) { WordCount += table.Rows * table.Columns; /* assume 1 word per cell */ }
    }

    class PrintVisitor : IDocumentVisitor
    {
        public void Visit(Paragraph paragraph) { Console.WriteLine($"Paragraph: {paragraph.Text}"); }
        public void Visit(Image image) { Console.WriteLine($"Image: {image.Filename}"); }
        public void Visit(Table table) { Console.WriteLine($"Table: {table.Rows}x{table.Columns}"); }
    }

    class Program
    {
        static void Main()
        {
            var elements = new List<IDocumentElement>
            {
                new Paragraph("Hello world from paragraph one."),
                new Image("photo.jpg"),
                new Table(3, 4),
                new Paragraph("This is another paragraph.")
            };

            var wordCounter = new WordCountVisitor();
            var printer = new PrintVisitor();

            foreach (var element in elements)
            {
                element.Accept(wordCounter);
                element.Accept(printer);
            }

            Console.WriteLine($"Total word count: {wordCounter.WordCount}");
        }
    }
}
