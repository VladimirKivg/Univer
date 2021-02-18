package edu.lits.maliatko.model;

import javax.validation.constraints.NotBlank;

public class Group {
   private Integer id;
   @NotBlank(message = "огогог тут помилка") // @NotBlank(message = "огогог тут помилка") - це робить перевырку
   private String name;
   private Integer number;

   public Group() {
   }

   @Override
   public String toString() {
      return "Group{" +
              "name='" + name + '\'' +
              ", number=" + number +
              ", id=" + id +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Group group = (Group) o;

      if (name != null ? !name.equals(group.name) : group.name != null) return false;
      if (number != null ? !number.equals(group.number) : group.number != null) return false;
      return id != null ? id.equals(group.id) : group.id == null;
   }

   @Override
   public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + (number != null ? number.hashCode() : 0);
      result = 31 * result + (id != null ? id.hashCode() : 0);
      return result;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getNumber() {
      return number;
   }

   public void setNumber(Integer number) {
      this.number = number;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
