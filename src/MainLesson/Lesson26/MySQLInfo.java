package MainLesson.Lesson26;

public enum MySQLInfo {
    CONNECTION_URL("jdbc:mysql://localhost:3306/"),
    USERNAME("root"),
    PASSWORD("betus040204");

    private String info;

   MySQLInfo(String info){
        this.info = info;
    }

    public String getInfo(){
       return this.info;
    }
}
