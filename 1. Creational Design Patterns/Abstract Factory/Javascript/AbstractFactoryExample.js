// Abstract Factory Pattern – JavaScript Example
// Usage: node AbstractFactoryExample.js [mac]

// Product A
class Button {
  paint() {
    throw new Error('paint() must be implemented');
  }
}

// Product B
class Checkbox {
  paint() {
    throw new Error('paint() must be implemented');
  }
}

// Concrete Product A1
class WindowsButton extends Button {
  paint() {
    console.log('Render a button in Windows style.');
  }
}

// Concrete Product B1
class WindowsCheckbox extends Checkbox {
  paint() {
    console.log('Render a checkbox in Windows style.');
  }
}

// Concrete Product A2
class MacButton extends Button {
  paint() {
    console.log('Render a button in macOS style.');
  }
}

// Concrete Product B2
class MacCheckbox extends Checkbox {
  paint() {
    console.log('Render a checkbox in macOS style.');
  }
}

// Abstract Factory
class GUIFactory {
  createButton() {}
  createCheckbox() {}
}

// Concrete Factory 1
class WindowsFactory extends GUIFactory {
  createButton() {
    return new WindowsButton();
  }
  createCheckbox() {
    return new WindowsCheckbox();
  }
}

// Concrete Factory 2
class MacFactory extends GUIFactory {
  createButton() {
    return new MacButton();
  }
  createCheckbox() {
    return new MacCheckbox();
  }
}

// Client
class Application {
  constructor(factory) {
    this.button = factory.createButton();
    this.checkbox = factory.createCheckbox();
  }
  paint() {
    this.button.paint();
    this.checkbox.paint();
  }
}

const factory = process.argv[2] && process.argv[2].toLowerCase() === 'mac'
  ? new MacFactory()
  : new WindowsFactory();

const app = new Application(factory);
app.paint();
