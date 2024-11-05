package Backend;
import Inferance.FileNames;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TrainerRole {
    private MemberClassRegistrationDatabase registrationDatabase;
    private ClassDatabase classDatabase;
    private MemberDatabase memberDatabase;
    public TrainerRole() {
        registrationDatabase = new MemberClassRegistrationDatabase(FileNames.REGISTRATION_FILENAME);
        classDatabase = new ClassDatabase(FileNames.CLASS_FILENAME);
        memberDatabase = new MemberDatabase(FileNames.MEMBER_FILENAME);
        registrationDatabase.readFromFile();
        classDatabase.readFromFile();
        memberDatabase.readFromFile();
    }
    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status){
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(member);
    }
    public List<Member> getListOfMembers(){
        return memberDatabase.returnAllRecords();
    }
    public void addClass (String classID, String className, String trainerID, int duration, int maxParticipants){
        Class newClass = new Class(classID, className, trainerID, duration, maxParticipants);
        if (classDatabase.contains(classID))
            return;
        classDatabase.insertRecord(newClass);
    }
    public List<Class> getListOfClasses(){
        return classDatabase.returnAllRecords();
    }
    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate)
    {   Class c = classDatabase.getRecord(classID);
        if(c == null)
            return false;
        if(c.getAvailableSeats()==0)
            return false;
        if (memberDatabase.getRecord(memberID) == null)
            return false;
        if (registrationDatabase.contains(memberID+"+"+classID)){
            registrationDatabase.deleteRecord(memberID+"+"+classID);
        }
        MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active",registrationDate);
        registrationDatabase.insertRecord(registration);
        c.setAvailableSeats(c.getAvailableSeats() - 1);
        return true;
    }
    public boolean cancelRegistration (String memberID, String classID){
        Class c = classDatabase.getRecord(classID);
        if(c == null)
            return false;
        if (memberDatabase.getRecord(memberID) == null)
            return false;
        MemberClassRegistration registration = registrationDatabase.getRecord(memberID+"+"+classID);
        if(registration == null)
            return false;
        LocalDate registrationDate = registration.getRegistrationDate();
        long days = ChronoUnit.DAYS.between(registrationDate, LocalDate.now());
        if (days > 3)
            return false;
        registration.setRegistrationStatus("cancelled");
        c.setAvailableSeats(c.getAvailableSeats() + 1);
        return true;
    }
    public List<MemberClassRegistration> getListOfRegistrations(){
        return registrationDatabase.returnAllRecords();
    }
    public void logout(){
        registrationDatabase.saveToFile();
        classDatabase.saveToFile();
        memberDatabase.saveToFile();
    }

}
