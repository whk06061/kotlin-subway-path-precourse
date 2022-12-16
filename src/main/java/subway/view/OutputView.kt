package subway.view

import subway.constants.*

class OutputView {
    fun printMainMenu() {
        println(MAIN_MENU)
    }

    fun printOptionInputMent() {
        println()
        println(OPTION_INPUT_MENT)
    }

    fun printPathStandardInputMent() {
        println()
        println(PATH_STANDARD_MENU)
    }

    fun printStartingInputMent() {
        println()
        println(STARTING_INPUT_MENT)
    }

    fun printDestinationInputMent() {
        println()
        println(DESTINATION_INPUT_MENT)
    }

    fun printErrorMessage(message: String) {
        println()
        println(message)
        println()
    }

    fun printResult(distanceWeight: Double, timeWeight: Double, stations: List<String?>) {
        println(RESULT_MENT)
        println(DIVISION)
        println(PRINT_PATH_DISTANCE.format(distanceWeight.toInt()))
        println(PRINT_PATH_TIME.format(timeWeight.toInt()))
        println(DIVISION)
        stations.forEach { println(PRINT_PATH_STATION.format(it)) }
        println()
    }
}