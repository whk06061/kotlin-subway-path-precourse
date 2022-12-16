package subway.controller

import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.WeightedMultigraph
import subway.constants.ERROR_SAME_STATION
import subway.domain.Init
import subway.exception.Validator
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
        return inputView.readOption()
    }

    private fun viewPath() {
        outputView.printPathStandardInputMent()
        outputView.printOptionInputMent()
        val option = inputView.readOption()
        if (option == "1") viewShortestDistance()
        if (option == "2") viewShortestTime()
        if (option == "B") return
    }

    private fun viewShortestDistance() {
        val (destStation, arrivalStation) = readStation() ?: run {
            outputView.printErrorMessage(ERROR_SAME_STATION)
            return
        }
    }

    private fun viewShortestTime() {
        val (destStation, arrivalStation) = readStation() ?: run {
            outputView.printErrorMessage(ERROR_SAME_STATION)
            return
        }
    }

    private fun readStation(): List<String>? {
        val validator = Validator()
        val result = mutableListOf<String>()
        outputView.printDeptStationInputMent()
        result.add(inputView.readOption())
        outputView.printArrivalStationInputMent()
        result.add(inputView.readOption())
        return validator.checkStation(result)
    }
}