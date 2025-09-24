// Visitor Pattern Example in Rust
// Document structure with different element types processed by visitors

trait DocumentVisitor {
    fn visit_paragraph(&mut self, paragraph: &Paragraph);
    fn visit_image(&mut self, image: &Image);
    fn visit_table(&mut self, table: &Table);
}

trait DocumentElement {
    fn accept(&self, visitor: &mut dyn DocumentVisitor);
}

struct Paragraph {
    text: String,
}

impl Paragraph {
    fn new(text: &str) -> Self {
        Self { text: text.to_string() }
    }
}

impl DocumentElement for Paragraph {
    fn accept(&self, visitor: &mut dyn DocumentVisitor) {
        visitor.visit_paragraph(self);
    }
}

struct Image {
    filename: String,
}

impl Image {
    fn new(filename: &str) -> Self {
        Self { filename: filename.to_string() }
    }
}

impl DocumentElement for Image {
    fn accept(&self, visitor: &mut dyn DocumentVisitor) {
        visitor.visit_image(self);
    }
}

struct Table {
    rows: usize,
    columns: usize,
}

impl Table {
    fn new(rows: usize, columns: usize) -> Self {
        Self { rows, columns }
    }
}

impl DocumentElement for Table {
    fn accept(&self, visitor: &mut dyn DocumentVisitor) {
        visitor.visit_table(self);
    }
}

struct WordCountVisitor {
    word_count: usize,
}

impl WordCountVisitor {
    fn new() -> Self {
        Self { word_count: 0 }
    }

    fn get_word_count(&self) -> usize {
        self.word_count
    }
}

impl DocumentVisitor for WordCountVisitor {
    fn visit_paragraph(&mut self, paragraph: &Paragraph) {
        self.word_count += paragraph.text.split_whitespace().count();
    }

    fn visit_image(&mut self, _image: &Image) {
        // images don't contribute to word count
    }

    fn visit_table(&mut self, table: &Table) {
        self.word_count += table.rows * table.columns; // assume 1 word per cell
    }
}

struct PrintVisitor;

impl DocumentVisitor for PrintVisitor {
    fn visit_paragraph(&mut self, paragraph: &Paragraph) {
        println!("Paragraph: {}", paragraph.text);
    }

    fn visit_image(&mut self, image: &Image) {
        println!("Image: {}", image.filename);
    }

    fn visit_table(&mut self, table: &Table) {
        println!("Table: {}x{}", table.rows, table.columns);
    }
}

fn main() {
    let elements: Vec<Box<dyn DocumentElement>> = vec![
        Box::new(Paragraph::new("Hello world from paragraph one.")),
        Box::new(Image::new("photo.jpg")),
        Box::new(Table::new(3, 4)),
        Box::new(Paragraph::new("This is another paragraph.")),
    ];

    let mut word_counter = WordCountVisitor::new();
    let mut printer = PrintVisitor;

    for element in &elements {
        element.accept(&mut word_counter);
        element.accept(&mut printer);
    }

    println!("Total word count: {}", word_counter.get_word_count());
}
