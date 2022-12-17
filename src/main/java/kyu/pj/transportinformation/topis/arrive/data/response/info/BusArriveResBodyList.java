package kyu.pj.transportinformation.topis.arrive.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/arrive
 * (EX : http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?busRouteId=xxxxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * busRouteId	string (필수)	노선 ID
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
public class BusArriveResBodyList {

    @JsonProperty("stId")
    private String stId;

    @JsonProperty("stNm")
    private String stNm;

    @JsonProperty("arsId")
    private String arsId;

    @JsonProperty("busRouteAbrv")
    private String busRouteAbrv;

    @JsonProperty("busRouteId")
    private String busRouteId;

    @JsonProperty("rtNm")
    private String rtNm;

    @JsonProperty("firstTm")
    private String firstTm;

    @JsonProperty("lastTm")
    private String lastTm;

    @JsonProperty("term")
    private String term;

    @JsonProperty("routeType")
    private String routeType;

    @JsonProperty("nextBus")
    private String nextBus;

    @JsonProperty("staOrd")
    private String staOrd;

    @JsonProperty("dir")
    private String dir;

    @JsonProperty("mkTm")
    private String mkTm;

    @JsonProperty("vehId1")
    private String vehId1;

    @JsonProperty("plainNo1")
    private String plainNo1;

    @JsonProperty("sectOrd1")
    private String sectOrd1;

    @JsonProperty("stationNm1")
    private String stationNm1;

    @JsonProperty("traTime1")
    private String traTime1;

    @JsonProperty("traSpd1")
    private String traSpd1;

    @JsonProperty("isArrive1")
    private String isArrive1;

    @JsonProperty("repTm1")
    private String repTm1;

    @JsonProperty("isLast1")
    private String isLast1;

    @JsonProperty("busType1")
    private String busType1;

    @JsonProperty("avgCf1")
    private String avgCf1;

    @JsonProperty("expCf1")
    private String expCf1;

    @JsonProperty("kalCf1")
    private String kalCf1;

    @JsonProperty("neuCf1")
    private String neuCf1;

    @JsonProperty("exps1")
    private String exps1;

    @JsonProperty("kals1")
    private String kals1;

    @JsonProperty("neus1")
    private String neus1;

    @JsonProperty("rerdie_Div1")
    private String rerdie_Div1;

    @JsonProperty("reride_Num1")
    private String reride_Num1;

    @JsonProperty("brerde_Div1")
    private String brerde_Div1;

    @JsonProperty("brdrde_Num1")
    private String brdrde_Num1;

    @JsonProperty("full1")
    private String full1;

    @JsonProperty("nstnId1")
    private String nstnId1;

    @JsonProperty("nstnOrd1")
    private String nstnOrd1;

    @JsonProperty("nstnSpd1")
    private String nstnSpd1;

    @JsonProperty("nstnSec1")
    private String nstnSec1;

    @JsonProperty("nmainStnid1")
    private String nmainStnid1;

    @JsonProperty("nmainOrd1")
    private String nmainOrd1;

    @JsonProperty("nmainSec1")
    private String nmainSec1;

    @JsonProperty("nmain2Stnid1")
    private String nmain2Stnid1;

    @JsonProperty("nmain2Ord1")
    private String nmain2Ord1;

    @JsonProperty("namin2Sec1")
    private String namin2Sec1;

    @JsonProperty("nmain3Stnid1")
    private String nmain3Stnid1;

    @JsonProperty("nmain3Ord1")
    private String nmain3Ord1;

    @JsonProperty("nmain3Sec1")
    private String nmain3Sec1;

    @JsonProperty("goal1")
    private String goal1;

    @JsonProperty("vehId2")
    private String vehId2;

    @JsonProperty("plainNo2")
    private String plainNo2;

    @JsonProperty("sectOrd2")
    private String sectOrd2;

    @JsonProperty("stationNm2")
    private String stationNm2;

    @JsonProperty("traTime2")
    private String traTime2;

    @JsonProperty("traSpd2")
    private String traSpd2;

    @JsonProperty("isArrive2")
    private String isArrive2;

    @JsonProperty("repTm2")
    private String repTm2;

    @JsonProperty("isLast2")
    private String isLast2;

    @JsonProperty("busType2")
    private String busType2;

    @JsonProperty("avgCf2")
    private String avgCf2;

    @JsonProperty("expCf2")
    private String expCf2;

    @JsonProperty("calCf2")
    private String calCf2;

    @JsonProperty("neuCf2")
    private String neuCf2;

    @JsonProperty("exps2")
    private String exps2;

    @JsonProperty("kals2")
    private String kals2;

    @JsonProperty("neus2")
    private String neus2;

    @JsonProperty("rerdie_Div2")
    private String rerdie_Div2;

    @JsonProperty("reride_Num2")
    private String reride_Num2;

    @JsonProperty("brerde_Div2")
    private String brerde_Div2;

    @JsonProperty("brdrde_Num2")
    private String brdrde_Num2;

    @JsonProperty("full2")
    private String full2;

    @JsonProperty("nstnId2")
    private String nstnId2;

    @JsonProperty("nstnOrd2")
    private String nstnOrd2;

    @JsonProperty("nstnSpd2")
    private String nstnSpd2;

    @JsonProperty("nstnSec2")
    private String nstnSec2;

    @JsonProperty("nmainStnid2")
    private String nmainStnid2;

    @JsonProperty("nmainOrd2")
    private String nmainOrd2;

    @JsonProperty("nmainSec2")
    private String nmainSec2;

    @JsonProperty("nmain2Stnid2")
    private String nmain2Stnid2;

    @JsonProperty("nmain2Ord2")
    private String nmain2Ord2;

    @JsonProperty("namin2Sec2")
    private String namin2Sec2;

    @JsonProperty("nmain3Stnid2")
    private String nmain3Stnid2;

    @JsonProperty("nmain3Ord2")
    private String nmain3Ord2;

    @JsonProperty("nmain3Sec2")
    private String nmain3Sec2;

    @JsonProperty("goal2")
    private String goal2;

    @JsonProperty("arrmsg1")
    private String arrmsg1;

    @JsonProperty("arrmsg2")
    private String arrmsg2;

    private BusArriveResBodyList() {}
}
