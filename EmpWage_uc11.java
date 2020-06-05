CompanyEmpWage.java
--------------------

public class CompanyEmpWage {
        public final String company;
        public final int EMP_RATE_PER_HR;
        public final int NUM_OF_WORKING_DAYS;
        public final int MAX_HRS_IN_MONTH;
        public int totalEmpWage;

        public CompanyEmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                this.company = company;
                this.EMP_RATE_PER_HR = EMP_RATE_PER_HR;
                this.NUM_OF_WORKING_DAYS = NUM_OF_WORKING_DAYS;
                this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
        }

        public void setTotalEmpWage(int totalEmpWage) {
                this.totalEmpWage = totalEmpWage ;
        }

        @Override
        public String toString() {
                return "Total Employee Wage for  " +company+ "   company is :  " +totalEmpWage;
        }
}

EmpWage_uc11.java
------------------

public class EmpWage_uc11 {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

        private int NumberOfCompany = 0;
        private CompanyEmpWage[] CompanyEmpWageArray;

        public EmpWage_uc11() {
                CompanyEmpWageArray = new CompanyEmpWage[5];
        }

        private void AddCompanyEmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                CompanyEmpWageArray[NumberOfCompany] = new CompanyEmpWage(company, EMP_RATE_PER_HR, NUM_OF_WORKING_DAYS, MAX_HRS_IN_MONTH);
                NumberOfCompany++;
        }

        private void Compute_EmpWage() {
                for (int i=0; i<NumberOfCompany; i++) {
                        CompanyEmpWageArray[i].setTotalEmpWage(this.Compute_EmpWage(CompanyEmpWageArray[i]));
                        System.out.println(CompanyEmpWageArray[i]);
                }
        }

        private int  Compute_EmpWage(CompanyEmpWage companyEmpWage) {
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
                EmpWage_uc11 empwage = new EmpWage_uc11();

                empwage.AddCompanyEmpWage("DMart" , 20, 4, 25);
                empwage.AddCompanyEmpWage("V2" , 30, 8, 22);
                empwage.AddCompanyEmpWage("Big Bazar" , 25, 6, 15);
                empwage.AddCompanyEmpWage("Reliance" , 20, 4, 20);

                empwage.Compute_EmpWage();
        }
}
