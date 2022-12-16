package kyu.pj.transportinformation.topis.stations.data.response.byname;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class StationResResultByName<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private StationResBodyByName<T> msgBody;
}
