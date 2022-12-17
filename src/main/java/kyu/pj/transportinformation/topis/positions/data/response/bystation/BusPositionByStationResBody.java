package kyu.pj.transportinformation.topis.positions.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class BusPositionByStationResBody<T> {

    @JsonProperty("itemList")
    private List<BusPositionByStationResBodyList> itemList;

    private BusPositionByStationResBody() {}
}
