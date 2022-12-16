package subway.constants

// 공통
const val MENT_PREFIX = "##"
const val OPTION_INPUT_MENT = "$MENT_PREFIX 원하는 기능을 선택하세요."


// 메인 화면 문구
const val MAIN_MENU = "$MENT_PREFIX 메인 화면\n1. 경로 조회\nQ. 종료"


// 경로 기준 선택 문구
const val PATH_STANDARD_MENU = "$MENT_PREFIX 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기"


// 역 입력 문구
const val STARTING_INPUT_MENT = "$MENT_PREFIX 출발역을 입력하세요."
const val DESTINATION_INPUT_MENT = "$MENT_PREFIX 도착역을 입력하세요."


// 에러 문구
const val ERROR_PREFIX = "[ERROR]"
const val ERROR_SAME_STATION = "$ERROR_PREFIX 출발역과 도착역이 동일합니다."
const val ERROR_NOT_CONNECT = "$ERROR_PREFIX 출발역과 도착역이 연결되어 있지 않습니다."


// 결과 출력
const val RESULT_PREFIX = "[INFO]"
const val RESULT_MENT = "$MENT_PREFIX 조회 결과"
const val DIVISION = "$RESULT_PREFIX ---"
const val PRINT_PATH_DISTANCE = "$RESULT_PREFIX 총 거리: %dkm"
const val PRINT_PATH_TIME = "$RESULT_PREFIX 총 소요 시간: %d분"
const val PRINT_PATH_STATION = "$RESULT_PREFIX %s"