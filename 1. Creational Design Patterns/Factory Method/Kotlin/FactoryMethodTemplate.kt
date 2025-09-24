// Factory Method – Kotlin Template
interface Product
abstract class Creator { abstract fun factoryMethod(): Product }
class ConcreteProduct: Product
class ConcreteCreator: Creator() { override fun factoryMethod() = ConcreteProduct() }
fun main(){ val creator: Creator = ConcreteCreator(); creator.factoryMethod() }
