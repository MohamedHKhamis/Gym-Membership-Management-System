import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TrainerRole adminRole = new TrainerRole();
        //adminRole.addClass("45", "42", "54", 54, 5);
        System.out.println(adminRole.getListOfClasses().size());
    }
}