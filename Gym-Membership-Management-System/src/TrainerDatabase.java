import java.io.*;
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
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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

    public Trainer getRecord(String key) {
        if (!contains(key)) {
            return null;
        }
        for (Trainer trainer : records) {
            String[] trTmp = trainer.toString().split(",");
            String trainerId = trTmp[0];
            if (trainerId.equals(key)) {
                return trainer;
            }
        }
        return null;
    }

    public void insertRecord(Trainer record) {
        if (contains(record.toString().split(",")[0])) {
            System.out.println("record already exists");
        }else {
            records.add(record);
        }
    }

    public void deleteRecord(String key) {
        for (Trainer trainer : records) {
            String[] trTmp = trainer.toString().split(",");
            String trainerId = trTmp[0];
            if (trainerId.equals(key)) {
                records.remove(trainer);
            }
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Trainer trainer : records) {
                writer.write(trainer.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
