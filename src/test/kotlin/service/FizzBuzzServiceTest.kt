package service

import com.google.common.truth.Truth.assertThat
import domain.FizzBuzzChainCreator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import service.dto.FizzBuzzDto

@ExtendWith(MockitoExtension::class)
internal class FizzBuzzServiceTest {
    private val FIZZ = "Fizz"
    private val BUZZ = "Buzz"
    private val FIZZ_BUZZ = "FizzBuzz"
    private val NUMBER = "2"

    @Mock
    private lateinit var fizzBuzzChainCreator: FizzBuzzChainCreator

    @InjectMocks
    private lateinit var fizzBuzzService: FizzBuzzService

    @Test
    fun whenGetFizz_thenReturnFizz() {
        val fizzBuzzDto = fizzBuzzService.getFizz()

        assertThat(fizzBuzzDto.fizzBuzz).isEqualTo(FIZZ)
    }

    @Test
    fun whenGetBuzz_thenReturnBuzz() {
        val fizzBuzzDto = fizzBuzzService.getBuzz()

        assertThat(fizzBuzzDto.fizzBuzz).isEqualTo(BUZZ)
    }

    @Test
    fun whenGetFizzBuzz_thenReturnFizzBuzz() {
        val fizzBuzzDto = fizzBuzzService.getFizzBuzz()

        assertThat(fizzBuzzDto.fizzBuzz).isEqualTo(FIZZ_BUZZ)
    }

    @Test
    fun whenConvertToFizzBuzz_thenReturnValidResult() {
        val fizzBuzzRequest = FizzBuzzDto(NUMBER)
        val fizzBuzzResponse = fizzBuzzService.convertToFizzBuzz(fizzBuzzRequest)

        assertThat(fizzBuzzResponse.fizzBuzz).isEqualTo(NUMBER)
    }
}