package domain

open class FizzBuzz : DivisorHandler {
    private val NAME = "FizzBuzz"
    private val BY_FIVE = 5
    private val BY_THREE = 3

    private lateinit var nextHandler: DivisorHandler

    override fun handle(divisor: Int): String {
        return if (byFive(divisor) && byThree(divisor)) NAME else divisor.toString()
    }

    override fun setNext(divisionHandler: DivisorHandler) {
        nextHandler = divisionHandler
    }

    private fun byFive(divisor: Int): Boolean {
        return divisor % BY_FIVE == 0
    }

    private fun byThree(divisor: Int): Boolean {
        return divisor % BY_THREE == 0
    }
}