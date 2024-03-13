package assignment8;

import java.util.Arrays;

public class PeoplesArrayList {

    private final int INITIAL_LENGTH = 3;
    private Person[] currentArray;
    private int numOfPeople;

    public PeoplesArrayList(){
        currentArray = new Person[INITIAL_LENGTH];
        numOfPeople = 0;
    }

    public void add(Person p){
        if(p == null)
            return;
        if(numOfPeople == currentArray.length)
            resize();
        currentArray[numOfPeople] = p;
        numOfPeople++;
    }
    public Person get(int i){
        if(i < 0 || i > numOfPeople){
            return null;
        }
        return currentArray[i];
    }

    private void resize() {
        System.out.println("Resizing");
        int len = currentArray.length;
        int newLen = 2 * len;
        Person[] newArray = new Person[newLen];
        System.arraycopy(currentArray,0,newArray,0,len);
        currentArray = newArray;
    }

    public boolean isEmpty(){
        return (numOfPeople ==0);
    }

    public boolean find(String lastName){
        if(lastName == null) return false;
        for(int i = 0; i < numOfPeople; i++){
            if(currentArray[i].getLast().equals(lastName))
                return true;
        }
        return false; //the person is not in the list
    }

    public void insert(Person p, int pos){
        if(p == null) return;
        if(pos > numOfPeople || pos < 0)
            return;
        if(numOfPeople == currentArray.length)
            resize();

        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray,0, temp,0, pos);
        temp[pos] = p;

        System.arraycopy(currentArray, pos, temp, pos+1, currentArray.length-(pos + 1));
        currentArray = temp;
        numOfPeople++;
    }
    public boolean remove(String lastName){
        if(numOfPeople == 0)
            return false; //list is empty
        if(lastName ==null)
            return false;
        int index = -1;
        for (int i =0; i < numOfPeople; i++){
            if(currentArray[i].getLast().equals(lastName)){
                index = i;
                break;
            }
        }
        if(index == -1)
            return false; // p is not found in the list

        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray, 0, temp, 0, index);
        System.arraycopy(currentArray, index +1, temp, index, currentArray.length-(index + 1));
        currentArray = temp;
        numOfPeople--;
        return true;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < numOfPeople-1 ; i++){
            sb.append(currentArray[i] + "\n");
        }
        sb.append(currentArray[numOfPeople-1] + "]");
        return sb.toString();


    }

    public int size(){
        return numOfPeople;
    }
    public Object clone(){
        Person[] temp = Arrays.copyOf(currentArray, numOfPeople);
        return temp;
    }

    public static void main(String[] args) {
        PeoplesArrayList peoplesList = new PeoplesArrayList();
        peoplesList.add(new Person("Aeron", "Doe", 22));
        peoplesList.add(new Person("Bob", "Richard", 23));
        peoplesList.add(new Person("Chris", "Jordan", 24));
        peoplesList.insert(new Person("David", "William", 28), 3);
        System.out.println("Find: "+ peoplesList.find("Jordan"));
        System.out.println("At index 3: "+ peoplesList.get(3));
        System.out.println(peoplesList.toString());
        peoplesList.remove("Chris");
        peoplesList.remove("David");
        System.out.println("======After Removing=====");
        System.out.println(peoplesList.toString());
    }



}
