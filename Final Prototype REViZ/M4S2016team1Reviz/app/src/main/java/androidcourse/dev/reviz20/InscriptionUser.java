package androidcourse.dev.reviz20;

/**
 * Created by Kobe Kid Bi on 14/08/2016.
 */
public class InscriptionUser {

    private String pseudo;
    private String mail;
    private String pwd;
    private String age;


    public InscriptionUser(String pseudo, String mail, String pwd, String age) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.pwd = pwd;
        this.pwd = age;

    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setPWD(String pwd) {
        this.pwd = pwd;
    }

    public String getPWD() {
        return pwd;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }



}
