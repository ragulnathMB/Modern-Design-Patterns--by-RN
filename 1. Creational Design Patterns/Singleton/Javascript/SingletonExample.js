// Singleton Pattern Example in JavaScript (Node)
// Lazy initialization with a module-scoped instance.

class AppConfig {
  constructor() {
    if (AppConfig._instance) {
      return AppConfig._instance;
    }
    this.connectionString = 'mongodb://localhost:27017/app';
    AppConfig._instance = this;
  }

  static getInstance() {
    if (!AppConfig._instance) {
      AppConfig._instance = new AppConfig();
    }
    return AppConfig._instance;
  }

  print() {
    console.log('Connection:', this.connectionString);
  }
}

const a = AppConfig.getInstance();
const b = AppConfig.getInstance();
console.log(a === b); // true
a.print();
