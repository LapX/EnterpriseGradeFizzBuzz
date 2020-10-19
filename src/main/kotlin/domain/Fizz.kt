package domain

open class Fizz() : DivisorHandler {
    private val NAME = "Fizz"
    private val DIVISABLE_BY = 3

    private lateinit var nextHandler: DivisorHandler

    override fun handle(divisor: Int): String {
        return if (divisor % DIVISABLE_BY == 0) NAME else divisor.toString()
    }

    override fun setNext(divisionHandler: DivisorHandler) {
        nextHandler = divisionHandler
    }
}