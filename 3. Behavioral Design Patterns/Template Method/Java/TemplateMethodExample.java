// Template Method Pattern Example in Java
// DataProcessor with CSV and JSON implementations

abstract class DataProcessor {
    public final void processData() {
        loadData();
        processDataImpl();
        saveData();
    }
    protected abstract void loadData();
    protected abstract void processDataImpl();
    protected abstract void saveData();
}

class CSVProcessor extends DataProcessor {
    protected void loadData() { System.out.println("Loading CSV data"); }
    protected void processDataImpl() { System.out.println("Processing CSV data"); }
    protected void saveData() { System.out.println("Saving CSV data"); }
}

class JSONProcessor extends DataProcessor {
    protected void loadData() { System.out.println("Loading JSON data"); }
    protected void processDataImpl() { System.out.println("Processing JSON data"); }
    protected void saveData() { System.out.println("Saving JSON data"); }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        DataProcessor csv = new CSVProcessor();
        csv.processData();
        System.out.println();
        DataProcessor json = new JSONProcessor();
        json.processData();
    }
}
