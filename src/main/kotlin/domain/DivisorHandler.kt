package domain

interface DivisorHandler {
    fun handle(divisor: Int): String

    fun setNext(divisionHandler: DivisorHandler)
}