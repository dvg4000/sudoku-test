import org.junit.Test
import kotlin.test.assertTrue

class SolutionParserTest {
    @Test
    fun test() {
        val solution = SolutionParser().parseFile("src/test/resources/solution_valid.txt")
        assertTrue(solution.isSuccess)
    }
}