# Template Method Pattern Example in Python
# DataProcessor with CSV and JSON implementations

from abc import ABC, abstractmethod

class DataProcessor(ABC):
    def process_data(self):
        self.load_data()
        self.process_data_impl()
        self.save_data()
    
    @abstractmethod
    def load_data(self):
        pass
    
    @abstractmethod
    def process_data_impl(self):
        pass
    
    @abstractmethod
    def save_data(self):
        pass

class CSVProcessor(DataProcessor):
    def load_data(self):
        print("Loading CSV data")
    
    def process_data_impl(self):
        print("Processing CSV data")
    
    def save_data(self):
        print("Saving CSV data")

class JSONProcessor(DataProcessor):
    def load_data(self):
        print("Loading JSON data")
    
    def process_data_impl(self):
        print("Processing JSON data")
    
    def save_data(self):
        print("Saving JSON data")

def main():
    csv_processor = CSVProcessor()
    csv_processor.process_data()
    print()
    
    json_processor = JSONProcessor()
    json_processor.process_data()

if __name__ == "__main__":
    main()
