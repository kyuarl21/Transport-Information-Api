package kyu.pj.transportinformation.topis.stations.data.response.byid;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class StationResResultById<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private StationResBodyById<T> msgBody;
}
