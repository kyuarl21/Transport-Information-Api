package kyu.pj.transportinformation.topis.routes.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class RouteByStationResBody<T> {

    @JsonProperty("itemList")
    private List<RouteByStationResBodyList> itemList;

    private RouteByStationResBody() {}
}
