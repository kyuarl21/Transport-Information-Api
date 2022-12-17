package kyu.pj.transportinformation.topis.positions.data.response.byroute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class BusPositionByRouteResBody<T> {

    @JsonProperty("itemList")
    private List<BusPositionByRouteResBodyList> itemList;

    private BusPositionByRouteResBody() {}
}
