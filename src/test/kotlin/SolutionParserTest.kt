import org.junit.Test
import kotlin.test.assertTrue

class SolutionParserTest {
    @Test
    fun test() {
        SolutionParser().parseFile("src/test/resources/solution_valid.txt")
            .also { assertTrue(it.isSuccess) }
        SolutionParser().parseFile("src/test/resources/solution_valid_1.txt")
            .also { assertTrue(it.isSuccess) }
    }
}