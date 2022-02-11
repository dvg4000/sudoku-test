fun checkSolution(fileName: String) {
    SolutionParser().parseFile(fileName)
        .map { SolutionChecker().isValid(it) }
        .fold(
            { println(if (it) "Correct" else "Incorrect") },
            { println("Error: ${it.message}") }
        )
}

fun printErrorAndUsage(e: Exception) {
    println(
        """
            Error: ${e.message}   
            
            Usage: 
            
            cat << EOF > solution.txt
            215396478
            679841352
            384275169
            126987543
            847653921
            953124786
            532769814
            461538297
            798412635
            EOF
            
            java -jar sudoku-test.jar solution.txt
        """.trimIndent()
    )
}

fun main(args: Array<String>) {
    try {
        checkSolution(args[0])
    } catch (e: Exception) {
        printErrorAndUsage(e)
    }
}