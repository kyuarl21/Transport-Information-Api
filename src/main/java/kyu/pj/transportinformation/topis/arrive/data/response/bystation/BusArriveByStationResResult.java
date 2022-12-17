package kyu.pj.transportinformation.topis.arrive.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusArriveByStationResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private BusArriveByStationResBody<T> msgBody;

    private BusArriveByStationResResult() {}
}
