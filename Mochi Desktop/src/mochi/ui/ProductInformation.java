package mochi.ui;

import javafx.scene.control.Button;

public class ProductInformation {

    String name, user, genre, price;
    Button productinfo;

    public ProductInformation(String name, String genre, String price, String user) {
        this.name = name;
        this.user= user;
        this.genre = genre;
        this.price = price;

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user= user;
    }
    public void setProductinfo(Button productinfo){
        this.productinfo= productinfo;
    }
    public Button getProductinfo(){
        return productinfo;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre= genre;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price= price;
    }

}
