import java.io.*;
import java.util.*;

class Solution {

    static int getEmployeesUnderMe(String manager, Map<String,Integer> ans, Map<String,List<String>> managerEmpMap) {
        if(managerEmpMap.containsKey(manager)==false) {
            ans.put(manager,0);
            return 1;
        }

        int empUnderMe = 0;
        for(String emp: managerEmpMap.get(manager)) { // [C,E]
            empUnderMe += getEmployeesUnderMe(emp,ans,managerEmpMap);
        }
        ans.put(manager,empUnderMe);
        return empUnderMe+1;
    }

    public void EmpUnderManager(Map<String, String> emp)
    {
        // manager, ArrayList<String> (employees under me)
        Map<String,List<String>> managerEmpMap = new HashMap<>();
        String ceo = "";

        for(String key: emp.keySet()) {
            if(key.equals(emp.get(key))) {
                ceo = key;
            }
            else {
                String manager = emp.get(key);
                if(!managerEmpMap.containsKey(manager)) {
                    managerEmpMap.put(manager,new ArrayList<>());
                }

                List<String> employeesUnderMe = managerEmpMap.get(manager);
                employeesUnderMe.add(key);
                managerEmpMap.put(manager,employeesUnderMe);
            }
        }

        Map<String,Integer> ans = new HashMap<>();
        getEmployeesUnderMe(ceo,ans,managerEmpMap);

        for(String key: ans.keySet()) {
            System.out.println(key + " " + ans.get(key));
        }
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
            emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
    }
}