package kyu.pj.transportinformation.topis.stations.data.response.byname;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class StationResBodyByName<T> {

    @JsonProperty("itemList")
    private List<StationResBodyListByName> itemList;
}
