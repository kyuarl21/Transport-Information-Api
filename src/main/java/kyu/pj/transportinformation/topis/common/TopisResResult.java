package kyu.pj.transportinformation.topis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TopisResResult<T> {

    @JsonProperty("msgHeader")
    TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    TopisResBody<T> msgBody;
}
