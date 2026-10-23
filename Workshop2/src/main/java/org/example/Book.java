package org.example;

public class Book {
//PROPS
    private int id;
    private String isBn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    //CONSTRUCTOR
    public Book(int id, String isBn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isBn = isBn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
    //GETTERS & SETTERS

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsBn() {
        return isBn;
    }
    public void setIsBn(String isBn) {
        this.isBn = isBn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }


    //METHODS

    public void checkOut(String newName) {
        this.checkedOutTo = newName;
        this.isCheckedOut = true;
    }

    public void checkIn() {
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }




}
