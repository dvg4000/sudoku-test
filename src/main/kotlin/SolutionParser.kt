import java.io.File
import java.util.*

class SolutionParser {
    fun parseFile(fileName: String): Result<Solution> =
        parse(
            File(fileName).useLines {
                it.take(Solution.SIDE_SIZE).toList().joinToString(separator = "")
            }
        )


    fun parse(solution: String): Result<Solution> {
        return solution.replace("\\s+".toRegex(), "").map { it.digitToInt() }
            .let { Solution.create(it) }
    }
}