package kyu.pj.transportinformation.topis.stations.controller;

import kyu.pj.transportinformation.topis.stations.data.response.byid.StationByIdResponse;
import kyu.pj.transportinformation.topis.stations.data.response.byname.StationByNameResponse;
import kyu.pj.transportinformation.topis.stations.data.response.byroute.StationByRouteResponse;
import kyu.pj.transportinformation.topis.stations.service.StationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

import static kyu.pj.transportinformation.common.utils.ResultUtils.resultOk;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/seoul-bus")
public class StationsController {

    private final StationsService stationsService;

    @GetMapping("station-name/{station_name}")
    public ResponseEntity<?> getStationByName(@PathVariable("station_name") @NotBlank(message = "정류소 정보는 필수입니다.") String stationName) {
        StationByNameResponse result = stationsService.getStationByName(stationName);
        return resultOk(result);
    }

    @GetMapping("station-id/{station_id}")
    public ResponseEntity<?> getStationById(@PathVariable("station_id") @NotBlank(message = "정류소 id는 필수입니다.") String stationId) {
        StationByIdResponse result = stationsService.getStationById(stationId);
        return resultOk(result);
    }

    @GetMapping("station-route/{route_id}")
    public ResponseEntity<?> getStationByRoute(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        StationByRouteResponse result = stationsService.getStationByRoute(routeId);
        return resultOk(result);
    }
}
