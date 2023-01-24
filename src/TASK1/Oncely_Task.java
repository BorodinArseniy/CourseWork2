package TASK1;

import java.time.LocalDateTime;

public class Oncely_Task extends Task implements Repeatable {


    public Oncely_Task(String title, Type taskType, LocalDateTime date) {
        super(title, taskType, date);
    }

    @Override
    public LocalDateTime getNextTime() {
        return null;
    }

    @Override
    public String getTimeOfManaging() {
        return null;
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getFirstTime().getYear() == requestedDate.getYear();
    }

}
