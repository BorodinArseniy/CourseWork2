package TASK1;

import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable {
    public YearlyTask(String title, Type taskType, LocalDateTime firstTime) {
        super(title, taskType, firstTime);
    }


    @Override
    public LocalDateTime getNextTime() {
        return LocalDateTime.now().plusYears(1);
    }

    @Override
    public String getTimeOfManaging() {
        return "Year";
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getFirstTime().getDayOfYear() == requestedDate.getDayOfYear();
    }

}
