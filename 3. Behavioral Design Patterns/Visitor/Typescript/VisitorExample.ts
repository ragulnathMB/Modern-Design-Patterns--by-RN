// Visitor Pattern Example in TypeScript
// Document structure with different element types processed by visitors

interface DocumentVisitor {
  visitParagraph(paragraph: Paragraph): void
  visitImage(image: Image): void
  visitTable(table: Table): void
}

interface DocumentElement {
  accept(visitor: DocumentVisitor): void
}

class Paragraph implements DocumentElement {
  constructor(public text: string) {}
  accept(visitor: DocumentVisitor): void { visitor.visitParagraph(this) }
}

class Image implements DocumentElement {
  constructor(public filename: string) {}
  accept(visitor: DocumentVisitor): void { visitor.visitImage(this) }
}

class Table implements DocumentElement {
  constructor(public rows: number, public columns: number) {}
  accept(visitor: DocumentVisitor): void { visitor.visitTable(this) }
}

class WordCountVisitor implements DocumentVisitor {
  private _wordCount = 0
  get wordCount(): number { return this._wordCount }
  visitParagraph(paragraph: Paragraph): void { this._wordCount += paragraph.text.split(/\s+/).length }
  visitImage(image: Image): void { /* images don't contribute to word count */ }
  visitTable(table: Table): void { this._wordCount += table.rows * table.columns /* assume 1 word per cell */ }
}

class PrintVisitor implements DocumentVisitor {
  visitParagraph(paragraph: Paragraph): void { console.log(`Paragraph: ${paragraph.text}`) }
  visitImage(image: Image): void { console.log(`Image: ${image.filename}`) }
  visitTable(table: Table): void { console.log(`Table: ${table.rows}x${table.columns}`) }
}

;(function main() {
  const elements: DocumentElement[] = [
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

export {}
