import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberDatabase {
    private String filename;
    private List<Member> records;

    public MemberDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    public Member createRecordFrom(String line) {
        String[] data = line.split(",");
        String trainerId = data[0];
        String name = data[1];
        String email = data[2];
        String membershipType = data[3];
        String phoneNumber = data[4];
        String status = data[5];
        return new Member(trainerId,name,email, membershipType,phoneNumber,status);
    }
    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = createRecordFrom(line);
                records.add(member);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    public List<Member> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Member getRecord(String key) {
        if (!contains(key)) {
            return null;
        }
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return member;
            }
        }
        return null;
    }

    public void insertRecord(Member record) {
        if (contains(record.getSearchKey())) {
            //System.out.println("record already exists");
            return;
        }
        records.add(record);
    }

    public void deleteRecord(String key) {
        records.removeIf(member -> member.getSearchKey().equals(key));
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Member member : records) {
                writer.write(member.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
