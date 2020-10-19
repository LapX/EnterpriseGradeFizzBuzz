package resource

import com.google.gson.Gson
import service.FizzBuzzService
import service.dto.FizzBuzzDto
import spark.Request
import spark.Response
import spark.Spark.get
import spark.Spark.post

class FizzBuzzResource(private val fizzBuzzService: FizzBuzzService) {

    init {
        get("/fizz") { request, response -> getFizz(request, response) }
        get("/buzz") { request, response -> getBuzz(request, response) }
        get("/fizzBuzz") { request, response -> getFizzBuzz(request, response) }
        post("/fizzBuzz") { request, response -> convertToFizzBuzz(request, response) }
    }

    fun getFizz(request: Request?, response: Response?): String? {
        val fizzBuzzResponse = fizzBuzzService.getFizz()
        response?.type("application/json")
        return Gson().toJson(fizzBuzzResponse)
    }

    fun getBuzz(request: Request?, response: Response?): String? {
        val fizzBuzzResponse = fizzBuzzService.getBuzz()
        response?.type("application/json")
        return Gson().toJson(fizzBuzzResponse)
    }

    fun getFizzBuzz(request: Request?, response: Response?): String? {
        val fizzBuzzResponse = fizzBuzzService.getFizzBuzz()
        response?.type("application/json")
        return Gson().toJson(fizzBuzzResponse)
    }

    fun convertToFizzBuzz(request: Request?, response: Response?): String {
        val fizzBuzzRequest = Gson().fromJson(request?.body(), FizzBuzzDto::class.java)
        val fizzBuzzResponse = fizzBuzzService.convertToFizzBuzz(fizzBuzzRequest)
        response?.type("application/json")
        return Gson().toJson(fizzBuzzResponse)
    }
}