package kyu.pj.transportinformation.topis.arrive.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusArriveResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private BusArriveResBody<T> msgBody;

    private BusArriveResResult() {}
}
