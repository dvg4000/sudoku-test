import model.Solution
import usecase.SolutionChecker
import usecase.SolutionCheckerImpl

fun main(args: Array<String>) {
    val checker: SolutionChecker = SolutionCheckerImpl()
    arrayOf( //@formatter:off
        2, 1, 5,  3, 9, 6,  4, 7, 8,
        6, 7, 9,  8, 4, 1,  3, 5, 2,
        3, 8, 4,  2, 7, 5,  1, 6, 9,

        1, 2, 6,  9, 8, 7,  5, 4, 3,
        8, 4, 7,  6, 5, 3,  9, 2, 1,
        9, 5, 3,  1, 2, 4,  7, 8, 6,

        5, 3, 2,  7, 6, 9,  8, 1, 4,
        4, 6, 1,  5, 3, 8,  2, 9, 7,
        7, 9, 8,  4, 1, 2,  6, 3, 5,
    ) // @formatter:on
        .let { Solution.create(it)  }
        .mapCatching { checker.isValid(it) }
        .fold(
            { if (it) println("Correct") else ("Incorrect") },
            { e -> println("Error: $e") }
        )
}