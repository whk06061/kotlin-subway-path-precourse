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
            if (option == "1") viewPath()
            if (option == "Q") return
        }
    }

    private fun readMainMenuOption(): String {
        outputView.printMainMenu()
        outputView.printOptionInputMent()
        return inputView.readMenuOption()
    }

    private fun viewPath() {
        outputView.printPathStandardInputMent()
        outputView.printOptionInputMent()
        val option = inputView.readMenuOption()
        if (option == "1") viewShortestDistance()
        if (option == "2") viewShortestTime()
        if (option == "B") return
    }

    private fun viewShortestDistance() {
        println("최단 거리 들어옴")
    }

    private fun viewShortestTime() {
        println("최소 시간 들어옴")
    }
}