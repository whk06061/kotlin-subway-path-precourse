package subway.domain

class Line(val name: String) {

    private val stations: MutableList<Station> = mutableListOf()

    fun addStation(station: Station) {
        stations.add(station)
    }
}