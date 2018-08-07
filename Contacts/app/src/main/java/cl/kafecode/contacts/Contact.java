package cl.kafecode.contacts;

import java.io.Serializable;

public class Contact implements Serializable{

    private String mName;
    private String mSurname;
    private String mAddress1;
    private String mAddress2;
    private String mZipCode;

    public Contact(String mName, String mSurname, String mAddress1, String mAddress2, String mZipCode) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mAddress1 = mAddress1;
        this.mAddress2 = mAddress2;
        this.mZipCode = mZipCode;
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public String getAddress1() {
        return mAddress1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public String getZipCode() {
        return mZipCode;
    }
}
