package u.com.example.quiz;

public class User {
    public int id;
    public String name;
    public String email,password;
    public int max_score;
    public int get_score(){
        return this.max_score;
    }
    public void setName(String n){
        this.name=n;
    }
    public void setEmail(String e){
        this.email=e;
    }
    public void setPassword(String p){
        this.password=p;
    }
    public void setMax_score(int m){
        this.max_score=m;
    }

    public String getEmail() {
        return this.email;
    }

    public int getMax_score() {
        return this.max_score;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }
}

