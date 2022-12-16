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

    fun printDeptStationInputMent() {
        println()
        println(DEPT_STATION_INPUT_MENT)
    }

    fun printArrivalStationInputMent() {
        println()
        println(ARRIVAL_STATION_INPUT_MENT)
    }

    fun printErrorMessage(message:String){
        println()
        println(message)
        println()
    }
}