package com.company.lesson4DZ;

public class oneNote {
    private String lastname;
    private Integer number;

    oneNote(String _lastname, Integer _number) {
        this.lastname = _lastname;
        this.number = _number;
    }

    public void setLastname(String _lastname) {
        this.lastname = _lastname;
    }
    public void setNumber(Integer _number) {
        this.number = _number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getLastname() {
        return lastname;
    }
}
