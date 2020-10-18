package service

import service.dto.FizzBuzzDto

class FizzBuzzService {
    fun getFizz(): FizzBuzzDto {
        return FizzBuzzDto("Fizz")
    }

    fun getBuzz(): FizzBuzzDto {
        return FizzBuzzDto("Buzz")
    }

    fun convertToFizzBuzz(fizzBuzzRequest: FizzBuzzDto): FizzBuzzDto {
        return FizzBuzzDto(fizzBuzzRequest.fizzBuzz)
    }
}