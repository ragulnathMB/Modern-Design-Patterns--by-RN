// Visitor Pattern Example in Java
// Document structure with different element types processed by visitors

import java.util.*;

interface DocumentVisitor {
    void visit(Paragraph paragraph);
    void visit(Image image);
    void visit(Table table);
}

interface DocumentElement {
    void accept(DocumentVisitor visitor);
}

class Paragraph implements DocumentElement {
    private final String text;
    public Paragraph(String text) { this.text = text; }
    public String getText() { return text; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

class Image implements DocumentElement {
    private final String filename;
    public Image(String filename) { this.filename = filename; }
    public String getFilename() { return filename; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

class Table implements DocumentElement {
    private final int rows, columns;
    public Table(int rows, int columns) { this.rows = rows; this.columns = columns; }
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

class WordCountVisitor implements DocumentVisitor {
    private int wordCount = 0;
    public int getWordCount() { return wordCount; }
    public void visit(Paragraph paragraph) { wordCount += paragraph.getText().split("\\s+").length; }
    public void visit(Image image) { /* images don't contribute to word count */ }
    public void visit(Table table) { wordCount += table.getRows() * table.getColumns(); /* assume 1 word per cell */ }
}

class PrintVisitor implements DocumentVisitor {
    public void visit(Paragraph paragraph) { System.out.println("Paragraph: " + paragraph.getText()); }
    public void visit(Image image) { System.out.println("Image: " + image.getFilename()); }
    public void visit(Table table) { System.out.println("Table: " + table.getRows() + "x" + table.getColumns()); }
}

public class VisitorExample {
    public static void main(String[] args) {
        List<DocumentElement> elements = Arrays.asList(
            new Paragraph("Hello world from paragraph one."),
            new Image("photo.jpg"),
            new Table(3, 4),
            new Paragraph("This is another paragraph.")
        );

        WordCountVisitor wordCounter = new WordCountVisitor();
        PrintVisitor printer = new PrintVisitor();

        for (DocumentElement element : elements) {
            element.accept(wordCounter);
            element.accept(printer);
        }

        System.out.println("Total word count: " + wordCounter.getWordCount());
    }
}
