package validation;

import java.util.ArrayList;


public class ValidationUtilities {

    static ArrayList<String> positionList= new ArrayList<>();
    static ArrayList<String> departmentList= new ArrayList<>();



    public static void initialize(){
        positionList.add("Manager");
        positionList.add("Director");
        positionList.add("Assistant");

        departmentList.add("Mechanical");
        departmentList.add("Civil");
        departmentList.add("IT");
        departmentList.add("Finance");
        departmentList.add("Marketing");
    }


    public static boolean validatename(String name) {
        boolean flag=true;
        String firstLetter = name.substring(0,1);
        String firstLetterupperCase =firstLetter.toUpperCase();
        String newName = firstLetterupperCase + name.substring(1);
        for (int i = 0; i < newName.length(); i++) {
                if (Character.isLetter(newName.charAt(i)) || Character.isSpaceChar(newName.charAt(i))) {
                } else {
                    flag=false;
                }
            }
            return flag;

    }

    public static boolean validateposition(String position) {
        return positionList.contains(position);
    }
    public static boolean validatedepartment(String department){
        return departmentList.contains(department);

    }

    public static boolean validatecontact(String contact){
             boolean flag=true;
             if(contact.length()==10){
                for(int i=0;i<contact.length();i++){
                    if(Character.isDigit(contact.charAt(i))){

                    }else{
                        flag=false;
                    }
                }
            }else{
                return false;
            }
    return flag;
    }

}
