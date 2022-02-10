package usecase

import model.Solution

interface SolutionChecker {
    fun isValid(solution: Solution): Boolean
}