import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MemberClassRegistrationDatabase extends Database <MemberClassRegistration>{


    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }
    public MemberClassRegistration createRecordFrom(String line){
        String[] fields = line.split(",");
        return (new MemberClassRegistration(fields[0], fields[1], fields[3], LocalDate.parse(fields[4])));
    }
}
