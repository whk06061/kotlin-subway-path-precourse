package subway.domain

class Line(val name: String) {

    private val stations: MutableMap<Station, Pair<Int, Int>> = mutableMapOf()

    fun addStation(station: Station, nextStationDistance: Int, nextStationTime: Int) {
        stations[station] = Pair(nextStationDistance, nextStationTime)
    }
}