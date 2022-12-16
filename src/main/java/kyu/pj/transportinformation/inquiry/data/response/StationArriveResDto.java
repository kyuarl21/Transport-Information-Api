package kyu.pj.transportinformation.inquiry.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class StationArriveResDto {

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

    @JsonProperty("gpsX")
    private String gpsX;

    @JsonProperty("gpsY")
    private String gpsY;

    @JsonProperty("stationTp")
    private String stationTp;

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

    @JsonProperty("isLast1")
    private String isLast1;

    @JsonProperty("busType1")
    private String busType1;

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

    @JsonProperty("isLast2")
    private String isLast2;

    @JsonProperty("busType2")
    private String busType2;

    @JsonProperty("adirection")
    private String adirection;

    @JsonProperty("arrmsg1")
    private String arrmsg1;

    @JsonProperty("arrmsg2")
    private String arrmsg2;

    @JsonProperty("arrmsgSec1")
    private String arrmsgSec1;

    @JsonProperty("arrmsgSec2")
    private String arrmsgSec2;

    @JsonProperty("isFullFlag1")
    private String isFullFlag1;

    @JsonProperty("isFullFlag2")
    private String isFullFlag2;

    @JsonProperty("nxtStn")
    private String nxtStn;

    @JsonProperty("posX")
    private String posX;

    @JsonProperty("posY")
    private String posY;

    @JsonProperty("rerdieDiv1")
    private String rerdieDiv1;

    @JsonProperty("rerdieDiv2")
    private String rerdieDiv2;

    @JsonProperty("rerideNum1")
    private String rerideNum1;

    @JsonProperty("rerideNum2")
    private String rerideNum2;

    @JsonProperty("sectNm")
    private String sectNm;

    @JsonProperty("congetion1")
    private String congetion1;

    @JsonProperty("congetion2")
    private String congetion2;
}
