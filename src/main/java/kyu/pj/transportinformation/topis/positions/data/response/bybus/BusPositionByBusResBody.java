package kyu.pj.transportinformation.topis.positions.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusPositionByBusResBody<T> {

    @JsonProperty("itemList")
    private BusPositionByBusResBodyMap<T> itemList;

    private BusPositionByBusResBody() {}
}
