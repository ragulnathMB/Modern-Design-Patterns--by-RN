# Singleton Pattern Example in Python
# Database connection manager ensuring single instance

class DatabaseConnection:
    _instance = None
    _initialized = False
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(DatabaseConnection, cls).__new__(cls)
        return cls._instance
    
    def __init__(self):
        if not DatabaseConnection._initialized:
            self.connection_string = "Database connected"
            self.is_connected = True
            DatabaseConnection._initialized = True
            print("Database connection established")
    
    def query(self, sql):
        if self.is_connected:
            return f"Executing: {sql}"
        return "No connection available"
    
    def get_connection_info(self):
        return f"Connection: {self.connection_string}, Status: {'Connected' if self.is_connected else 'Disconnected'}"

def main():
    # Both variables will reference the same instance
    db1 = DatabaseConnection()
    db2 = DatabaseConnection()
    
    print(f"db1 is db2: {db1 is db2}")
    print(db1.get_connection_info())
    print(db1.query("SELECT * FROM users"))
    print(db2.query("SELECT * FROM products"))

if __name__ == "__main__":
    main()
