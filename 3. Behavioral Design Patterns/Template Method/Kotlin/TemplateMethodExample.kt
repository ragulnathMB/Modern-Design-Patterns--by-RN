// Template Method Pattern Example in Kotlin
// DataProcessor with CSV and JSON implementations

abstract class DataProcessor {
    fun processData() {
        loadData()
        processDataImpl()
        saveData()
    }
    protected abstract fun loadData()
    protected abstract fun processDataImpl()
    protected abstract fun saveData()
}

class CSVProcessor : DataProcessor() {
    override fun loadData() = println("Loading CSV data")
    override fun processDataImpl() = println("Processing CSV data")
    override fun saveData() = println("Saving CSV data")
}

class JSONProcessor : DataProcessor() {
    override fun loadData() = println("Loading JSON data")
    override fun processDataImpl() = println("Processing JSON data")
    override fun saveData() = println("Saving JSON data")
}

fun main() {
    val csv: DataProcessor = CSVProcessor()
    csv.processData()
    println()
    val json: DataProcessor = JSONProcessor()
    json.processData()
}
