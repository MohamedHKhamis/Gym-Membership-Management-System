package Backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClassDatabase extends Database<Class> {

    public ClassDatabase(String filename) {
        super(filename);
    }
    public Class createRecordFrom(String line){
        String[] fields = line.split(",");
        return (new Class(fields[0], fields[1], fields[2],
                Integer.parseInt(fields[3]), Integer.parseInt(fields[4])));
    }
}

