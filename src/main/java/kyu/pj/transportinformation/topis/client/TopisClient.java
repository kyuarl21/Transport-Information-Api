package kyu.pj.transportinformation.topis.client;

import kyu.pj.transportinformation.common.properties.TopisProperties;
import kyu.pj.transportinformation.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class TopisClient {

    private final WebClient webClient;
    private final TopisProperties topisProperties;

    @Autowired
    public TopisClient(TopisProperties topisProperties) {
        this.topisProperties = topisProperties;
        this.webClient = WebClient.builder()
                .baseUrl(UriComponentsBuilder.newInstance()
                        .scheme(topisProperties.getScheme())
                        .host(topisProperties.getHost())
                        .build().toUriString()
                ).exchangeStrategies(exchangeStrategies)
                .build();
    }

    public String getRouteList(String search) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getBusRouteList")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("stSrch", search)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getRouteInfo(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getRouteInfo")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getRoutePath(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getRoutePath")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getRouteByStation(String stationId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getRouteByStation")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("arsId", stationId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getStationByName(String stationName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getStationByName")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("stSrch", stationName)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getStationById(String stationId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getStationByUid")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("arsId", stationId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getStationByRoute(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getStaionByRoute")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByRouteId(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByRtid")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByStation(String routeId, String startStation, String endStation) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByRouteSt")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .queryParam("startOrd", startStation)
                        .queryParam("endOrd", endStation)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByBusId(String busId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByVehId")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("vehId", busId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getBusArrive(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/arrive/getArrInfoByRouteAll")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getBusArriveByStation(String stationId, String routeId, String order) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/arrive/getArrInfoByRoute")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("stId", stationId)
                        .queryParam("busRouteId", routeId)
                        .queryParam("ord", order)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getTransferPath(String search) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pathinfo/getLocationInfo")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("stSrch", search)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getTransferByBus(String startX, String startY, String endX, String endY) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pathinfo/getPathInfoByBus")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("startX", startX)
                        .queryParam("startY", startY)
                        .queryParam("endX", endX)
                        .queryParam("endY", endY)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getTransferBySubway(String startX, String startY, String endX, String endY) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pathinfo/getPathInfoBySubway")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("startX", startX)
                        .queryParam("startY", startY)
                        .queryParam("endX", endX)
                        .queryParam("endY", endY)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    public String getTransferByBusNSub(String startX, String startY, String endX, String endY) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pathinfo/getPathInfoByBusNSub")
                        .queryParam("ServiceKey", topisProperties.getDecodingKey())
                        .queryParam("startX", startX)
                        .queryParam("startY", startY)
                        .queryParam("endX", endX)
                        .queryParam("endY", endY)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new ResponseException((HttpStatus) response.statusCode(), response.statusCode().value(), bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new IllegalArgumentException(error.getMessage())); // TODO
                }).block();
    }

    private void defaultHeaders(HttpHeaders headers) {
        headers.setContentType(new MediaType(MediaType.APPLICATION_XML, StandardCharsets.UTF_8));
    }

    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1))
            .build();
}
