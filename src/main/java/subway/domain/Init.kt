package subway.domain

class Init {

    private val stationNames = listOf("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")

    private val lineNames = listOf("2호선", "3호선", "신분당선")

    fun initStation() {
        stationNames.forEach {
            val station = Station(it)
            StationRepository.addStation(station)
        }
    }

    fun initLine() {
        lineNames.forEach {
            val line = Line(it)
            LineRepository.addLine(line)
        }
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
        lines[2].addStation(stations[5], 0, 0)
//        lines[0].addStation(stations[0])
//        lines[0].addStation(stations[1])
//        lines[0].addStation(stations[2])
//
//        lines[1].addStation(stations[0])
//        lines[1].addStation(stations[3])
//        lines[1].addStation(stations[4])
//        lines[1].addStation(stations[6])
//
//        lines[2].addStation(stations[1])
//        lines[2].addStation(stations[4])
//        lines[2].addStation(stations[5])
    }

//    fun initTimeGraph() {
//        GraphRepository.setTimeGraphEdge(stationNames[0], stationNames[1], 3.0)
//        GraphRepository.setTimeGraphEdge(stationNames[1], stationNames[2], 3.0)
//
//        GraphRepository.setTimeGraphEdge(stationNames[0], stationNames[3], 2.0)
//        GraphRepository.setTimeGraphEdge(stationNames[3], stationNames[4], 5.0)
//        GraphRepository.setTimeGraphEdge(stationNames[4], stationNames[6], 1.0)
//
//        GraphRepository.setTimeGraphEdge(stationNames[1], stationNames[4], 8.0)
//        GraphRepository.setTimeGraphEdge(stationNames[4], stationNames[5], 3.0)
//    }

//    fun initLineToStation(stations: List<Station>, lines: List<Line>) {
//
//        stations[0].addLine(lines[0])
//        stations[0].addLine(lines[1])
//
//        stations[1].addLine(lines[0])
//        stations[1].addLine(lines[2])
//
//        stations[2].addLine(lines[0])
//
//        stations[3].addLine(lines[1])
//
//        stations[4].addLine(lines[1])
//        stations[4].addLine(lines[2])
//
//        stations[5].addLine(lines[2])
//
//        stations[6].addLine(lines[1])
//    }
}