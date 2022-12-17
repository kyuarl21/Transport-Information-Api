package kyu.pj.transportinformation.topis.arrive.controller;

import kyu.pj.transportinformation.topis.arrive.data.response.bystation.BusArriveByStationResponse;
import kyu.pj.transportinformation.topis.arrive.data.response.info.BusArriveResponse;
import kyu.pj.transportinformation.topis.arrive.service.ArriveService;
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
public class ArriveController {

    private final ArriveService arriveService;

    @GetMapping("arrive/{route_id}")
    public ResponseEntity<?> getBusArrive(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        BusArriveResponse result = arriveService.getBusArrive(routeId);
        return resultOk(result);
    }

    @GetMapping("arrive-station")
    public ResponseEntity<?> getBusArriveByStation(
            @RequestParam(value = "station_id", required = false) String stationId,
            @RequestParam(value = "route_id", required = false) String routeId,
            @RequestParam(value = "order", required = false) String order) {

        BusArriveByStationResponse result = arriveService.getBusArriveByStation(stationId, routeId, order);
        return resultOk(result);
    }
}
