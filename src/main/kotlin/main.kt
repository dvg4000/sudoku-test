fun main(args: Array<String>) {
    try {
        SolutionParser().parseFile(args[0])
            .map { SolutionChecker().isValid(it) }
            .fold(
                { isValid -> if (isValid) println("Correct") else ("Incorrect") },
                { e -> println("Error: $e") }
            )
    } catch (e: Exception) {
        println("Error: ${e.message}")
        println("""

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
            
            java -jar sudoku_test.jar solution.txt
        """.trimIndent())
    }
}