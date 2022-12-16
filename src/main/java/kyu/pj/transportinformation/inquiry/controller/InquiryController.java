package kyu.pj.transportinformation.inquiry.controller;

import kyu.pj.transportinformation.inquiry.data.response.StationArriveResDto;
import kyu.pj.transportinformation.inquiry.service.InquiryService;
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
@RequestMapping("v1/inquire")
public class InquiryController {

    private final InquiryService inquiryService;

    @GetMapping("station/{station}")
    public ResponseEntity<?> getStationArrive(@PathVariable("station") @NotBlank(message = "정류소 정보는 필수입니다.") String stationName) {
        Object result = inquiryService.getStationArrive(stationName);
        return resultOk(result);
    }
}
