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
            String[] tmp = member.toString().split(",");
            if (tmp[0].equals(key)) {
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
            String[] trTmp = member.toString().split(",");
            String trainerId = trTmp[0];
            if (trainerId.equals(key)) {
                return member;
            }
        }
        return null;
    }

    public void insertRecord(Member record) {
        if (contains(record.toString().split(",")[0])) {
            System.out.println("record already exists");
        }else {
            records.add(record);
        }
    }

    public void deleteRecord(String key) {
        for (Member member : records) {
            String[] trTmp = member.toString().split(",");
            String trainerId = trTmp[0];
            if (trainerId.equals(key)) {
                records.remove(member);
            }
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Member member : records) {
                writer.write(member.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }

}
