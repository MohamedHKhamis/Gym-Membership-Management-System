import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClassDatabase {
    private List<Class> records;
    private String filename;
    public ClassDatabase(String filename) {
        this.filename = filename;
        records = new ArrayList<Class>();
    }
    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                records.add(createRecordFrom(line));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
    public Class createRecordFrom(String line){
        String[] fields = line.split(",");
        return (new Class(fields[0], fields[1], fields[2],
                Integer.parseInt(fields[3]), Integer.parseInt(fields[4])));
    }
    public List<Class> returnAllRecords() {
        return records;
    }
    public boolean contains(String key){
        Optional<Class> result = records.stream()
                .filter(record -> record.getSearchKey().equals(key))
                .findFirst();

        return result.isPresent();
    }
    public Class getRecord(String key){
        Optional<Class> result = records.stream()
                .filter(record -> record.getSearchKey().equals(key))
                .findFirst();

        return result.orElse(null);
    }
    public void insertRecord (Class record){
        if(contains(record.getSearchKey()))
            return;
        records.add(record);
    }
    public void deleteRecord (Class record){
        records.remove(record);
    }
    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Class record : records) {
                writer.write(record.lineRepresentation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

