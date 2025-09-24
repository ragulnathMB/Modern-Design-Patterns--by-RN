// Composite Pattern Example in Kotlin
// File system: File (leaf) and Directory (composite)

interface FSItem { fun display(depth: Int = 0); fun size(): Int }

class FSFile(private val name: String, private val s: Int) : FSItem {
    override fun display(depth: Int) = println("${" ".repeat(depth*2)}File: $name (${s}KB)")
    override fun size(): Int = s
}

class Directory(private val name: String) : FSItem {
    private val items = mutableListOf<FSItem>()
    fun add(it: FSItem) = items.add(it)
    fun remove(it: FSItem) = items.remove(it)
    override fun display(depth: Int) {
        println("${" ".repeat(depth*2)}Directory: $name/")
        items.forEach { it.display(depth + 1) }
    }
    override fun size(): Int = items.sumOf { it.size() }
}

fun main(){
    val root = Directory("root")
    val docs = Directory("docs")
    docs.add(FSFile("readme.txt",5))
    docs.add(FSFile("manual.pdf",150))
    root.add(docs)
    root.add(FSFile("config.ini",2))
    root.display()
    println("Total size: ${root.size()}KB")
}
