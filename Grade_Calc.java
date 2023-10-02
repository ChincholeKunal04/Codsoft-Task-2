import java.util.*;

public class Grade_Calc{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("\n\t\t\t!!! Welcome To Grade Calculator!!!");
        
        System.out.print("Enter Name of Student: ");
        String std_name = sc.nextLine();
        System.out.println();
        
        System.out.print("Enter Roll Number of Student: ");
        int roll_Num = sc.nextInt();
        System.out.println();
        
        System.out.print("Enter Number of subjects: ");
        int sub_Num = sc.nextInt();
        
        std_Info student = new std_Info(std_name, sub_Num, roll_Num);
        
        for(int i=1; i<=sub_Num; i++){
            System.out.print("\nEnter marks of "+i+" Subject: ");
            int marks = sc.nextInt();
            student.set_Marks(i, marks);
        }
        
        System.out.println();
        
        System.out.println("\n******************** !!! RESULT !!! ********************");
        System.out.println();
        System.out.println("\tStudent Name: "+student.Std_Name());
        
        System.out.println("\tStudent Roll Number: "+student.Roll_Num());
        
        System.out.println("\tTotal Marks Obtained: "+student.total_Marks());
        
        System.out.println("\tTotal Average Percentage: "+student.avg_Percent());
        
        System.out.println("\tObtained Grade: "+student.grade_Make());
        System.out.println();
        System.out.println("********************************************************");
        sc.close();
    }
}

class std_Info{
    private String std_Name;
    private int sub_Num;
    private int roll_Num;
    private int[] marks;

    public std_Info(String std_name, int sub_Num, int roll_Num){
        this.std_Name = std_name;
        this.sub_Num = sub_Num;
        this.roll_Num = roll_Num;
        this.marks = new int[sub_Num];
    }

    public String Std_Name(){
        return std_Name;
    }

    public int Roll_Num(){
        return roll_Num;
    }

    public void set_Marks(int sub_Number, int marks){
        this.marks[sub_Number - 1] = marks;
    }

    public int total_Marks(){
        int total = 0;
        for(int mark : marks){
            total += mark;
        }
        return total;
    }

    public float avg_Percent(){
        return (float)total_Marks()/(sub_Num*100) * 100;
    }

    public String grade_Make(){
        double percent = avg_Percent();

        if(percent > 93){
            return "A+";
        }
        else if(percent <=93 && percent > 87){
            return "A";
        }
        else if(percent <=87 && percent > 80){
            return "B+";
        }
        else if(percent <= 80 && percent > 74){
            return "B";
        }
        else if(percent <= 74 && percent > 66){
            return "C+";
        }
        else if(percent <= 66 && percent > 57){
            return "C";
        }
        else if(percent <= 57 && percent > 48){
            return "D+";
        }
        else if(percent <= 48 && percent >= 40){
            return "D";
        }
        else{
            return "F";
        }
    }
}