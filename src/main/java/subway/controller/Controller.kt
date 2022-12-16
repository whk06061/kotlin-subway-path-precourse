package subway.controller

import subway.constants.ERROR_SAME_STATION
import subway.domain.*
import subway.exception.Validator
import subway.view.InputView
import subway.view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val calculatePath = CalculatePath()

    init {
        val init = Init()
        init.initStation()
        init.initLine()
        init.initStationToLine(StationRepository.stations(), LineRepository.lines())
//        init.initLineToStation(stations, lines)
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
        val (starting, destination) = readStation() ?: run {
            outputView.printErrorMessage(ERROR_SAME_STATION)
            return
        }
        val pathResult = calculatePath.getShortestDistancePath(starting, destination)
        val vertexs = pathResult.first
        val distanceWeight = pathResult.second
        val timeWeight = calculatePath.getTimeWeight(vertexs)
        outputView.printResult(distanceWeight, timeWeight, vertexs)
    }

    private fun viewShortestTime() {
        val (starting, destination) = readStation() ?: run {
            outputView.printErrorMessage(ERROR_SAME_STATION)
            return
        }
        val pathResult = calculatePath.getShortestTimePath(starting, destination)
        val vertexs = pathResult.first
        val timeWeight = pathResult.second
        val distanceWeight = calculatePath.getDistanceWeight(vertexs)
        outputView.printResult(distanceWeight, timeWeight, vertexs)
    }

    private fun readStation(): List<String>? {
        val validator = Validator()
        val result = mutableListOf<String>()
        outputView.printStartingInputMent()
        result.add(inputView.readOption())
        outputView.printDestinationInputMent()
        result.add(inputView.readOption())
        return validator.checkStation(result)
    }
}