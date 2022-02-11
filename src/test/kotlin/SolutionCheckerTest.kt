import model.Solution
import org.junit.Test
import usecase.SolutionChecker
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SolutionCheckerTest {
    private val checker = SolutionChecker()

    @Test
    fun testNotValid() {
        val solution = arrayOf(
            1, 2, 3,  4, 5, 6,  7, 8, 9,
            2, 2, 3,  4, 5, 6,  7, 8, 9,
            3, 2, 3,  4, 5, 6,  7, 8, 9,

            4, 2, 3,  5, 5, 5,  7, 8, 9,
            5, 2, 3,  5, 5, 5,  7, 8, 9,
            6, 2, 3,  5, 5, 5,  7, 8, 9,

            7, 7, 7,  4, 5, 6,  9, 9, 9,
            7, 7, 7,  4, 5, 6,  9, 9, 9,
            7, 7, 7,  4, 5, 6,  9, 9, 9,
        ).let { Solution.create(it) }.getOrThrow()
        assertFalse(checker.isValid(solution))
    }

    @Test
    fun testValid() {
        val solution = arrayOf(
            2, 1, 5,  3, 9, 6,  4, 7, 8,
            6, 7, 9,  8, 4, 1,  3, 5, 2,
            3, 8, 4,  2, 7, 5,  1, 6, 9,

            1, 2, 6,  9, 8, 7,  5, 4, 3,
            8, 4, 7,  6, 5, 3,  9, 2, 1,
            9, 5, 3,  1, 2, 4,  7, 8, 6,

            5, 3, 2,  7, 6, 9,  8, 1, 4,
            4, 6, 1,  5, 3, 8,  2, 9, 7,
            7, 9, 8,  4, 1, 2,  6, 3, 5,
        ).let { Solution.create(it) }.getOrThrow()
        assertTrue(checker.isValid(solution))
    }
}