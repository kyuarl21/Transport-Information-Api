package kyu.pj.transportinformation.topis.arrive.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class BusArriveByStationResBody<T> {

    @JsonProperty("itemList")
    private List<BusArriveByStationResBodyList> itemList;

    private BusArriveByStationResBody() {}
}
