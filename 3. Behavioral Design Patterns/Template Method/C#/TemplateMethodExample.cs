// Template Method Pattern Example in C#
// DataProcessor with CSV and JSON implementations

using System;

namespace TemplateMethodExample
{
    abstract class DataProcessor
    {
        public void ProcessData()
        {
            LoadData();
            ProcessDataImpl();
            SaveData();
        }
        protected abstract void LoadData();
        protected abstract void ProcessDataImpl();
        protected abstract void SaveData();
    }

    class CSVProcessor : DataProcessor
    {
        protected override void LoadData() => Console.WriteLine("Loading CSV data");
        protected override void ProcessDataImpl() => Console.WriteLine("Processing CSV data");
        protected override void SaveData() => Console.WriteLine("Saving CSV data");
    }

    class JSONProcessor : DataProcessor
    {
        protected override void LoadData() => Console.WriteLine("Loading JSON data");
        protected override void ProcessDataImpl() => Console.WriteLine("Processing JSON data");
        protected override void SaveData() => Console.WriteLine("Saving JSON data");
    }

    class Program
    {
        static void Main()
        {
            DataProcessor csv = new CSVProcessor();
            csv.ProcessData();
            Console.WriteLine();
            DataProcessor json = new JSONProcessor();
            json.ProcessData();
        }
    }
}
