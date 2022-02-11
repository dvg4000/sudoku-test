import org.junit.Test
import kotlin.test.assertEquals

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
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9,), solution.row(0))
        assertEquals(listOf(4, 2, 3, 5, 5, 5, 7, 8, 9,), solution.row(3))
        assertEquals(listOf(7, 7, 7, 4, 5, 6, 9, 9, 9,), solution.row(8))
        // cols
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 7, 7,), solution.column(0))
        assertEquals(listOf(4, 4, 4, 5, 5, 5, 4, 4, 4,), solution.column(3))
        assertEquals(listOf(9, 9, 9, 9, 9, 9, 9, 9, 9,), solution.column(8))
        // boxes
        assertEquals(listOf(1, 2, 3, 2, 2, 3, 3, 2, 3,), solution.box3x3(0, 0))
        assertEquals(listOf(7, 8, 9, 7, 8, 9, 7, 8, 9,), solution.box3x3(2, 0))
        assertEquals(listOf(5, 5, 5, 5, 5, 5, 5, 5, 5,), solution.box3x3(1, 1))
        assertEquals(listOf(9, 9, 9, 9, 9, 9, 9, 9, 9,), solution.box3x3(2, 2))
    }
}