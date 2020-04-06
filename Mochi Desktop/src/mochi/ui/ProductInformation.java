package mochi.ui;

import javafx.scene.control.Button;

public class ProductInformation {

    String id, name, user, genre, productinfo, price;

    public ProductInformation(String id, String name, String genre, String productinfo, String price, String user) {
        this.id = id;
        this.name = name;
        this.user= user;
        this.genre = genre;
        this.productinfo = productinfo;
        this.price = price;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setProductinfo(String productinfo){
        this.productinfo = productinfo;
    }

    public String getProductinfo(){
        return productinfo;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

}
