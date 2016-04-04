

public class Model {
    
    public class information {
        private String MID;
        private String Subject;
        private String User;
        private String Date;
        
        public information(String subject, String user, String date, String mID) {
            this.MID = mID;
            this.Date = date;
            this.Subject = subject;
            this.User = user;
        }
        
        public String getSubject() {
            return this.Subject;
        }
        
        public String getUser() {
            return this.User;
        }
        
        public String getDate() {
            return this.Date;
        }
        
        public String getMID() {
            return this.MID;
        }
    }
    
    public class group {
        private String GName;
        private String GID;
        
        public group(String gName, String gID) {
            this.GName = gName;
            this.GID = gID;
        }
        
        public String nameGet() {
            return this.GName;
        }
        
        public String getID() {
            return this.GID;
        }
    }
    
    public class Setup {
        public String promptUser4ID() {
            return "";
        }
        
        public String sendMessage() {
            return "";
        }
    }
    
}