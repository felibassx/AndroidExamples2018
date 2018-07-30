package cl.kafecode.listviewexample;

public class Contact {

    public Contact(int mId, String mNameContact, String mNumberContact, String mEmailContact) {
        this.mId = mId;
        this.mNameContact = mNameContact;
        this.mNumberContact = mNumberContact;
        this.mEmailContact = mEmailContact;
    }

    private int mId;
    private String mNameContact;
    private String mNumberContact;
    private String mEmailContact;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNameContact() {
        return mNameContact;
    }

    public void setmNameContact(String mNameContact) {
        this.mNameContact = mNameContact;
    }

    public String getmNumberContact() {
        return mNumberContact;
    }

    public void setmNumberContact(String mNumberContact) {
        this.mNumberContact = mNumberContact;
    }

    public String getmEmailContact() {
        return mEmailContact;
    }

    public void setmEmailContact(String mEmailContact) {
        this.mEmailContact = mEmailContact;
    }
}
