package kyu.pj.transportinformation.topis.transfer.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TransferByBusResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private TransferByBusResBody msgBody;

    private TransferByBusResResult() {}
}
