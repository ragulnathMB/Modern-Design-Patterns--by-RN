// Template Method Pattern Example in TypeScript
// DataProcessor with CSV and JSON implementations

abstract class DataProcessor {
  processData(): void {
    this.loadData()
    this.processDataImpl()
    this.saveData()
  }
  protected abstract loadData(): void
  protected abstract processDataImpl(): void
  protected abstract saveData(): void
}

class CSVProcessor extends DataProcessor {
  protected loadData(): void { console.log('Loading CSV data') }
  protected processDataImpl(): void { console.log('Processing CSV data') }
  protected saveData(): void { console.log('Saving CSV data') }
}

class JSONProcessor extends DataProcessor {
  protected loadData(): void { console.log('Loading JSON data') }
  protected processDataImpl(): void { console.log('Processing JSON data') }
  protected saveData(): void { console.log('Saving JSON data') }
}

;(function main() {
  const csv: DataProcessor = new CSVProcessor()
  csv.processData()
  console.log()
  const json: DataProcessor = new JSONProcessor()
  json.processData()
})()

export {}
