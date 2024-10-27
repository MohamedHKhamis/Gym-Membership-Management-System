import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDatabase {
    private String fileName;
    List<Trainer> records;

    public TrainerDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<>();
    }

    public Trainer createRecordFrom(String line) {
        String[] data = line.split(",");
        String trainerId = data[0];
        String name = data[1];
        String email = data[2];
        String specialty = data[3];
        String phoneNumber = data[4];
        return new Trainer(trainerId,name,email,specialty,phoneNumber);
    }
    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Trainers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Trainer trainer = createRecordFrom(line);
                records.add(trainer);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    public List<Trainer> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Trainer trainer : records) {
            String[] tmp = trainer.toString().split(",");
            if (tmp[0].equals(key)) {
                return true;
            }
        }
        return false;
    }


}
