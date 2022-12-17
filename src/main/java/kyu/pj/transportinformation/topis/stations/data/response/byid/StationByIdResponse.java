package kyu.pj.transportinformation.topis.stations.data.response.byid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/stationinfo
 * (EX : http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid?arsId=xxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * arsId	string (필수)	정류소 번호
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       stId	string	정류소 고유 ID
 *       stNm	string	정류소명
 *       arsId	string	정류소 번호
 *       busRouteAbrv	string	노선명 (안내용 - 마을버스 제외)
 *       busRouteId	string	노선ID
 *       rtNm	string	노선명 (DB관리용)
 *       gpsX	string	정류소 좌표X (WGS84)
 *       gpsY	string	정류소 좌표Y (WGS84)
 *       stationTp	string	정류소타입 (0:공용, 1:일반형 시내/농어촌버스, 2:좌석형 시내/농어촌버스, 3:직행좌석형 시내/농어촌버스, 4:일반형 시외버스, 5:좌석형 시외버스, 6:고속형 시외버스, 7:마을버스)
 *       firstTm	string	첫차시간
 *       lastTm	string	막차시간
 *       term	string	배차간격 (분)
 *       routeType	string	노선유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
 *       nextBus	string	막차운행여부 (N:막차아님, Y:막차)
 *       staOrd	string	요청정류소순번
 *       vehId1	string	첫번째도착예정버스ID
 *       plainNo1	string	첫번째도착예정차량번호
 *       sectOrd1	string	첫번째도착예정버스의 현재구간 순번
 *       stationNm1	string	첫번째도착예정버스의 최종 정류소명
 *       traTime1	string	첫번째도착예정버스의 여행시간
 *       traSpd1	string	첫번째도착예정버스의 여행속도 (Km/h)
 *       isArrive1	string	첫번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
 *       isLast1	string	첫번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
 *       busType1	string	첫번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       vehId2	string	두번째도착예정버스ID
 *       plainNo2	string	두번째도착예정차량번호
 *       sectOrd2	string	두번째도착예정버스의 현재구간 순번
 *       stationNm2	string	두번째도착예정버스의 최종 정류소명
 *       traTime2	string	두번째도착예정버스의 여행시간
 *       traSpd2	string	두번째도착예정버스의 여행속도
 *       isArrive2	string	두번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
 *       isLast2	string	두번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
 *       busType2	string	두번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       adirection	string	방향
 *       arrmsg1	string	첫번째도착예정버스의 도착정보메시지
 *       arrmsg2	string	두번째도착예정버스의 도착정보메시지
 *       arrmsgSec1	string	첫번째도착예정버스의 도착정보메시지
 *       arrmsgSec2	string	두번째도착예정버스의 도착정보메시지
 *       isFullFlag1	string	첫번째도착예정버스의 만차여부 (0 : 만차아님. 1 : 만차)
 *       isFullFlag2	string	두번째도착예정버스의 만차여부 (0 : 만차아님. 1 : 만차)
 *       nxtStn	string	다음정류장순번
 *       posX	string	정류소 좌표X (GRS80)
 *       posY	string	정류소 좌표Y (GRS80)
 *       rerdieDiv1	string	첫번째도착예정버스의 재차구분
 *       rerdieDiv2	string	두번째도착예정버스의 재차구분
 *       rerideNum1	string	첫번째도착예정버스의 재차인원
 *       rerideNum2	string	두번째도착예정버스의 재차인원
 *       sectNm	string	구간명
 *       congetion1	string	첫번째차량 혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 *       congetion2	string	두번째차량 혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 */
@ToString
@Getter
public class StationByIdResponse<T> {

    @JsonProperty("ServiceResult")
    private StationByIdResResult<T> serviceResult;

    private StationByIdResponse() {}
}
