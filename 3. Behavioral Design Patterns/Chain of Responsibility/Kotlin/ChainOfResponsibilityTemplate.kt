// Chain of Responsibility Pattern – Kotlin Template

abstract class Handler {
    protected var nextHandler: Handler? = null
    fun setNext(handler: Handler) { nextHandler = handler }
    abstract fun handleRequest(request: Request)
}

data class Request(val data: String = "")

class ConcreteHandlerA : Handler() {
    override fun handleRequest(request: Request) {
        when {
            canHandle(request) -> processRequest(request)
            nextHandler != null -> nextHandler!!.handleRequest(request)
        }
    }
    private fun canHandle(request: Request) = true /* condition */
    private fun processRequest(request: Request) { /* handle */ }
}

class ConcreteHandlerB : Handler() {
    override fun handleRequest(request: Request) {
        when {
            canHandle(request) -> processRequest(request)
            nextHandler != null -> nextHandler!!.handleRequest(request)
        }
    }
    private fun canHandle(request: Request) = true /* condition */
    private fun processRequest(request: Request) { /* handle */ }
}

fun main() {
    val handlerA = ConcreteHandlerA()
    val handlerB = ConcreteHandlerB()
    handlerA.setNext(handlerB)
    handlerA.handleRequest(Request())
}
