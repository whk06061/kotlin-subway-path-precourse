package subway.domain

import org.jgrapht.alg.shortestpath.DijkstraShortestPath
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

    private fun setTimeGraphEdge() {
        LineRepository.lines().forEach { line ->
            val stations = line.getStations()
            for ((index, value) in stations.withIndex()) {
                if (value[2] != 0) {
                    val station = value[0] as Station
                    val nextStation = stations[index + 1][0] as Station
                    val weight = value[2] as Int
                    timeGraph.setEdgeWeight(timeGraph.addEdge(station.name, nextStation.name), weight.toDouble())
                }
            }
        }
    }

    private fun setDistanceGraphEdge() {
        LineRepository.lines().forEach { line ->
            val stations = line.getStations()
            for ((index, value) in stations.withIndex()) {
                if (value[1] != 0) {
                    val station = value[0] as Station
                    val nextStation = stations[index + 1][0] as Station
                    val weight = value[1] as Int
                    distanceGraph.setEdgeWeight(
                        distanceGraph.addEdge(station.name, nextStation.name),
                        weight.toDouble()
                    )
                }
            }
        }
    }

    fun getShortestTimePath(
        sourceVertex: String,
        targetVertex: String
    ): Pair<List<String?>, Double> {
        val dijkstraShortestPath = DijkstraShortestPath(timeGraph)
        val path = dijkstraShortestPath.getPath(sourceVertex, targetVertex)
        return Pair(path.vertexList, path.weight)
    }

    fun getShortestDistancePath(
        sourceVertex: String,
        targetVertex: String
    ): Pair<List<String?>, Double> {
        val dijkstraShortestPath = DijkstraShortestPath(distanceGraph)
        val path = dijkstraShortestPath.getPath(sourceVertex, targetVertex)
        return Pair(path.vertexList, path.weight)
    }
}