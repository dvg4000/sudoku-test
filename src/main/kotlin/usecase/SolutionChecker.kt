package usecase

import model.Solution
import model.Solution.Companion.BOX_SIDE_SIZE
import model.Solution.Companion.SIDE_SIZE

class SolutionChecker {
    fun isValid(solution: Solution): Boolean {
        for (r in 0 until BOX_SIDE_SIZE)
            for (c in 0 until BOX_SIDE_SIZE) {
                val boxHasDuplicate = solution.box3x3(c, r).toSet().size != SIDE_SIZE
                if (boxHasDuplicate) return false
            }
        for (c in 0 until SIDE_SIZE) {
            val columnHasDuplicate = solution.column(c).toSet().size != SIDE_SIZE
            if (columnHasDuplicate) return false
        }
        for (r in 0 until SIDE_SIZE) {
            val rowHasDuplicate = solution.row(r).toSet().size != SIDE_SIZE
            if (rowHasDuplicate) return false
        }
        return true
    }
}