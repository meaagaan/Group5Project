package mochi;

import javafx.scene.control.Button;

public class Product {
    public String pid = null;
    public String pname = null;
    public String pgenre = null;
    public String pprice = null;
    public String pusername = null;
    public String pdescription = null;

    public Product() {

    }

    public Product(String pid, String pname, String pgenre, String pdescription, String pprice, String pusername) {
        this.pid = pid;
        this.pname = pname;
        this.pgenre = pgenre;
        this.pprice = pprice;
        this.pusername = pusername;
        this.pdescription = pdescription;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname(){
        return pname;
    }

    public void setPname(String pname){
        this.pname = pname;
    }

    public String getPgenre(){
        return pgenre;
    }

    public void setPgenre(String pgenre){
        this.pgenre = pgenre;
    }

    public String getPprice(){
        return pprice;
    }

    public void setPprice(String pprice){
        this.pprice = pprice;
    }

    public String getPusername() {
        return this.pusername;
    }

    public void setPusername(String pusername) {
        this.pusername = pusername;
    }

    public String getPdescription(){
        return pdescription;
    }

    public void setPdescription(String pdescription){
        this.pdescription = pdescription;
    }
}
