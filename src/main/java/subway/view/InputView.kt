package subway.view

import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readOption(): String {
        return scanner.nextLine()
    }
}