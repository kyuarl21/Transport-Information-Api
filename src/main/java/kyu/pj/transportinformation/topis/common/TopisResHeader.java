package kyu.pj.transportinformation.topis.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TopisResHeader<T> {

    @JsonProperty("headerCd")
    private String headerCd;

    @JsonProperty("headerMsg")
    private String headerMsg;

    @JsonProperty("itemCount")
    private String itemCount;
}
