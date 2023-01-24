package TASK1;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Calendar {

    private static final Map<Integer, Repeatable> tasks = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void addTask(Scanner scanner) {

            scanner.nextLine();
            System.out.println("Введите название задачи");
            String title = ValidateUtils.checkString(scanner.nextLine());
            System.out.println("Введите описание задачи");
            String description = scanner.nextLine();
            System.out.println("Введите тип задачи: рабочая или личная");
            Type type = Type.valueOf(scanner.nextLine());
            System.out.println("Введите повторяемость задачи: 0 - однократная, 1 - Ежедневная, 2 - Еженедельная, 3 - Ежемесячная, 4 - Ежегодная");
            int occurance = scanner.nextInt();
            System.out.println("Введите дату: dd.MM.yyyy HH:mm");
            scanner.nextLine();
            createEvent(scanner, title, description, type, occurance);
            System.out.println("Для выхода нажмите Enter ");
            scanner.nextLine();

    }

    private static void createEvent(Scanner scanner, String title, String description, Type type, int occurance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Repeatable task = null;
            try {
                task = createTask(occurance, title, type, eventDate);
                System.out.println(task);
            } catch (RuntimeException e) {}
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат");
            createEvent(scanner, title, description, type, occurance);
        }
    }

    private static Repeatable createTask(int occurance, String title, Type type, LocalDateTime localDateTime) throws RuntimeException {
        return switch (occurance) {
            case 0 -> {
                Oncely_Task oncely_task = new Oncely_Task(title, type, localDateTime);
                tasks.put(oncely_task.getId(), oncely_task);
                yield oncely_task;
            }
            case 1 -> {
                Daily_Task daily_task = new Daily_Task(title, type, localDateTime);
                tasks.put(daily_task.getId(), daily_task);
                yield daily_task;
            }
            case 2 -> {
                Weekly_Task weekly_task = new Weekly_Task(title, type, localDateTime);
                tasks.put(weekly_task.getId(), weekly_task);
                yield weekly_task;
            }
            case 3 -> {
                Monthly_Task monthly_task = new Monthly_Task(title, type, localDateTime);
                tasks.put(monthly_task.getId(), monthly_task);
                yield monthly_task;
            }
            case 4 -> {
                Yearly_Task yearly_task = new Yearly_Task(title, type, localDateTime);
                tasks.put(yearly_task.getId(), yearly_task);
                yield yearly_task;
            }
            default -> null;
        };
    }

    public static void deleteTask(Scanner scanner) {
        int id = scanner.nextInt();
        if (tasks.containsKey(id)){
            tasks.remove(id);
            System.out.println("Задача " + id + " удалена");
        } else {
            System.out.println("Такой задачи не сущ.");
        }
    }

    public static void getTask(Scanner scanner){
        System.out.println("Введите дату в формате dd.MM.yyyy");
        try {
            String date = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateTimeFormatter);
            List<Repeatable> events = findTasksByDate(requestedDate);
            for (Repeatable task : events) {
                System.out.println(task);
            }
        } catch (DateTimeParseException e ) {
            System.out.println("Неверный формат времент");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмтие Enter");
    }

    private static List<Repeatable> findTasksByDate(LocalDate date) {
        List<Repeatable> tasks2 = new ArrayList<>();
        for (Repeatable task : tasks.values() ) {
            if (task.checkOccurance(date.atStartOfDay())){
                tasks2.add(task);
            }
        }
        return tasks2;
    }


}
