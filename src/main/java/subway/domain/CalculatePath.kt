package subway.domain

import org.jgrapht.alg.shortestpath.DijkstraShortestPath

class CalculatePath {

    fun getShortestTimePath(
        sourceVertex: String,
        targetVertex: String
    ): Pair<List<String?>, Double>? {
        val dijkstraShortestPath = DijkstraShortestPath(GraphRepository.getTimeGraph())
        val path = dijkstraShortestPath.getPath(sourceVertex, targetVertex) ?: return null
        return Pair(path.vertexList, path.weight)
    }

    fun getShortestDistancePath(
        sourceVertex: String,
        targetVertex: String
    ): Pair<List<String?>, Double>? {
        val dijkstraShortestPath = DijkstraShortestPath(GraphRepository.getDistanceGraph())
        val path = dijkstraShortestPath.getPath(sourceVertex, targetVertex) ?: return null
        return Pair(path.vertexList, path.weight)
    }

    fun getTimeWeight(vertexList: List<String?>): Double {
        var result = 0.0
        for (index in 0 until vertexList.size - 1)
            result += GraphRepository.getTimeGraph()
                .getEdgeWeight(GraphRepository.getTimeGraph().getEdge(vertexList[index], vertexList[index + 1]))
        return result
    }

    fun getDistanceWeight(vertexList: List<String?>): Double {
        var result = 0.0
        for (index in 0 until vertexList.size - 1)
            result += GraphRepository.getDistanceGraph()
                .getEdgeWeight(GraphRepository.getDistanceGraph().getEdge(vertexList[index], vertexList[index + 1]))
        return result
    }
}