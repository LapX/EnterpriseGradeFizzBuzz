import resource.FizzBuzzResource
import service.FizzBuzzService

fun main(args: Array<String>) {
    val fizzBuzzService = FizzBuzzService()
    FizzBuzzResource(fizzBuzzService)
}