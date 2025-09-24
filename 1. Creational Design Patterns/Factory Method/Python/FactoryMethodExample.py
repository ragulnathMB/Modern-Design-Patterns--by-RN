# Factory Method Pattern Example in Python
# Document processing with different document types

from abc import ABC, abstractmethod

class Document(ABC):
    @abstractmethod
    def create_content(self):
        pass

class PDFDocument(Document):
    def create_content(self):
        return "PDF document content created"

class WordDocument(Document):
    def create_content(self):
        return "Word document content created"

class DocumentCreator(ABC):
    @abstractmethod
    def create_document(self):
        pass
    
    def process_document(self):
        doc = self.create_document()
        return f"Processing: {doc.create_content()}"

class PDFCreator(DocumentCreator):
    def create_document(self):
        return PDFDocument()

class WordCreator(DocumentCreator):
    def create_document(self):
        return WordDocument()

def main():
    pdf_creator = PDFCreator()
    word_creator = WordCreator()
    
    print(pdf_creator.process_document())
    print(word_creator.process_document())

if __name__ == "__main__":
    main()
