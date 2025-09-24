// Strategy Pattern – Kotlin Template

interface Strategy { fun execute(data: List<Int>): List<Int> }
class ConcreteStrategyA : Strategy { override fun execute(data: List<Int>) = data }
class ConcreteStrategyB : Strategy { override fun execute(data: List<Int>) = data }

class Context(private var strategy: Strategy) {
    fun setStrategy(s: Strategy) { strategy = s }
    fun doWork(data: List<Int>) = strategy.execute(data)
}

fun main(){ val ctx = Context(ConcreteStrategyA()); ctx.doWork(emptyList()) }
