package TASK1;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {
    public WeeklyTask(String title, Type taskType, LocalDateTime firstTime) {
        super(title, taskType, firstTime);
    }

    @Override
    public LocalDateTime getNextTime() {
        return LocalDateTime.now().plusWeeks(1);
    }

    @Override
    public String getTimeOfManaging() {
        return "week";
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getFirstTime().getDayOfWeek() == requestedDate.getDayOfWeek();
    }
}
