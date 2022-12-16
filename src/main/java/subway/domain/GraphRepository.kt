package subway.domain

import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.WeightedMultigraph

object GraphRepository {
    private val timeGraph: WeightedMultigraph<String?, DefaultWeightedEdge?> = WeightedMultigraph(
        DefaultWeightedEdge::class.java
    )
    private val distanceGraph: WeightedMultigraph<String?, DefaultWeightedEdge?> = WeightedMultigraph(
        DefaultWeightedEdge::class.java
    )

    init {
        StationRepository.stations().forEach {
            timeGraph.addVertex(it.name)
            distanceGraph.addVertex(it.name)
        }
        setTimeGraphEdge()
        setDistanceGraphEdge()
    }

    fun getTimeGraph(): WeightedMultigraph<String?, DefaultWeightedEdge?> {
        return timeGraph
    }

    fun getDistanceGraph(): WeightedMultigraph<String?, DefaultWeightedEdge?> {
        return distanceGraph
    }

    private fun setTimeGraphEdge() {
        LineRepository.lines().forEach { line ->
            setGraphEdge(line.getStations(), timeGraph, 2)
        }
    }

    private fun setDistanceGraphEdge() {
        LineRepository.lines().forEach { line ->
            setGraphEdge(line.getStations(), distanceGraph, 1)
        }
    }

    private fun setGraphEdge(
        stations: List<List<Any>>,
        graph: WeightedMultigraph<String?, DefaultWeightedEdge?>,
        weightIndex: Int
    ) {
        for ((index, value) in stations.withIndex()) {
            if (value[weightIndex] != 0) {
                val station = value[0] as Station
                val nextStation = stations[index + 1][0] as Station
                val weight = value[weightIndex] as Int
                graph.setEdgeWeight(
                    graph.addEdge(station.name, nextStation.name),
                    weight.toDouble()
                )
            }
        }
    }
}