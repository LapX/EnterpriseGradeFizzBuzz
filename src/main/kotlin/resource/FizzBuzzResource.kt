package resource

import service.FizzBuzzService
import spark.Request
import spark.Response
import spark.Spark.get
import spark.Spark.post

class FizzBuzzResource(private val fizzBuzzService: FizzBuzzService) {

    init {
        get("/fizz") { request, response -> getFizz(request, response) }
        post("/fizzBuzz") { request, response -> convertToFizzBuzz(request, response) }
    }

    private fun convertToFizzBuzz(request: Request?, response: Response?): String {
        return fizzBuzzService.convertToFizzBuzz()
    }

    private fun getFizz(request: Request?, response: Response?): String {
        return fizzBuzzService.getFizz()
    }
}