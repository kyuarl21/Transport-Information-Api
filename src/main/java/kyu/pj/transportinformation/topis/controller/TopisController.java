package kyu.pj.transportinformation.topis.controller;

import kyu.pj.transportinformation.topis.service.TopisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static kyu.pj.transportinformation.common.utils.ResultUtils.resultOk;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/seoul-bus")
public class TopisController {

    private final TopisService topisService;

    @GetMapping("route-list")
    public ResponseEntity<?> getRouteList(@RequestParam(value = "name", required = false) String stSrch) {
        String result = topisService.getRouteList(stSrch);
        return resultOk(result);
    }

    @GetMapping("arrive")
    public ResponseEntity<?> getBusArrive(@RequestParam(value = "name", required = false) String routeId) {
        String result = topisService.busArrive(routeId);
        return resultOk(result);
    }

    @GetMapping("station")
    public ResponseEntity<?> getStation(@RequestParam(value = "name", required = false) String stationName) {
        String result = topisService.getStationByName(stationName);
        return resultOk(result);
    }
}
