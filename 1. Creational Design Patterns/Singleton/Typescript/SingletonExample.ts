// Singleton Pattern Example in TypeScript
// Node-friendly, no external typings required.

declare const console: any;

declare const global: any;

class AppConfig {
  private static _instance: AppConfig | null = null;
  public readonly connectionString: string;

  private constructor() {
    this.connectionString = 'redis://localhost:6379';
  }

  public static getInstance(): AppConfig {
    if (!AppConfig._instance) {
      AppConfig._instance = new AppConfig();
    }
    return AppConfig._instance;
  }

  public print(): void {
    console.log('Connection:', this.connectionString);
  }
}

const a = AppConfig.getInstance();
const b = AppConfig.getInstance();
console.log(a === b); // true
a.print();
