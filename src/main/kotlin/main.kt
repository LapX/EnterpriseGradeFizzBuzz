import domain.FizzBuzzChainCreator
import resource.FizzBuzzResource
import service.FizzBuzzService

fun main(args: Array<String>) {
    val fizzBuzzChainCreator = FizzBuzzChainCreator()
    val fizzBuzzService = FizzBuzzService(fizzBuzzChainCreator)
    FizzBuzzResource(fizzBuzzService)
}