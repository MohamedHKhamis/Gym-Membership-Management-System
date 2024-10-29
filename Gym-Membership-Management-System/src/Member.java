public class Member     {
        private String memberID;
        private String name;
        private String email;
        private String membershipType;
        private String phoneNumber;
        private String status;

    public Member(String memberID, String name, String email, String membershipType, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }


        public String lineRepresentation (){
            return String.join(", ", memberID, name, email, membershipType, phoneNumber,status);
        }

        public String getSearchKey(){
            return memberID;
        }

}
