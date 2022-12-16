package subway.domain

class Path {

    fun shortestDistanceCalculator(starting: String, destination: String) {
        val startingStation = StationRepository.stations().find { it.name == starting }
        val destinationStation = StationRepository.stations().find { it.name == destination }

    }

    fun shortestTimeCalculator(starting: String, destination: String) {

    }
}