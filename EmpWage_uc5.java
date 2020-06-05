public class EmpWage_uc5 {
                public static final int IS_PART_TIME = 1;
                public static final int IS_FULL_TIME = 2;
                public static final int EMP_RATE_PER_HOUR = 20;
                public static final int NUM_OF_WORKING_DAYS = 20;

                 public static void main(String[] args) {
                        int empHrs = 0;
                        int EmpWage = 0;
                        int totalEmpWage = 0;

                for ( int day=0; day <  NUM_OF_WORKING_DAYS; day++ ) {
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

                EmpWage = empHrs * EMP_RATE_PER_HOUR;
                totalEmpWage += EmpWage;
                System.out.println("Emp wage : " + EmpWage);
        }
        System.out.println("Total Emp Wage : " + totalEmpWage);
    }
}
