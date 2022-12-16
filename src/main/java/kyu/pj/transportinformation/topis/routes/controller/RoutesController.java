package kyu.pj.transportinformation.topis.routes.controller;

import kyu.pj.transportinformation.topis.routes.data.response.info.RouteInfoResponse;
import kyu.pj.transportinformation.topis.routes.data.response.list.RouteListResponse;
import kyu.pj.transportinformation.topis.routes.data.response.path.RoutePathResponse;
import kyu.pj.transportinformation.topis.routes.service.RoutesService;
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
public class RoutesController {

    private final RoutesService routesService;

    @GetMapping("route-list/{search}")
    public ResponseEntity<?> getRouteList(@PathVariable("search") @NotBlank(message = "노선 검색값은 필수입니다.") String search) {
        RouteListResponse result = routesService.getRouteList(search);
        return resultOk(result);
    }

    @GetMapping("route-info/{route_id}")
    public ResponseEntity<?> getRouteInfo(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        RouteInfoResponse result = routesService.getRouteInfo(routeId);
        return resultOk(result);
    }

    @GetMapping("route-path/{route_id}")
    public ResponseEntity<?> getRoutePath(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        RoutePathResponse result = routesService.getRoutePath(routeId);
        return resultOk(result);
    }

    @GetMapping("station-route/{route_id}")
    public ResponseEntity<?> getStationByRoute(@PathVariable("route_id") @NotBlank(message = "노선 id는 필수입니다.") String routeId) {
        String result = routesService.getStationByRoute(routeId);
        return resultOk(result);
    }
}
