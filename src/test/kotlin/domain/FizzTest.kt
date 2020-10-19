package domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FizzTest {
    private val VALID_DIVISOR = 30
    private val INVALID_DIVISOR = 4
    private val NAME = "Fizz"

    lateinit var fizz: Fizz

    @Mock
    private lateinit var divisionHandler: DivisorHandler

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

    @Test
    fun givenInvalidDivisor_whenHandle_thenNextHandlerIsCalled() {
        fizz.setNext(divisionHandler)

        fizz.handle(INVALID_DIVISOR)

        Mockito.verify(divisionHandler).handle(INVALID_DIVISOR)
    }
}