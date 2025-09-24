// Template Method Pattern Example in JavaScript
// DataProcessor with CSV and JSON implementations

class DataProcessor {
  processData() {
    this.loadData()
    this.processDataImpl()
    this.saveData()
  }
  loadData() { throw new Error('Abstract method') }
  processDataImpl() { throw new Error('Abstract method') }
  saveData() { throw new Error('Abstract method') }
}

class CSVProcessor extends DataProcessor {
  loadData() { console.log('Loading CSV data') }
  processDataImpl() { console.log('Processing CSV data') }
  saveData() { console.log('Saving CSV data') }
}

class JSONProcessor extends DataProcessor {
  loadData() { console.log('Loading JSON data') }
  processDataImpl() { console.log('Processing JSON data') }
  saveData() { console.log('Saving JSON data') }
}

;(function main() {
  const csv = new CSVProcessor()
  csv.processData()
  console.log()
  const json = new JSONProcessor()
  json.processData()
})()
