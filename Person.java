package assignment8;

public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLast(){
        return lastName;
    }
    @Override
    public String toString(){
        return "Person [lastName = "+lastName+ "\n FirstName= "+firstName+ "\nAge="+ age + "]";
    }
}
