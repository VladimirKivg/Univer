package edu.lits.maliatko.model;

public class ChildInAGroup {

   private String name;
   private String surname;
   private String dateOfBirdth;
   private int id;

    public ChildInAGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirdth() {
        return dateOfBirdth;
    }

    public void setDateOfBirdth(String dateOfBirdth) {
        this.dateOfBirdth = dateOfBirdth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "СhildInAGroup{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirdth='" + dateOfBirdth + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildInAGroup that = (ChildInAGroup) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        return dateOfBirdth != null ? dateOfBirdth.equals(that.dateOfBirdth) : that.dateOfBirdth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateOfBirdth != null ? dateOfBirdth.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
