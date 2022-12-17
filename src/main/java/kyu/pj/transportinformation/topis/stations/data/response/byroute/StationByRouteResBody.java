package kyu.pj.transportinformation.topis.stations.data.response.byroute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class StationByRouteResBody<T> {

    @JsonProperty("itemList")
    private List<StationByRouteResBodyList> itemList;

    private StationByRouteResBody() {}
}
