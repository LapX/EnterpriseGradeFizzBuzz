package resource

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import service.FizzBuzzService
import spark.Request
import spark.Response

@ExtendWith(MockitoExtension::class)
internal class FizzBuzzResourceTest {
    private val FIZZ_JSON = "{\"fizzBuzz\":\"Fizz\"}"
    private val BUZZ_JSON = "{\"fizzBuzz\":\"Buzz\"}"
    private val FIZZ_BUZZ_JSON = "{\"fizzBuzz\":\"FizzBuzz\"}"
    private val NUMBER_JSON = "{\"fizzBuzz\":\"2\"}"

    @Mock
    lateinit var fizzBuzzService: FizzBuzzService

    @Mock
    lateinit var request: Request

    @Mock
    lateinit var response: Response

    @InjectMocks
    lateinit var fizzBuzzResource: FizzBuzzResource

    @Test
    fun whenGetFizz_thenReturnIsValid() {
        val fizz = fizzBuzzResource.getFizz(request, response)

        assertThat(fizz).isEqualTo(FIZZ_JSON)
    }

    @Test
    fun whenGetBuzz_thenReturnIsValid() {
        val buzz = fizzBuzzResource.getBuzz(request, response)

        assertThat(buzz).isEqualTo(BUZZ_JSON)
    }

    @Test
    fun whenGetFizzBuzz_thenReturnIsValid() {
        val fizzBuzz = fizzBuzzResource.getFizzBuzz(request, response)

        assertThat(fizzBuzz).isEqualTo(FIZZ_BUZZ_JSON)
    }

    @Test
    fun whenConvertToFizzBuzz_thenReturnIsValid() {
        Mockito.`when`(request.body()).thenReturn(NUMBER_JSON)
        val fizzBuzz = fizzBuzzResource.convertToFizzBuzz(request, response)

        assertThat(fizzBuzz).isEqualTo(NUMBER_JSON)
    }


}