package sa.course.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@NamedQueries({@NamedQuery(name = Course.FIND_ALL, query = "SELECT u FROM Course u")})
public class Course {

    public static final String FIND_ALL = "Course.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private String lastName;
    private String cabin;
    private String creditCard;


    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

    public String getLastName(){
      return lastName;
    }
    public void setLastName(String lastName){
      this.lastName = lastName;
    }

    public String getCabin(){
      return cabin;
    }
    public void setCabin(String cabin){
      this.cabin = cabin;
    }

    public String getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


}
