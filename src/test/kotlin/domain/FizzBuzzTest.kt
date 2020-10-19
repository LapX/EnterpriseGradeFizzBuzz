package domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FizzBuzzTest {
    private val VALID_DIVISOR = 30
    private val INVALID_DIVISOR = 4
    private val NAME = "FizzBuzz"

    lateinit var fizzBuzz: FizzBuzz

    @Mock
    private lateinit var divisionHandler: DivisorHandler

    @BeforeEach
    fun setup() {
        fizzBuzz = FizzBuzz()
    }

    @Test
    fun givenValidDivisor_whenHandle_thenReturnName() {
        val result = fizzBuzz.handle(VALID_DIVISOR)

        assertThat(result).isEqualTo(NAME)
    }

    @Test
    fun givenInvalidDivisor_whenHandle_thenReturnDivisor() {
        val result = fizzBuzz.handle(INVALID_DIVISOR)

        assertThat(result).isEqualTo(INVALID_DIVISOR.toString())
    }


    @Test
    fun givenInvalidDivisor_whenHandle_thenNextHandlerIsCalled() {
        fizzBuzz.setNext(divisionHandler)

        fizzBuzz.handle(INVALID_DIVISOR)

        Mockito.verify(divisionHandler).handle(INVALID_DIVISOR)
    }
}