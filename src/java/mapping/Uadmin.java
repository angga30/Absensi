package mapping;
// Generated Aug 15, 2018 9:34:27 AM by Hibernate Tools 4.3.1



/**
 * Uadmin generated by hbm2java
 */
public class Uadmin  implements java.io.Serializable {


     private Integer id;
     private String uname;
     private String pass;

    public Uadmin() {
    }

    public Uadmin(String uname, String pass) {
       this.uname = uname;
       this.pass = pass;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }




}


