import java.util.List;

public class AdminRole {
    private TrainerDatabase database;
    public AdminRole() {
        database = new TrainerDatabase("Trainers.txt");
        database.readFromFile();
    }
    public void addTrainer (String trainerId, String name, String email, String specialty, String phoneNumber){
        if(database.contains(trainerId)){
            return;
        }
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(trainer);
    }
    public void removeTrainer (String trainerId){
        database.deleteRecord(trainerId);
    }
    public List<Trainer> getListOfTrainers(){
        return database.returnAllRecords();
    }
    public void deleteTrainer(String key){
        database.deleteRecord(key);
    }
    public void logout(){
        database.saveToFile();
    }

}

