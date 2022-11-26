package kyu.pj.transportinformation.topis.controller;

import com.fasterxml.jackson.databind.JsonNode;
import kyu.pj.transportinformation.topis.service.TopisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kyu.pj.transportinformation.common.utils.ResultUtils.resultOk;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/bus")
public class TopisController {

    private final TopisService topisService;

    @GetMapping("arrive")
    public ResponseEntity<?> getBusArrive() {
        String result = topisService.busArrive();
        return resultOk(result);
    }
}
