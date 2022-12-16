package subway.controller

import subway.domain.Init

class Controller {
    init {
        val init = Init()
        init.initStationToLine(init.initStation(), init.initLine())
    }
}