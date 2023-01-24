package TASK1;

import java.time.LocalDateTime;

public class Daily_Task extends Task implements Repeatable {
    public Daily_Task(String title, Type taskType, LocalDateTime firstTime) {
        super(title, taskType, firstTime);
    }


    @Override
    public LocalDateTime getNextTime() {
        return LocalDateTime.now().plusDays(1);
    }

    @Override
    public String getTimeOfManaging() {
        return "day";
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getFirstTime().toLocalDate().equals(requestedDate.toLocalDate());
    }
}
