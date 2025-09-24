// Abstract Factory Pattern – TypeScript Example
// Compile: tsc AbstractFactoryExample.ts && node AbstractFactoryExample.js [mac]

// Product A
interface Button {
  paint(): void;
}

// Product B
interface Checkbox {
  paint(): void;
}

// Concrete Products
class WindowsButton implements Button {
  paint() { console.log('Render a button in Windows style.'); }
}
class MacButton implements Button {
  paint() { console.log('Render a button in macOS style.'); }
}
class WindowsCheckbox implements Checkbox {
  paint() { console.log('Render a checkbox in Windows style.'); }
}
class MacCheckbox implements Checkbox {
  paint() { console.log('Render a checkbox in macOS style.'); }
}

// Abstract Factory
interface GUIFactory {
  createButton(): Button;
  createCheckbox(): Checkbox;
}

// Concrete Factories
class WindowsFactory implements GUIFactory {
  createButton() { return new WindowsButton(); }
  createCheckbox() { return new WindowsCheckbox(); }
}
class MacFactory implements GUIFactory {
  createButton() { return new MacButton(); }
  createCheckbox() { return new MacCheckbox(); }
}

// Client
class Application {
  constructor(private factory: GUIFactory) {}
  paint() {
    const button = this.factory.createButton();
    const checkbox = this.factory.createCheckbox();
    button.paint();
    checkbox.paint();
  }
}

const factory: GUIFactory = process.argv[2]?.toLowerCase() === 'mac' ? new MacFactory() : new WindowsFactory();
new Application(factory).paint();
