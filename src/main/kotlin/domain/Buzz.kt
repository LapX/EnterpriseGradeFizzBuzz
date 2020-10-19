package domain

open class Buzz() : DivisorHandler {
    private val NAME = "Buzz"
    private val DIVISABLE_BY = 5

    private lateinit var nextHandler: DivisorHandler

    override fun handle(divisor: Int): String {
        return if (divisor % DIVISABLE_BY == 0) NAME else divisor.toString()
    }

    override fun setNext(divisionHandler: DivisorHandler) {
        nextHandler = divisionHandler
    }
}