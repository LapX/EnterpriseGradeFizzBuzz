package service

import domain.FizzBuzzChainCreator
import service.dto.FizzBuzzDto

open class FizzBuzzService(val fizzBuzzChainCreator: FizzBuzzChainCreator) {
    fun getFizz(): FizzBuzzDto {
        return FizzBuzzDto("Fizz")
    }

    fun getBuzz(): FizzBuzzDto {
        return FizzBuzzDto("Buzz")
    }

    fun getFizzBuzz(): FizzBuzzDto {
        return FizzBuzzDto("FizzBuzz")
    }

    fun convertToFizzBuzz(fizzBuzzRequest: FizzBuzzDto): FizzBuzzDto {
        val divisionHandler = fizzBuzzChainCreator.createChain()
        val result = divisionHandler.handle(fizzBuzzRequest.fizzBuzz.toInt())
        return FizzBuzzDto(result)
    }
}