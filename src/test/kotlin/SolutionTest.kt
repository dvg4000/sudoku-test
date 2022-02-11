import org.junit.Test
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun test() {
        val solution = listOf(
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
        // rows
        assertTrue(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9,).contentEquals(solution.row(0))
        )
        assertTrue(
            arrayOf(4, 2, 3, 5, 5, 5, 7, 8, 9,).contentEquals(solution.row(3))
        )
        assertTrue(
            arrayOf(7, 7, 7, 4, 5, 6, 9, 9, 9,).contentEquals(solution.row(8))
        )
        // cols
        assertTrue(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 7, 7,).contentEquals(solution.column(0))
        )
        assertTrue(
            arrayOf(4, 4, 4, 5, 5, 5, 4, 4, 4,).contentEquals(solution.column(3))
        )
        assertTrue(
            arrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9,).contentEquals(solution.column(8))
        )
        // boxes
        assertTrue(
            arrayOf(1, 2, 3, 2, 2, 3, 3, 2, 3,).contentEquals(solution.box3x3(0, 0))
        )
        assertTrue(
            arrayOf(7, 8, 9, 7, 8, 9, 7, 8, 9,).contentEquals(solution.box3x3(2, 0))
        )
        assertTrue(
            arrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5,).contentEquals(solution.box3x3(1, 1))
        )
        assertTrue(
            arrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9,).contentEquals(solution.box3x3(2, 2))
        )
    }
}