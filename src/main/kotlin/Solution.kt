class Solution private constructor(
    val table: List<Int>
) {
    fun row(i: Int): List<Int> {
        val offset = i * SIDE_SIZE
        return table.subList(offset, offset + SIDE_SIZE)
    }

    fun column(i: Int): List<Int> {
        return (0 until SIDE_SIZE).map { table[it * SIDE_SIZE + i] }
    }

    fun box3x3(col: Int, row: Int): List<Int> {
        val range = 0 until BOX_SIDE_SIZE
        //if (col !in range) throw ArrayIndexOutOfBoundsException("`col` out of bounds")
        //if (row !in range) throw ArrayIndexOutOfBoundsException("`row` out of bounds")

        val colOffset = col * BOX_SIDE_SIZE
        val rowOffset = row * BOX_SIDE_SIZE * SIDE_SIZE
        return range
            .map { r -> range.map { c -> table[c + colOffset + r * SIDE_SIZE + rowOffset] } }
            .flatten()
    }

    companion object {
        private const val TABLE_SIZE = 81
        const val SIDE_SIZE = 9
        const val BOX_SIDE_SIZE = 3

        fun create(table: Collection<Int>): Result<Solution> {
            val valueRange = IntRange(1, 9)
            return when {
                table.size != TABLE_SIZE -> Result.failure(IllegalStateException("Invalid table size"))
                table.any { it !in valueRange } -> Result.failure(IllegalStateException("Table has invalid value"))
                else -> Result.success(Solution(table.toList()))
            }
        }
    }
}