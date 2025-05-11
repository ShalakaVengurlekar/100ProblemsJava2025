package PRA_1_Employee;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections; // if you are using Collections.sort()

public class Ans {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 4;
        ArrayList<Employee> empArr = new ArrayList<Employee>();
        for(int i = 0; i<n; i++){
            Employee e = new Employee();
            e.setEmpId(sc.nextInt());sc.nextLine();
            e.setEmpName(sc.nextLine());
            e.setBranch(sc.nextLine());
            e.setRating(sc.nextDouble());sc.nextLine();
            e.setCompanyTransport(sc.nextBoolean()); sc.nextLine();

            empArr.add(e);
        }
        String s = sc.nextLine();
        int ans1 = findCountOfEmployeesUsingCompTransport( empArr, s);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("No such Employees");
        }
        Employee secondHighest = findEmployeeWithSecondHighestRating(empArr);
        if(secondHighest==null){
            System.out.println("All Employees using company transport");
        }
        else{
            System.out.println(secondHighest.getEmpId());
            System.out.println(secondHighest.getEmpName());

        }

        sc.close();


    }
    static int findCountOfEmployeesUsingCompTransport(ArrayList<Employee> empArr, String s){
        int count = 0;
        for(Employee e: empArr){
            if(e.getBranch().equals(s)){
                if(e.getCompanyTransport()){
                    count+=1;
                }
            }
        }
        return count;
    }
    static Employee findEmployeeWithSecondHighestRating(ArrayList<Employee> empArr) {
        ArrayList <Employee> noBusEmpArr = new ArrayList<Employee>();
        //ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Employee e: empArr){

                if(!e.getCompanyTransport()){
                    noBusEmpArr.add(e);
                   }
        
        }
        if (noBusEmpArr.size() < 2) {
            return null; // Return null if there isn't a second highest rating
        }
        Collections.sort(noBusEmpArr, (e1, e2)->Double.compare(e1.getRating(), e2.getRating()));
        return noBusEmpArr.get(noBusEmpArr.size()-2);
    }
}

class Employee{
    private int empId;
    private String empName;
    private String branch;
    private double rating;
    private Boolean CompanyTransport;

    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public Boolean getCompanyTransport() {
        return CompanyTransport;
    }
    public void setCompanyTransport(Boolean companyTransport) {
        CompanyTransport = companyTransport;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
}
