// Flyweight Pattern Example in Kotlin
// Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

class TreeType(private val name: String, private val color: String, private val texture: String) {
    fun draw(x: Int, y: Int) = println("Draw $name [$color,$texture] at ($x,$y)")
}

object TreeFactory {
    private val cache = mutableMapOf<String, TreeType>()
    fun getTreeType(name: String, color: String, texture: String): TreeType {
        val key = "$name-$color-$texture"
        return cache.getOrPut(key) { TreeType(name, color, texture) }
    }
}

class Tree(private val x: Int, private val y: Int, private val type: TreeType) {
    fun draw() = type.draw(x, y)
}

class Forest {
    private val trees = mutableListOf<Tree>()
    fun plant(x: Int, y: Int, name: String, color: String, texture: String) {
        val t = TreeFactory.getTreeType(name, color, texture)
        trees.add(Tree(x, y, t))
    }
    fun draw() = trees.forEach { it.draw() }
}

fun main() {
    val forest = Forest()
    repeat(5) { i -> forest.plant(i, i * 2, "Oak", "Green", "Rough") }
    repeat(3) { i -> forest.plant(i + 10, i * 3, "Pine", "DarkGreen", "Smooth") }
    forest.draw()
}
