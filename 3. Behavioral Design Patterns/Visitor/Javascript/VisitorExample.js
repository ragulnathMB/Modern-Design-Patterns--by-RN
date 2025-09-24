// Visitor Pattern Example in JavaScript
// Document structure with different element types processed by visitors

class DocumentVisitor {
  visitParagraph(paragraph) {}
  visitImage(image) {}
  visitTable(table) {}
}

class DocumentElement {
  accept(visitor) {}
}

class Paragraph extends DocumentElement {
  constructor(text) { super(); this.text = text }
  accept(visitor) { visitor.visitParagraph(this) }
}

class Image extends DocumentElement {
  constructor(filename) { super(); this.filename = filename }
  accept(visitor) { visitor.visitImage(this) }
}

class Table extends DocumentElement {
  constructor(rows, columns) { super(); this.rows = rows; this.columns = columns }
  accept(visitor) { visitor.visitTable(this) }
}

class WordCountVisitor extends DocumentVisitor {
  constructor() { super(); this.wordCount = 0 }
  visitParagraph(paragraph) { this.wordCount += paragraph.text.split(/\s+/).length }
  visitImage(image) { /* images don't contribute to word count */ }
  visitTable(table) { this.wordCount += table.rows * table.columns /* assume 1 word per cell */ }
}

class PrintVisitor extends DocumentVisitor {
  visitParagraph(paragraph) { console.log(`Paragraph: ${paragraph.text}`) }
  visitImage(image) { console.log(`Image: ${image.filename}`) }
  visitTable(table) { console.log(`Table: ${table.rows}x${table.columns}`) }
}

;(function main() {
  const elements = [
    new Paragraph('Hello world from paragraph one.'),
    new Image('photo.jpg'),
    new Table(3, 4),
    new Paragraph('This is another paragraph.')
  ]

  const wordCounter = new WordCountVisitor()
  const printer = new PrintVisitor()

  for (const element of elements) {
    element.accept(wordCounter)
    element.accept(printer)
  }

  console.log(`Total word count: ${wordCounter.wordCount}`)
})()
