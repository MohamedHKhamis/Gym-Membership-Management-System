import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MemberClassRegistrationDatabase {
    private List<MemberClassRegistration> records;
    private String filename;
    public MemberClassRegistrationDatabase(String filename) {
        this.filename = filename;
        records = new ArrayList<>();
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
    public MemberClassRegistration createRecordFrom(String line){
        String[] fields = line.split(",");
        return (new MemberClassRegistration(fields[0], fields[1], fields[3], LocalDate.parse(fields[4])));
    }
    public List<MemberClassRegistration> returnAllRecords() {
        return records;
    }
    public boolean contains(String key){
        Optional<MemberClassRegistration> result = records.stream()
                .filter(record -> record.getSearchKey().equals(key))
                .findFirst();

        return result.isPresent();
    }
    public MemberClassRegistration getRecord(String key){
        Optional<MemberClassRegistration> result = records.stream()
                .filter(record -> record.getSearchKey().equals(key))
                .findFirst();

        return result.orElse(null);
    }
    public void insertRecord (MemberClassRegistration record){
        if(contains(record.getSearchKey()))
            return;
        records.add(record);
    }
    public void deleteRecord (MemberClassRegistration record){
        records.remove(record);
    }
    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (MemberClassRegistration record : records) {
                writer.write(record.lineRepresentation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
