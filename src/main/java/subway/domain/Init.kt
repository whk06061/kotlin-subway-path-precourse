package subway.domain

class Init {

    fun initStation(): List<Station> {
        val stations = mutableListOf<Station>()
        stations.add(Station("교대역"))
        stations.add(Station("강남역"))
        stations.add(Station("역삼역"))
        stations.add(Station("남부터미널역"))
        stations.add(Station("양재역"))
        stations.add(Station("양재시민의숲역"))
        stations.add(Station("매봉역"))
        stations.forEach { StationRepository.addStation(it) }
        return stations
    }

    fun initLine(): List<Line> {
        val lines = mutableListOf<Line>()
        lines.add(Line("2호선"))
        lines.add(Line("3호선"))
        lines.add(Line("신분당선"))
        lines.forEach { LineRepository.addLine(it) }
        return lines
    }

    fun initStationToLine(stations: List<Station>, lines: List<Line>) {

        lines[0].addStation(stations[0], 2, 3)
        lines[0].addStation(stations[1], 2, 3)
        lines[0].addStation(stations[2], 0, 0)

        lines[1].addStation(stations[0], 3, 2)
        lines[1].addStation(stations[3], 6, 5)
        lines[1].addStation(stations[4], 1, 1)
        lines[1].addStation(stations[6], 0, 0)

        lines[2].addStation(stations[1], 2, 8)
        lines[2].addStation(stations[4], 10, 3)
        lines[2].addStation(stations[5],0, 0)
    }
}