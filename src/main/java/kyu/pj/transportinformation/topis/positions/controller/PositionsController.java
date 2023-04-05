package kyu.pj.transportinformation.topis.positions.controller;

import jakarta.validation.constraints.NotBlank;
import kyu.pj.transportinformation.topis.positions.data.response.bybus.BusPositionByBusResponse;
import kyu.pj.transportinformation.topis.positions.data.response.byroute.BusPositionByRouteResponse;
import kyu.pj.transportinformation.topis.positions.data.response.bystation.BusPositionByStationResponse;
import kyu.pj.transportinformation.topis.positions.service.PositionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kyu.pj.transportinformation.common.utils.ResultUtils.resultOk;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/seoul-bus")
public class PositionsController {

    private final PositionsService positionsService;

    @GetMapping("position-route/{route_id}")
    public ResponseEntity<?> getPositionByRouteId(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        BusPositionByRouteResponse result = positionsService.getPositionByRouteId(routeId);
        return resultOk(result);
    }

    @GetMapping("position-station/{route_id}")
    public ResponseEntity<?> getPositionByStation(
            @PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId,
            @RequestParam(value = "start_station", required = false) String startStation,
            @RequestParam(value = "end_station", required = false) String endStation) {
        BusPositionByStationResponse result = positionsService.getPositionByStation(routeId, startStation, endStation);
        return resultOk(result);
    }

    @GetMapping("position-bus/{bus_id}")
    public ResponseEntity<?> getPositionByBusId(@PathVariable("bus_id") @NotBlank(message = "버스 id는 필수입니다.") String busId) {
        BusPositionByBusResponse result = positionsService.getPositionByBusId(busId);
        return resultOk(result);
    }
}
