package kyu.pj.transportinformation.topis.positions.controller;

import kyu.pj.transportinformation.topis.positions.service.PositionsService;
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
public class PositionsController {

    private final PositionsService positionsService;

    @GetMapping("position-route")
    public ResponseEntity<?> getPositionByRouteId(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = positionsService.getPositionByRouteId(routeId);
        return resultOk(result);
    }

    @GetMapping("position-station")
    public ResponseEntity<?> getPositionByStation(
            @RequestParam(value = "route_id", required = false) String routeId,
            @RequestParam(value = "start_station", required = false) String startStation,
            @RequestParam(value = "end_station", required = false) String endStation) {
        String result = positionsService.getPositionByStation(routeId, startStation, endStation);
        return resultOk(result);
    }

    @GetMapping("position-bus")
    public ResponseEntity<?> getPositionByBusId(@RequestParam(value = "bus_id", required = false) String busId) {
        String result = positionsService.getPositionByBusId(busId);
        return resultOk(result);
    }
}
