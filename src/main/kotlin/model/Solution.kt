package model

class Solution private constructor(
    val table: Array<Int>
) {

    companion object {
        private const val TABLE_SIZE = 81
        private const val SIDE_SIZE = 9

        private val VALUE_RANGE = IntRange(1, 9)

        @JvmStatic
        fun create(table: Array<Int>): Result<Solution> =
            when {
                table.size != TABLE_SIZE -> Result.failure(IllegalStateException("Invalid table size"))
                table.any { it !in VALUE_RANGE } -> Result.failure(IllegalStateException("Table has invalid value"))
                else -> Result.success(Solution(table))
            }
    }
}