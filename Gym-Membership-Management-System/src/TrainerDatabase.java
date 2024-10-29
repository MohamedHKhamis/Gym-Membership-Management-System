import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDatabase extends Database <Trainer>{

    public TrainerDatabase(String fileName) {
        super(fileName);
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
}
