package subway.view

import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readMenuOption(): String {
        return scanner.nextLine()
    }
}