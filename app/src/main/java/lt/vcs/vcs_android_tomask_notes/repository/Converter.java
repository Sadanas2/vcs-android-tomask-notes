package lt.vcs.vcs_android_tomask_notes.repository;

import androidx.room.TypeConverter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

public class Converter {

    @TypeConverter
    public static LocalDateTime fromTimestamp(Long timestamp){
        if(timestamp == null) return null;
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    @TypeConverter
    public static Long  toTimestamp(LocalDateTime date){
        if(date== null) return null;
        return date.getLong(ChronoField.CLOCK_HOUR_OF_DAY);
    }

}

