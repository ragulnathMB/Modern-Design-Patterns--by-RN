// Abstract Factory Pattern – Kotlin Example
// Compile & run: kotlinc AbstractFactoryExample.kt -include-runtime -d example.jar && java -jar example.jar [mac]

// Product A
interface Button {
    fun paint()
}

// Product B
interface Checkbox {
    fun paint()
}

// Concrete Products
class WindowsButton : Button {
    override fun paint() = println("Render a button in Windows style.")
}

class MacButton : Button {
    override fun paint() = println("Render a button in macOS style.")
}

class WindowsCheckbox : Checkbox {
    override fun paint() = println("Render a checkbox in Windows style.")
}

class MacCheckbox : Checkbox {
    override fun paint() = println("Render a checkbox in macOS style.")
}

// Abstract Factory
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

// Concrete Factories
class WindowsFactory : GUIFactory {
    override fun createButton() = WindowsButton()
    override fun createCheckbox() = WindowsCheckbox()
}

class MacFactory : GUIFactory {
    override fun createButton() = MacButton()
    override fun createCheckbox() = MacCheckbox()
}

// Client
class Application(factory: GUIFactory) {
    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()
    fun paint() {
        button.paint()
        checkbox.paint()
    }
}

fun main(args: Array<String>) {
    val factory: GUIFactory = if (args.isNotEmpty() && args[0].equals("mac", ignoreCase = true)) MacFactory() else WindowsFactory()
    Application(factory).paint()
}
