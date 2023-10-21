import javax.swing.text.View;
import java.util.List;

public class Client {
    private String surname;
    private String name;
    private String mail;
    private String phone_number;

    public Client(String surname, String name, String mail, String phone_number) {
        this.surname = surname;
        this.name = name;
        this.mail = mail;
        this.phone_number = phone_number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Client {" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}