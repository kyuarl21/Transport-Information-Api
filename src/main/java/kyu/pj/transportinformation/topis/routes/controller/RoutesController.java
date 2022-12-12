package kyu.pj.transportinformation.topis.routes.controller;

import kyu.pj.transportinformation.topis.routes.service.RoutesService;
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
public class RoutesController {

    private final RoutesService routesService;

    @GetMapping("route-list")
    public ResponseEntity<?> getRouteList(@RequestParam(value = "search", required = false) String search) {
        String result = routesService.getRouteList(search);
        return resultOk(result);
    }

    @GetMapping("route-info")
    public ResponseEntity<?> getRouteInfo(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = routesService.getRouteInfo(routeId);
        return resultOk(result);
    }

    @GetMapping("route-path")
    public ResponseEntity<?> getRoutePath(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = routesService.getRoutePath(routeId);
        return resultOk(result);
    }

    @GetMapping("station-route")
    public ResponseEntity<?> getStationByRoute(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = routesService.getStationByRoute(routeId);
        return resultOk(result);
    }
}
