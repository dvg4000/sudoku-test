import model.Solution
import org.junit.Assert
import org.junit.Test
import usecase.SolutionChecker
import usecase.SolutionCheckerImpl
import kotlin.test.assertTrue

class SolutionCheckerTest {
    @Test
    fun simpleTest() {
        val table = arrayOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            2, 2, 3, 4, 5, 6, 7, 8, 9,
            3, 2, 3, 4, 5, 6, 7, 8, 9,
            4, 2, 3, 4, 5, 6, 7, 8, 9,
            5, 2, 3, 4, 5, 6, 7, 8, 9,
            6, 2, 3, 4, 5, 6, 7, 8, 9,
            7, 2, 3, 4, 5, 6, 7, 8, 9,
            8, 2, 3, 4, 5, 6, 7, 8, 9,
            9, 2, 3, 4, 5, 6, 7, 8, 9,
        )
        val checker: SolutionChecker = SolutionCheckerImpl()
        val result = Solution.create(table).mapCatching { checker.isValid(it) }
        assertTrue(result.isFailure)
    }
}