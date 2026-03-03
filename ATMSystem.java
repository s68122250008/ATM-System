
class MyTestException extends RuntimeException {
    private int errorCode;

    public MyTestException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

public class ATMSystem {

    public static void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new MyTestException("Insufficient balance", 2001);
        } else {
            System.out.println("Withdraw successful: " + (balance - amount));
        }
    }

    public static void main(String[] args) {
        double myBalance = 500.0;
        double withdrawAmount = 600.0;

        try {
            System.out.println("Checking balance: " + myBalance);
            System.out.println("Attempting to withdraw: " + withdrawAmount);
            withdraw(myBalance, withdrawAmount);
        } catch (MyTestException e) {
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
        }
    }
}