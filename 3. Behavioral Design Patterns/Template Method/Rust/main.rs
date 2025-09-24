// Template Method Pattern Example in Rust
// DataProcessor with CSV and JSON implementations

trait DataProcessor {
    fn process_data(&self) {
        self.load_data();
        self.process_data_impl();
        self.save_data();
    }
    fn load_data(&self);
    fn process_data_impl(&self);
    fn save_data(&self);
}

struct CSVProcessor;
impl DataProcessor for CSVProcessor {
    fn load_data(&self) { println!("Loading CSV data"); }
    fn process_data_impl(&self) { println!("Processing CSV data"); }
    fn save_data(&self) { println!("Saving CSV data"); }
}

struct JSONProcessor;
impl DataProcessor for JSONProcessor {
    fn load_data(&self) { println!("Loading JSON data"); }
    fn process_data_impl(&self) { println!("Processing JSON data"); }
    fn save_data(&self) { println!("Saving JSON data"); }
}

fn main() {
    let csv = CSVProcessor;
    csv.process_data();
    println!();
    let json = JSONProcessor;
    json.process_data();
}
