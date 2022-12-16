package subway.view

import subway.constants.OPTION_INPUT_MENT
import subway.constants.MAIN_MENU
import subway.constants.PATH_STANDARD_MENU

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
}