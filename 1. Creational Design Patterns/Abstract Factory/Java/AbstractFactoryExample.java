// Abstract Factory Pattern – Java implementation
// Compile: javac AbstractFactoryExample.java
// Run: java AbstractFactoryExample [mac]

interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

class WindowsButton implements Button {
    public void paint() {
        System.out.println("Render a button in Windows style.");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Render a button in macOS style.");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Render a checkbox in Windows style.");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Render a checkbox in macOS style.");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

class Application {
    private final Button button;
    private final Checkbox checkbox;
    Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    void paint() {
        button.paint();
        checkbox.paint();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        GUIFactory factory;
        if (args.length > 0 && args[0].equalsIgnoreCase("mac"))
            factory = new MacFactory();
        else
            factory = new WindowsFactory();
        Application app = new Application(factory);
        app.paint();
    }
}
