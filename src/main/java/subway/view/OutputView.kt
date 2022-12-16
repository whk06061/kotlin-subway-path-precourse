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

    fun printErrorMessage(message:String){
        println()
        println(message)
        println()
    }
}