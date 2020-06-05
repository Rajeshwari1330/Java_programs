public class EmpWage_uc9 {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

        private final String company;
        private final int EMP_RATE_PER_HR;
        private final int NUM_OF_WORKING_DAYS; 
        private final int MAX_HRS_IN_MONTH;
        private int totalEmpWage;

        public EmpWage_uc9(String company, int EMP_RATE_PER_HR, int NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH) {
                this.company = company;
                this.EMP_RATE_PER_HR = EMP_RATE_PER_HR;
                this.NUM_OF_WORKING_DAYS = NUM_OF_WORKING_DAYS;
                this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
        }

        public void Compute_EmpWage() {
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
                totalEmpWage = totalEmpHrs * EMP_RATE_PER_HR;
        }

        @Override
        public String toString() {
                return "Total Employee Wage for  " +company+ "   company is :  " +totalEmpWage;
        }

        public static void main(String[] args) {
                EmpWage_uc9 Dmart = new EmpWage_uc9("DMart" , 20, 4, 25);
                EmpWage_uc9 v2 = new EmpWage_uc9("V2" , 30, 8, 22);
                EmpWage_uc9 bigBazar = new EmpWage_uc9("Big Bazar" , 25, 6, 15);
                EmpWage_uc9 reliance = new EmpWage_uc9("Reliance" , 20, 4, 20);

                Dmart.Compute_EmpWage();
                v2.Compute_EmpWage();
                bigBazar.Compute_EmpWage();
                reliance.Compute_EmpWage();

                System.out.println(Dmart);
                System.out.println(v2);
                System.out.println(bigBazar);
                System.out.println(reliance);
        }
}
