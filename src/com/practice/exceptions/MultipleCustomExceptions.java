package com.practice.exceptions;

class LowBalanceException extends WithdrawalException {  //1
    public LowBalanceException(String msg){ super(msg);    }
}

class WithdrawalException extends Exception { //2
    public WithdrawalException(String msg){ super(msg);    }
}

public class MultipleCustomExceptions {
    double balance;

    // only exceptions that can come out of this method are
    // WithdrawalExceptions (which means WithdrawalException or its subclasses) or RuntimeExceptions.
    // LowBalanceException must extend WithdrawalException
    public void withdraw(double amount) throws WithdrawalException{
        try{
            throw new RuntimeException("Not Implemented"); // **2**
        }catch(Exception e){
            throw new LowBalanceException(e.getMessage()); // **3**
        }
    }

    public static void main(String[] args) {
        try{
            MultipleCustomExceptions a = new MultipleCustomExceptions();
            a.withdraw(100.0); // **1**
        }catch(Exception e){
            // WithdrawalException can extend either Exception or RuntimeException.
            System.out.println(e.getMessage());
            // Prints Not Implemented
        }
    }
}
