package kyu.pj.transportinformation.topis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.stations.data.response.StationInfoResBodyList;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class TopisResBody<T> {

    @JsonProperty("itemList")
    List<StationInfoResBodyList> itemList;
}
