package kyu.pj.transportinformation.topis.stations.controller;

import kyu.pj.transportinformation.topis.common.TopisResponse;
import kyu.pj.transportinformation.topis.stations.service.StationsService;
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
public class StationsController {

    private final StationsService stationsService;

    @GetMapping("station/{station}")
    public ResponseEntity<?> getStation(@PathVariable("station") @NotBlank(message = "정류소 정보는 필수입니다.") String station) {
        TopisResponse result = stationsService.getStation(station);
        return resultOk(result);
    }

    @GetMapping("route-station")
    public ResponseEntity<?> getRouteByStation(@RequestParam(value = "station_id", required = false) String stationId) {
        String result = stationsService.getRouteByStation(stationId);
        return resultOk(result);
    }
}
