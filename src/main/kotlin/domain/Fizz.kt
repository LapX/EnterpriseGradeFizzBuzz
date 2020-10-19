package domain

open class Fizz() : DivisorHandler {
    private val NAME = "Fizz"
    private val DIVISABLE_BY = 3

    private var nextHandler: DivisorHandler? = null

    override fun handle(divisor: Int): String {
        val answer = if (divisor % DIVISABLE_BY == 0) NAME else nextHandler?.handle(divisor)
        return answer ?: divisor.toString()
    }

    override fun setNext(divisionHandler: DivisorHandler) {
        nextHandler = divisionHandler
    }
}