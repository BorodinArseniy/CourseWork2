package TASK1;

import java.time.LocalDateTime;

public class Monthly_Task extends Task implements Repeatable {
    public Monthly_Task(String title, Type taskType, LocalDateTime firstTime) {
        super(title, taskType, firstTime);
    }

    @Override
    public LocalDateTime getNextTime() {
        return LocalDateTime.now().plusMonths(1);
    }

    @Override
    public String getTimeOfManaging() {
        return "month";
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getFirstTime().getMonth() == requestedDate.getMonth();
    }
}
