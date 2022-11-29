package kyu.pj.transportinformation.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConstructorBinding
@Configuration
@ConfigurationProperties(prefix = "topis")
public class TopisProperty {

    private String scheme;
    private String host;
    private String arriveEncodingKey;
    private String arriveDecodingKey;
}
