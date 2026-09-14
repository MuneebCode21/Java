package park.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkEvent {
    private final LocalDateTime timestamp;
    private final String message;
    public ParkEvent(String message) { this.timestamp = LocalDateTime.now(); this.message = message; }
    public String getMessage() { return message; }
    @Override public String toString() {
        return timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "  •  " + message;
    }
}
