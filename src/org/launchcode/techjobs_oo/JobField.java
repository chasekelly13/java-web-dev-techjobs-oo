package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    //Consider the following questions to help you decide what code to put in the JobField class:
        //What fields do ALL FOUR of the classes have in common?
            //fields: id, nextId, value
        //Which constructors are the same in ALL FOUR classes?
            //blank constructor? and value
        //What getters and setters do ALL of the classes share?
            //getters: id, and value      setters: value
        //Which custom methods are identical in ALL of the classes?
            //methods: toString and equals

    //In JobField, declare each of the common fields.
    private int id;
    private static int nextId = 1;
    private String value;

    //Code the constructors.
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value){
        this();
        this.value = value;
    }

    //Use Generate to create the appropriate getters and setters.

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    //Add in the custom methods.

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Finally, to prevent the creation of a JobField object, make this class abstract.
}
