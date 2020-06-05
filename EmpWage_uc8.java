public class EmpWage_uc8 {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

        public static int Compute_EmpWage(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                int empHrs = 0;
                int totalEmpHrs = 0;
                int totalWorkingDays = 0;

                while ( totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS  ) {
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

                int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HR;
                System.out.println("  Total Employee Wage for  " +company+ "   company is :" +totalEmpWage);
                return totalEmpWage;
        }

        public static void main(String[] args) {
                Compute_EmpWage("DMart" , 20, 4, 25);
                Compute_EmpWage("V2" , 30, 8, 22);
                Compute_EmpWage("Big Bazar" , 25, 6, 15);
                Compute_EmpWage("Reliance" , 20, 4, 20);
        }
}
