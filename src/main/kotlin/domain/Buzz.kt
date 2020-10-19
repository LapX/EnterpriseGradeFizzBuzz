package domain

open class Buzz() : DivisorHandler {
    private val NAME = "Buzz"
    private val DIVISABLE_BY = 5

    private var nextHandler: DivisorHandler? = null

    override fun handle(divisor: Int): String {
        val answer = if (divisor % DIVISABLE_BY == 0) NAME else nextHandler?.handle(divisor)
        return answer ?: divisor.toString()
    }

    override fun setNext(divisionHandler: DivisorHandler) {
        nextHandler = divisionHandler
    }
}