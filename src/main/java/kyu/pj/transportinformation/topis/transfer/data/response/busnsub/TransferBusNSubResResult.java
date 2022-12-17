package kyu.pj.transportinformation.topis.transfer.data.response.busnsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TransferBusNSubResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private TransferBusNSubResBody<T> msgBody;

    private TransferBusNSubResResult() {}
}
