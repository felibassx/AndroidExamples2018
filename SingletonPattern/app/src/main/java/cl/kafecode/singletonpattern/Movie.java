package cl.kafecode.singletonpattern;

public class Movie {

    private String mTitle;
    private boolean mOnRental;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean isOnRental() {
        return mOnRental;
    }

    public void setOnRental(boolean mOnRental) {
        this.mOnRental = mOnRental;
    }
}
