// Visitor Pattern Example in Kotlin
// Document structure with different element types processed by visitors

interface DocumentVisitor {
    fun visit(paragraph: Paragraph)
    fun visit(image: Image)
    fun visit(table: Table)
}

interface DocumentElement {
    fun accept(visitor: DocumentVisitor)
}

class Paragraph(val text: String) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) = visitor.visit(this)
}

class Image(val filename: String) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) = visitor.visit(this)
}

class Table(val rows: Int, val columns: Int) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) = visitor.visit(this)
}

class WordCountVisitor : DocumentVisitor {
    var wordCount = 0
        private set
    override fun visit(paragraph: Paragraph) { wordCount += paragraph.text.split("\\s+".toRegex()).size }
    override fun visit(image: Image) { /* images don't contribute to word count */ }
    override fun visit(table: Table) { wordCount += table.rows * table.columns /* assume 1 word per cell */ }
}

class PrintVisitor : DocumentVisitor {
    override fun visit(paragraph: Paragraph) = println("Paragraph: ${paragraph.text}")
    override fun visit(image: Image) = println("Image: ${image.filename}")
    override fun visit(table: Table) = println("Table: ${table.rows}x${table.columns}")
}

fun main() {
    val elements = listOf(
        Paragraph("Hello world from paragraph one."),
        Image("photo.jpg"),
        Table(3, 4),
        Paragraph("This is another paragraph.")
    )

    val wordCounter = WordCountVisitor()
    val printer = PrintVisitor()

    for (element in elements) {
        element.accept(wordCounter)
        element.accept(printer)
    }

    println("Total word count: ${wordCounter.wordCount}")
}
