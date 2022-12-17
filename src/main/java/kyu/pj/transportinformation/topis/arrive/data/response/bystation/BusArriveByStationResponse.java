package kyu.pj.transportinformation.topis.arrive.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/arrive
 * (EX : http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRoute?stId=xxxxx&busRouteId=xxxxxxxx&ord=xxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * stId	string (필수)	정류소 고유 ID
 * busRouteId	string (필수)	노선 ID
 * ord	string (필수)	정류소 순번
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
 *       firstTm	string	첫차시간
 *       lastTm	string	막차시간
 *       term	string	배차간격 (분)
 *       routeType	string	노선유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
 *       nextBus	string	막차운행여부 (N:막차아님, Y:막차)
 *       staOrd	string	요청정류소순번
 *       dir	string	방향
 *       mkTm	string	제공시각
 *       vehId1	string	첫번째도착예정버스ID
 *       plainNo1	string	첫번째도착예정차량번호
 *       sectOrd1	string	첫번째도착예정버스의 현재구간 순번
 *       stationNm1	string	첫번째도착예정버스의 최종 정류소명
 *       traTime1	string	첫번째도착예정버스의 여행시간 (분)
 *       traSpd1	string	첫번째도착예정버스의 여행속도 (Km/h)
 *       isArrive1	string	첫번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
 *       repTm1	string	첫번째도착예정버스의 최종 보고 시간
 *       isLast1	string	첫번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
 *       busType1	string	첫번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       avgCf1	string	첫번째 도착예정 버스의 이동평균 보정계수
 *       expCf1	string	첫번째 도착예정 버스의 지수평활 보정계수
 *       kalCf1	string	첫번째 도착예정 버스의 기타1평균 보정계수
 *       neuCf1	string	첫번째 도착예정 버스의 기타2평균 보정계수
 *       exps1	string	첫번째 도착예정 버스의 지수평활 도착예정시간(초)
 *       kals1	string	첫번째 도착예정 버스의 기타1 도착예정시간(초)
 *       neus1	string	첫번째 도착예정 버스의 기타2 도착예정시간(초)
 *       rerdie_Div1	string	첫번째 도착예정 버스의 재차 구분값 - reride_Num1의 구분값(0: 데이터없음, 4:혼잡도)
 *       reride_Num1	string	첫번째 도착예정 버스의 재차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
 *       brerde_Div1	string	첫번째 도착예정 버스의 뒷차 구분값 - brdrde_Num1의 구분값(0: 데이터없음, 4:혼잡도)
 *       brdrde_Num1	string	첫번째 도착예정 버스의 뒷차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
 *       full1	string	첫번째 도착예정 버스의 만차여부
 *       nstnId1	string	첫번째 도착예정 버스의 다음정류소 ID
 *       nstnOrd1	string	첫번째 도착예정 버스의다음 정류소 순번
 *       nstnSpd1	string	첫번째 도착예정 버스의 다음 정류소 예정여행시간
 *       nstnSec1	string	첫번째 도착예정 버스의 다음 정류소 예정여행시간
 *       nmainStnid1	string	첫번째 도착예정 버스의 1번째 주요정류소 ID
 *       nmainOrd1	string	첫번째 도착예정 버스의 1번째 주요정류소 순번
 *       nmainSec1	string	첫번째 도착예정 버스의 1번째 주요정류소 예정여행시간
 *       nmain2Stnid1	string	첫번째 도착예정 버스의 2번째 주요정류소 ID
 *       nmain2Ord1	string	첫번째 도착예정 버스의 2번째 주요정류소 순번
 *       namin2Sec1	string	첫번째 도착예정 버스의 2번째 주요정류소 예정여행시간
 *       nmain3Stnid1	string	첫번째 도착예정 버스의 3번째 주요정류소 ID
 *       nmain3Ord1	string	첫번째 도착예정 버스의 3번째 주요정류소 순번
 *       nmain3Sec1	string	첫번째 도착예정 버스의 3번째 주요정류소 예정여행시간
 *       goal1	string	첫번째 도착예정 버스의 종점 도착예정시간(초)
 *       vehId2	string	두번째 도착예정버스ID
 *       plainNo2	string	두번째도착예정차량번호
 *       sectOrd2	string	두번째도착예정버스의 현재구간 순번
 *       stationNm2	string	두번째도착예정버스의 최종 정류소명
 *       traTime2	string	두번째도착예정버스의 여행시간
 *       traSpd2	string	두번째도착예정버스의 여행속도
 *       isArrive2	string	두번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
 *       repTm2	string	두번째도착예정버스의 최종 보고 시간
 *       isLast2	string	두번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
 *       busType2	string	두번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       avgCf2	string	두번째 도착예정 버스의 이동평균 보정계수
 *       expCf2	string	두번째 도착예정 버스의 지수평활 보정계수
 *       calCf2	string	두번째 도착예정 버스의 기타1평균 보정계수
 *       neuCf2	string	두번째 도착예정 버스의 기타2평균 보정계수
 *       exps2	string	두번째 도착예정 버스의 지수평활 도착예정시간(초)
 *       kals2	string	두번째 도착예정 버스의 기타1 도착예정시간(초)
 *       neus2	string	두번째 도착예정 버스의 기타2 도착예정시간(초)
 *       rerdie_Div2	string	두번째 도착예정 버스의 재차 구분값 - reride_Num2의 구분값(0: 데이터없음, 4:혼잡도)
 *       reride_Num2	string	두번째 도착예정 버스의 재차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
 *       brerde_Div2	string	두번째 도착예정 버스의 뒷차 구분값 - brdrde_Num2의 구분값(0: 데이터없음, 4:혼잡도)
 *       brdrde_Num2	string	두번째 도착예정 버스의 뒷차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
 *       full2	string	두번째 도착예정 버스의 만차여부
 *       nstnId2	string	두번째 도착예정 버스의 다음정류소 ID
 *       nstnOrd2	string	두번째 도착예정 버스의다음 정류소 순번
 *       nstnSpd2	string	두번째 도착예정 버스의 다음 정류소 예정여행시간
 *       nstnSec2	string	두번째 도착예정 버스의 다음 정류소 예정여행시간
 *       nmainStnid2	string	두번째 도착예정 버스의 1번째 주요정류소 ID
 *       nmainOrd2	string	두번째 도착예정 버스의 1번째 주요정류소 순번
 *       nmainSec2	string	두번째 도착예정 버스의 1번째 주요정류소 예정여행시간
 *       nmain2Stnid2	string	두번째 도착예정 버스의 2번째 주요정류소 ID
 *       nmain2Ord2	string	두번째 도착예정 버스의 2번째 주요정류소 순번
 *       namin2Sec2	string	두번째 도착예정 버스의 2번째 주요정류소 예정여행시간
 *       nmain3Stnid2	string	두번째 도착예정 버스의 3번째 주요정류소 ID
 *       nmain3Ord2	string	두번째 도착예정 버스의 3번째 주요정류소 순번
 *       nmain3Sec2	string	두번째 도착예정 버스의 3번째 주요정류소 예정여행시간
 *       goal2	string	두번째 도착예정 버스의 종점 도착예정시간(초)
 *       arrmsg1	string	첫번째 도착예정 버스의 도착정보메시지
 *       arrmsg2	string	두번째 도착예정 버스의 도착정보메시지
 */
@ToString
@Getter
public class BusArriveByStationResponse<T> {

    @JsonProperty("ServiceResult")
    private BusArriveByStationResResult<T> serviceResult;

    private BusArriveByStationResponse() {}
}
