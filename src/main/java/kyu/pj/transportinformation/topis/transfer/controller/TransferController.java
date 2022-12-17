package kyu.pj.transportinformation.topis.transfer.controller;

import kyu.pj.transportinformation.topis.transfer.data.response.busnsub.TransferBusNSubResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.bybus.TransferByBusResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.bysubway.TransferBySubResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.info.TransferPathResponse;
import kyu.pj.transportinformation.topis.transfer.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

import static kyu.pj.transportinformation.common.utils.ResultUtils.resultOk;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/seoul-bus")
public class TransferController {

    private final TransferService transferService;

    @GetMapping("transfer/{search}")
    public ResponseEntity<?> getTransferPath(@PathVariable("search") @NotBlank(message = "검색 값은 필수입니다.") String search) {
        TransferPathResponse result = transferService.getTransferPath(search);
        return resultOk(result);
    }

    @GetMapping("transfer-bus")
    public ResponseEntity<?> getTransferByBus(
            @RequestParam(value = "start_x", required = false) String startX,
            @RequestParam(value = "start_y", required = false) String startY,
            @RequestParam(value = "end_x", required = false) String endX,
            @RequestParam(value = "end_y", required = false) String endY) {

        TransferByBusResponse result = transferService.getTransferByBus(startX, startY, endX, endY);
        return resultOk(result);
    }

    @GetMapping("transfer-subway")
    public ResponseEntity<?> getTransferBySubway(
            @RequestParam(value = "start_x", required = false) String startX,
            @RequestParam(value = "start_y", required = false) String startY,
            @RequestParam(value = "end_x", required = false) String endX,
            @RequestParam(value = "end_y", required = false) String endY) {

        TransferBySubResponse result = transferService.getTransferBySubway(startX, startY, endX, endY);
        return resultOk(result);
    }

    @GetMapping("transfer-bus-subway")
    public ResponseEntity<?> getTransferByBusNSub(
            @RequestParam(value = "start_x", required = false) String startX,
            @RequestParam(value = "start_y", required = false) String startY,
            @RequestParam(value = "end_x", required = false) String endX,
            @RequestParam(value = "end_y", required = false) String endY) {

        TransferBusNSubResponse result = transferService.getTransferByBusNSub(startX, startY, endX, endY);
        return resultOk(result);
    }
}
