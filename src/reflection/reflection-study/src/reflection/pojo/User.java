package reflection.pojo;

public class User {
    private int id;
    private String name;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String say(int i, String string){
        for(int k = 0; k<i;k++){
            System.out.println(string);
        }
        return "i am ok";
    }
}
