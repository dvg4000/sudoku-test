import java.io.File

class SolutionParser {
    fun parseFile(fileName: String): Result<Solution> =
        parse(File(fileName).useLines { it.toList().joinToString("") })

    fun parse(solution: String): Result<Solution> {
        return solution.replace("\\s+".toRegex(), "").map { it.digitToInt() }
            .let { Solution.create(it) }
    }
}