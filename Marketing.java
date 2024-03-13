package assignment8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Marketing {
    private String employeeName;
    private String productName;
    private double salesAmount;

    public Marketing(String employeeName, String productName, double salesAmount){
        this.employeeName = employeeName;
        this.productName = productName;
        this.salesAmount = salesAmount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProductName() {
        return productName;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    @Override
    public String toString(){
        return "[ Marketing EmployeeName: "+ employeeName+ ", ProductName: " +productName +
                ", SalesAmount: "+ salesAmount + "]" + "\n";
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass())return false;
        else{
            Marketing marketing = (Marketing) obj;
            return Objects.equals(employeeName, marketing.employeeName) &&
                     Objects.equals(productName, marketing.productName) &&
                    salesAmount == marketing.salesAmount;
        }
    }
    public void getSize(List<Marketing> list){
        System.out.println("Size of the list: "+ list.size());
    }

    public static void add(List<Marketing> list, Marketing marketing) {
        list.add(marketing);
    }

    public static void remove(List<Marketing> list, Marketing marketing) {
        list.remove(marketing);
    }

    public static List<Marketing> getEmpWithHighSales(List<Marketing> list) {
        List<Marketing> result = new ArrayList<>();
        for (Marketing marketing : list) {
            if (marketing.getSalesAmount() > 1000) {
                result.add(marketing);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Marketing> marketingList = new ArrayList<>();

        // a. add()
        add(marketingList, new Marketing("John", "Iphone", 900.0));
        add(marketingList, new Marketing("Michael", "Mac book", 1400.0));
        add(marketingList, new Marketing("Christine", "Apple watch", 400.0));

        // b. remove() method
        remove(marketingList, new Marketing("John", "Iphone", 900.0));

        // c. Print the size of the list
        System.out.println("Size of the list: " + marketingList.size());

        System.out.println("Contents of the list:");
        System.out.println(marketingList);

        // f. Sort the list in natural order for the field salesAmount using comparator interface
        marketingList.sort(Comparator.comparingDouble(Marketing::getSalesAmount));

        // g. Sort the list in natural order using employee name with the criteria of the employee who achieves more than $1000 of salesamount
        List<Marketing> highSalesList = getEmpWithHighSales(marketingList);
        highSalesList.sort(Comparator.comparing(Marketing::getEmployeeName));

        // Print the sorted list
        System.out.println("Sorted list based on employee sales of more than $1000:");
        System.out.println(highSalesList);

    }

}
