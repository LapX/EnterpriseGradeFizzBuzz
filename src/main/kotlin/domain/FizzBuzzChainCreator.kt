package domain

open class FizzBuzzChainCreator {
    fun createChain(): DivisorHandler {
        val fizzBuzzHandler = FizzBuzz()
        val fizzHandler = Fizz()
        val buzzHandler = Buzz()

        fizzBuzzHandler.setNext(fizzHandler)
        fizzHandler.setNext(buzzHandler)

        return fizzBuzzHandler
    }
}