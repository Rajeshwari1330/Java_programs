public class EmpWage_uc2 {
	public static void main(String[] args) {
                int IS_FULL_TIME = 1;
                int EMP_RATE_PER_HOUR = 20;

                int empHrs = 0;
                int EmpWage = 0;

                int empCheck = (int) (Math.random() * 10) % 2;
                if (( empCheck == IS_FULL_TIME ))
                        empHrs = 8;
                EmpWage = empHrs * EMP_RATE_PER_HOUR;
                System.out.println("Emp wage : " + EmpWage);
        }
}
