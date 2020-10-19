package domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FizzTest {
    private val VALID_DIVISOR = 30
    private val INVALID_DIVISOR = 4
    private val NAME = "Fizz"

    lateinit var fizz: Fizz

    @BeforeEach
    fun setup() {
        fizz = Fizz()
    }

    @Test
    fun givenValidDivisor_whenHandle_thenReturnName() {
        val result = fizz.handle(VALID_DIVISOR)

        assertThat(result).isEqualTo(NAME)
    }

    @Test
    fun givenInvalidDivisor_whenHandle_thenReturnDivisor() {
        val result = fizz.handle(INVALID_DIVISOR)

        assertThat(result).isEqualTo(INVALID_DIVISOR.toString())
    }
}