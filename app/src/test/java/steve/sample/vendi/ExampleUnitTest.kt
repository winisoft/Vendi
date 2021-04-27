package steve.sample.vendi

import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Nested
    @DisplayName("Given the need to confirm the legitimacy of the currency inserted")
    inner class G {

        @Nested
        @DisplayName("When a coin is inserted and gets accepted into the received coins")
        inner class W {

            @Test
            @DisplayName("Then it could possibly match the weight, circumference, and thickness of a nickel")
            fun test_validValuesForNickel_insertedIntoCoinAcceptor_isAcceptedByTheControlUnit() {


            }
        }

    }



    @Test
    fun addition_isCorrect() {

    }
}