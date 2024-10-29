import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberDatabase extends Database <Member>{

    public MemberDatabase(String filename) {
        super(filename);
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


}
