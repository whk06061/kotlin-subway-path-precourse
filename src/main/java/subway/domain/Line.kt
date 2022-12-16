package subway.domain

class Line(val name: String) {

    private val stations: MutableList<MutableList<Any>> = mutableListOf()
//    private val stations: MutableList<Station> = mutableListOf()


    fun addStation(station: Station, nextStationDistance: Int, nextStationTime: Int) {
        stations.add(mutableListOf(station, nextStationDistance, nextStationTime))
    }

    fun getStations(): List<List<Any>> {
        return stations
    }

//    fun addStation(station: Station) {
//        stations.add(station)
//    }
}