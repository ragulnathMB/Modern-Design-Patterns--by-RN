# Visitor Pattern Example in Python
# Document structure with different element types processed by visitors

from abc import ABC, abstractmethod

class DocumentVisitor(ABC):
    @abstractmethod
    def visit_paragraph(self, paragraph):
        pass
    
    @abstractmethod
    def visit_image(self, image):
        pass
    
    @abstractmethod
    def visit_table(self, table):
        pass

class DocumentElement(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class Paragraph(DocumentElement):
    def __init__(self, text):
        self.text = text
    
    def accept(self, visitor):
        visitor.visit_paragraph(self)

class Image(DocumentElement):
    def __init__(self, filename):
        self.filename = filename
    
    def accept(self, visitor):
        visitor.visit_image(self)

class Table(DocumentElement):
    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
    
    def accept(self, visitor):
        visitor.visit_table(self)

class WordCountVisitor(DocumentVisitor):
    def __init__(self):
        self.word_count = 0
    
    def visit_paragraph(self, paragraph):
        self.word_count += len(paragraph.text.split())
    
    def visit_image(self, image):
        # images don't contribute to word count
        pass
    
    def visit_table(self, table):
        self.word_count += table.rows * table.columns  # assume 1 word per cell

class PrintVisitor(DocumentVisitor):
    def visit_paragraph(self, paragraph):
        print(f"Paragraph: {paragraph.text}")
    
    def visit_image(self, image):
        print(f"Image: {image.filename}")
    
    def visit_table(self, table):
        print(f"Table: {table.rows}x{table.columns}")

def main():
    elements = [
        Paragraph("Hello world from paragraph one."),
        Image("photo.jpg"),
        Table(3, 4),
        Paragraph("This is another paragraph.")
    ]
    
    word_counter = WordCountVisitor()
    printer = PrintVisitor()
    
    for element in elements:
        element.accept(word_counter)
        element.accept(printer)
    
    print(f"Total word count: {word_counter.word_count}")

if __name__ == "__main__":
    main()
