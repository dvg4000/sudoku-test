class Solution private constructor(
    val table: Array<Int>
) {
    fun row(i: Int): Array<Int> {
        val offset = i * SIDE_SIZE
        return table.copyOfRange(offset, offset + SIDE_SIZE)
    }

    fun column(i: Int): Array<Int> {
        return (0 until SIDE_SIZE).map { table[it * SIDE_SIZE + i] }.toTypedArray()
    }

    fun box3x3(col: Int, row: Int): Array<Int> {
        val colOffset = col * BOX_SIDE_SIZE
        val rowOffset = row * BOX_SIDE_SIZE * SIDE_SIZE
        return (0 until BOX_SIDE_SIZE)
            .map { r -> (0 until BOX_SIDE_SIZE).map { c -> table[c + colOffset + r * SIDE_SIZE + rowOffset] } }
            .flatten()
            .toTypedArray()
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
                else -> Result.success(Solution(table.toTypedArray()))
            }
        }
    }
}