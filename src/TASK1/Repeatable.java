package TASK1;

import java.time.LocalDateTime;

public interface Repeatable {

    LocalDateTime getNextTime();

    String getTimeOfManaging();

    boolean checkOccurance(LocalDateTime requestedDate);

}
