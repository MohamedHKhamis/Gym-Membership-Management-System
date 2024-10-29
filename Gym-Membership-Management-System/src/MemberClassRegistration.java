import java.time.LocalDate;

public class MemberClassRegistration implements UseMethods {
    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;
    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public String getSearchKey() {
        return memberID+classID;
    }
    public void setRegistrationStatus(String status) {
        if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("cancelled")) {
            this.status = status.toLowerCase();
        }
    }
    public String lineRepresentation() {
        return memberID+","+classID+","+registrationDate.toString()+","+status+"\n";
    }
}
