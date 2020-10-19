package domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BuzzTest {
    private val VALID_DIVISOR = 30
    private val INVALID_DIVISOR = 6
    private val NAME = "Buzz"

    lateinit var buzz: Buzz

    @BeforeEach
    fun setup() {
        buzz = Buzz()
    }

    @Test
    fun givenValidDivisor_whenHandle_thenReturnName() {
        val result = buzz.handle(VALID_DIVISOR)

        assertThat(result).isEqualTo(NAME)
    }

    @Test
    fun givenInvalidDivisor_whenHandle_thenReturnDivisor() {
        val result = buzz.handle(INVALID_DIVISOR)

        assertThat(result).isEqualTo(INVALID_DIVISOR.toString())
    }
}