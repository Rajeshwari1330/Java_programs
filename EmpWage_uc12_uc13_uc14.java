IcompanyEmpWage.java
--------------------

public class ICompanyEmpWage {
        public final String company;
        public final int EMP_RATE_PER_HR;
        public final int NUM_OF_WORKING_DAYS;
        public final int MAX_HRS_IN_MONTH;
        public int totalEmpWage;

        public ICompanyEmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                this.company = company;
                this.EMP_RATE_PER_HR = EMP_RATE_PER_HR;
                this.NUM_OF_WORKING_DAYS = NUM_OF_WORKING_DAYS;
                this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
                totalEmpWage = 0;
        }

        public void setTotalEmpWage(int totalEmpWage) {
                this.totalEmpWage = totalEmpWage ;
        }

        @Override
        public String toString() {
                return "Total Employee Wage for  " +company+ "   company is :  " +totalEmpWage;
        }
}


IcomputeEmpWage.java
---------------------

public interface IComputeEmpWage {
        public void AddCompanyEmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH);
        public void Compute_EmpWage();
        public int getTotalWage(String company);
}


EmpWage_uc12_uc13_uc14.java
---------------------------

import java.util.*;

public class EmpWage_uc12_uc13_uc14 implements IComputeEmpWage {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

        private int NumberOfCompany = 0;
        private LinkedList<ICompanyEmpWage> companyEmpWageList;
        private Map<String,ICompanyEmpWage> companyToEmpWageMap;

        public EmpWage_uc12_uc13_uc14() {
                companyEmpWageList = new LinkedList<>();
                companyToEmpWageMap = new HashMap<>();
        }

        public void AddCompanyEmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                ICompanyEmpWage companyEmpWage = new ICompanyEmpWage(company, EMP_RATE_PER_HR, NUM_OF_WORKING_DAYS, MAX_HRS_IN_MONTH);

                companyEmpWageList.add(companyEmpWage);
                companyToEmpWageMap.put(company,companyEmpWage);
        }

public void Compute_EmpWage() {
        for(int i=0; i<companyEmpWageList.size(); i++) {
                ICompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
                companyEmpWage.setTotalEmpWage(this.Compute_EmpWage(companyEmpWage));
                System.out.println(companyEmpWage);
        }
}

@Override
public int getTotalWage(String company) {
        return companyToEmpWageMap.get(company).totalEmpWage;
}

private int  Compute_EmpWage(ICompanyEmpWage companyEmpWage) {
                int empHrs = 0;
                int totalEmpHrs = 0;
                int totalWorkingDays = 0;

                while ( totalEmpHrs <= companyEmpWage.MAX_HRS_IN_MONTH && totalWorkingDays < companyEmpWage.NUM_OF_WORKING_DAYS  ) {
                        totalWorkingDays++;
                        int empCheck = (int) (Math.random() * 10) % 3;

                        switch(empCheck) {
                                case IS_PART_TIME:
                                        empHrs = 4;
                                        break;
                                case IS_FULL_TIME:
                                        empHrs = 8;
                                        break;
                                default:
                                        empHrs = 0;
                        }
                        totalEmpHrs += empHrs;
                        System.out.println("Day : "+totalWorkingDays+ "    Employee Hours : " +empHrs);
                }
                return totalEmpHrs * companyEmpWage.EMP_RATE_PER_HR;
        }

        public static void main(String[] args) {
                IComputeEmpWage empwage = new EmpWage_uc12_uc13_uc14();

                empwage.AddCompanyEmpWage("DMart" , 20, 4,25);
                empwage.AddCompanyEmpWage("V2" , 30, 8, 22);
                empwage.AddCompanyEmpWage("Big Bazar" ,25, 6, 15);
                empwage.AddCompanyEmpWage("Reliance" ,20, 4, 20); 

                empwage.Compute_EmpWage();

                System.out.println("Total wage for Dmart company : " +empwage.getTotalWage("DMart"));
                System.out.println("Total wage for V2 company : " +empwage.getTotalWage("V2"));
                System.out.println("Total wage for Big Bazar company : " +empwage.getTotalWage("Big Bazar"));
                System.out.println("Total wage for Reliance company : " +empwage.getTotalWage("Reliance"));
        }
}
