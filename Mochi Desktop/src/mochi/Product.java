package mochi;

import javafx.scene.control.Button;

public class Product {
    public  static String pname = null;
    public static String pgenre = null;
    public  static String pprice = null;
    public  static String pdescription = null;
    public static String getPname(){
        return pname;
    }
    public  void setPname(String pname){
        this.pname= pname;
    }
    public static String getPgenre(){
        return pgenre;
    }
    public void setPgenre(String pgenre){
        this.pgenre= pgenre;
    }
    public static String getPprice(){
        return pprice;
    }
    public void setPprice(String pprice){
        this.pprice= pprice;
    }
    public static String getPdescription(){
        return pdescription;
    }
    public void setPdescription(String pdescription){
        this.pdescription= pdescription;
    }
}
