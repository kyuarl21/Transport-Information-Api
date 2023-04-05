package kyu.pj.transportinformation.common.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatUtils {

    public static LocalDateTime localDateTimeFormat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
        return LocalDateTime.parse(formatDateTime, formatter);
    }

    public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
        return localDateTimeFormat(timestamp.toLocalDateTime());
    }
}
