package profile.one2one.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import profile.one2one.model.createprofile;



@Entity
@Table(name = "login")
public class User {
 
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
 
    @Column(name = "user_id")
    private String userId;
 
    @Column(name = "password")
    private String passWord;
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "createprofile_Id")
    private createprofile createprofile;
 
    public User() {
 
    }
 
    public User(String userId, String passWord)
    {
        super();
        this.userId = userId;
        this.passWord = passWord;
    }
 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId =userId;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public createprofile getcreateprofile() {
        return createprofile;
    }
 
    public void setcreateprofile(createprofile createprofile) {
        this.createprofile= createprofile;
    }

	
}

