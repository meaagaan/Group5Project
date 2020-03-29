package mochi;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReviewUserDetail {
    private final StringProperty rating;
    private final StringProperty user;
    private final StringProperty review;

    public ReviewUserDetail(String rating, String user, String review) {
        this.rating = new SimpleStringProperty(rating);
        this.user = new SimpleStringProperty(user);
        this.review = new SimpleStringProperty(review);
    }

    // Getters
    public String getRating() {
        return rating.get();
    }

    public String getUser() {
        return user.get();
    }

    public String getReview() {
        return review.get();
    }

    // Setters
    public void setRating(String value) {
        rating.set(value);
    }

    public void setUser(String value) {
        user.set(value);
    }

    public void setReview(String value) {
        review.set(value);
    }

    // Property Values
    public StringProperty ratingProperty() {
        return rating;
    }

    public StringProperty userProperty() {
        return user;
    }

    public StringProperty reviewProperty() {
        return review;
    }
}
