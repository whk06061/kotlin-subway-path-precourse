package subway.exception

class Validator {

    fun checkStation(stations:List<String>):List<String>?{
        if (stations[0] == stations[1]) return null
        return stations
    }
}