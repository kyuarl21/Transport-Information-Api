package kyu.pj.transportinformation.topis.controller;

import kyu.pj.transportinformation.topis.service.TopisService;
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
public class TopisController {

    private final TopisService topisService;

    @GetMapping("route-list")
    public ResponseEntity<?> getRouteList(@RequestParam(value = "search", required = false) String search) {
        String result = topisService.getRouteList(search);
        return resultOk(result);
    }

    @GetMapping("route-info")
    public ResponseEntity<?> getRouteInfo(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = topisService.getRouteList(routeId);
        return resultOk(result);
    }

    @GetMapping("route-path")
    public ResponseEntity<?> getRoutePath(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = topisService.getRoutePath(routeId);
        return resultOk(result);
    }

    @GetMapping("station-route")
    public ResponseEntity<?> getStationByRoute(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = topisService.getStationByRoute(routeId);
        return resultOk(result);
    }

    @GetMapping("station/{station}")
    public ResponseEntity<?> getStation(@PathVariable("station") @NotBlank(message = "정류소 정보는 필수입니다.") String station) {
        String result = topisService.getStation(station);
        return resultOk(result);
    }

    @GetMapping("route-station")
    public ResponseEntity<?> getRouteByStation(@RequestParam(value = "station_id", required = false) String stationId) {
        String result = topisService.getRouteByStation(stationId);
        return resultOk(result);
    }

    @GetMapping("position-route")
    public ResponseEntity<?> getPositionByRouteId(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = topisService.getPositionByRouteId(routeId);
        return resultOk(result);
    }

    @GetMapping("position-station")
    public ResponseEntity<?> getPositionByStation(
            @RequestParam(value = "route_id", required = false) String routeId,
            @RequestParam(value = "start_station", required = false) String startStation,
            @RequestParam(value = "end_station", required = false) String endStation) {
        String result = topisService.getPositionByStation(routeId, startStation, endStation);
        return resultOk(result);
    }

    @GetMapping("position-bus")
    public ResponseEntity<?> getPositionByBusId(@RequestParam(value = "bus_id", required = false) String busId) {
        String result = topisService.getPositionByBusId(busId);
        return resultOk(result);
    }

    @GetMapping("arrive")
    public ResponseEntity<?> getBusArrive(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = topisService.busArrive(routeId);
        return resultOk(result);
    }
}
