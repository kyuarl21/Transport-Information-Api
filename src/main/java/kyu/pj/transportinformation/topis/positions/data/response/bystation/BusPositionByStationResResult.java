package kyu.pj.transportinformation.topis.positions.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusPositionByStationResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private BusPositionByStationResBody<T> msgBody;

    private BusPositionByStationResResult() {}
}
