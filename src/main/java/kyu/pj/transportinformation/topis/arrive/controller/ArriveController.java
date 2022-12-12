package kyu.pj.transportinformation.topis.arrive.controller;

import kyu.pj.transportinformation.topis.arrive.service.ArriveService;
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
public class ArriveController {

    private final ArriveService arriveService;

    @GetMapping("arrive")
    public ResponseEntity<?> getBusArrive(@RequestParam(value = "route_id", required = false) String routeId) {
        String result = arriveService.busArrive(routeId);
        return resultOk(result);
    }
}
