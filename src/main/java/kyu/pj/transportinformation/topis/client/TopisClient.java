package kyu.pj.transportinformation.topis.client;

import kyu.pj.transportinformation.common.properties.TopisProperty;
import kyu.pj.transportinformation.handler.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    private final TopisProperty topisProperty;

    @Autowired
    public TopisClient(TopisProperty topisProperty) {
        this.topisProperty = topisProperty;
        this.webClient = WebClient.builder()
                .baseUrl(UriComponentsBuilder.newInstance()
                        .scheme(topisProperty.getScheme())
                        .host(topisProperty.getHost())
                        .build().toUriString()
                ).exchangeStrategies(exchangeStrategies)
                .build();
    }

    public String getRouteList(String search) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getBusRouteList")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("stSrch", search)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getRouteInfo(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getRouteInfo")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getRoutePath(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getRoutePath")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getStationByRoute(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/busRouteInfo/getStaionByRoute")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getStationByName(String stationName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getStationByName")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("stSrch", stationName)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getStationById(String stationId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getStationByUid")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("arsId", stationId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getRouteByStation(String stationId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationinfo/getRouteByStation")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("arsId", stationId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByRouteId(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByRtid")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByStation(String routeId, String startStation, String endStation) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByRouteSt")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
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
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getPositionByBusId(String busId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buspos/getBusPosByVehId")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("vehId", busId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    public String getBusArrive(String routeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/arrive/getArrInfoByRouteAll")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", routeId)
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    private void defaultHeaders(HttpHeaders headers) {
        headers.setContentType(new MediaType(MediaType.APPLICATION_XML, StandardCharsets.UTF_8));
    }

    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1))
            .build();
}
