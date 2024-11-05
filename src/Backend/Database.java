package Backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

abstract class Database<T extends UseMethods> {
    private List<T> records;
    private String filename;
    public Database(String filename) {
        this.filename = filename;
        records = new ArrayList<>();
    }
    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                records.add(createRecordFrom(line));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            try (FileWriter writer = new FileWriter(filename)) {

            } catch (IOException n) {
                n.printStackTrace();
            }
        }
    }
    public abstract T createRecordFrom(String line);
    public List<T> returnAllRecords() {
        return records;
    }
    public boolean contains(String key){
        Optional<T> result = records.stream().filter(record -> record.getSearchKey().equals(key)).findFirst();
        return result.isPresent();
    }
    public T getRecord(String key){
        Optional<T> result = records.stream()
                .filter(record -> record.getSearchKey().equals(key))
                .findFirst();

        return result.orElse(null);
    }
    public void insertRecord (T record){
        if(contains(record.getSearchKey())){
            return;}
        records.add(record);
    }
    public void deleteRecord (String key){
        records.removeIf(trainer -> trainer.getSearchKey().equals(key));
    }
    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (T record : records) {
                writer.write(record.lineRepresentation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
