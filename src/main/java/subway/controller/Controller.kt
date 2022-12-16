package subway.controller

import subway.domain.Init
import subway.view.InputView
import subway.view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    init {
        val init = Init()
        init.initStationToLine(init.initStation(), init.initLine())
    }

    fun operate() {
        while (true) {
            val option = readMainMenuOption()
            if (option == "1") ViewPath()
            if (option == "Q") return
        }
    }

    private fun readMainMenuOption(): String {
        outputView.printMainMenu()
        outputView.printMenuOptionInputMent()
        return inputView.readMenuOption()
    }

    private fun ViewPath() {
    }
}