// Memento Pattern Example in Kotlin
// Text editor that can save and restore document states

data class TextMemento(val content: String)

class TextEditor {
    private var content = ""
    fun write(text: String) { content += text }
    fun clear() { content = "" }
    fun getContent() = content
    fun save() = TextMemento(content)
    fun restore(memento: TextMemento) { content = memento.content }
}

class EditorHistory {
    private val history = mutableListOf<TextMemento>()
    fun save(editor: TextEditor) = history.add(editor.save())
    fun undo(editor: TextEditor) { if (history.isNotEmpty()) editor.restore(history.removeLastOrNull()!!) }
}

fun main() {
    val editor = TextEditor()
    val history = EditorHistory()

    editor.write("Hello ")
    history.save(editor)
    println("Content: ${editor.getContent()}")

    editor.write("World!")
    history.save(editor)
    println("Content: ${editor.getContent()}")

    history.undo(editor)
    println("After undo: ${editor.getContent()}")

    history.undo(editor)
    println("After undo: ${editor.getContent()}")
}
