package Backend;
public class Trainer implements UseMethods {
    private String trainerId;
    private String name;
    private String email;
    private String specialty;
    private String phoneNumber;

    public Trainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
    }

    public String lineRepresentation (){
        return String.join(",", trainerId, name, email, specialty, phoneNumber);
    }

    public String getSearchKey(){
        return trainerId;
    }





}
