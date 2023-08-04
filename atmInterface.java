import java.util.Scanner;

public class atmInterface {
    static float balance;
    static float depo;
    static float d;
    static float wd;
    static float w;
    static float amount;
    static float a;
    public static class A {
        Scanner sc = new Scanner(System.in);
        void deposit() {
            System.out.print("Enter the amount you want to deposit:");
            depo = sc.nextFloat();
            System.out.println(depo +" Rs Deposited Successfully!!!");
            balance+=depo;
            d+=depo;
        }
    }
    public static class B {
        Scanner sc = new Scanner(System.in);
        void withdraw() {
            System.out.print("Enter the amount you want to withdraw:");
            wd = sc.nextFloat();
            if (wd<=balance) {
                System.out.println(wd+" Rs Withdraw Successfully!!!");
                balance-=wd;
                w+=wd;
            }
            else{
                System.out.println("Insuffiecient balance!!!");
            }

        }
    }

    public static class C {
        void balance() {
            float bal = balance;
            System.out.print("Your Account Balance is : " + bal);
            System.out.println();
        }
    }
    public static class D {
        void history() { 
            System.out.println("You deposite\t" + d +"\tRs");
            System.out.println("You withdraw\t" + w + "\tRs");
            System.out.println("You transfer\t"+a+"\tRs");
        }
    }

    public static class E {
        Scanner sc = new Scanner(System.in);
        void transfer() {
            int num1, num2;
            System.out.println("Enter your Account Number:");
            num1 = sc.nextInt();
            System.out.println("Enter the Account Number Of the Receiver:");
            num2 = sc.nextInt();
            System.out.println("Enter the amount to be transferred:");
            amount = sc.nextFloat();
            if (amount <= balance) {
                System.out.println(amount + " Rs is SUCCESSFULLY TRANSFERRED from account " + num1 + " to " + num2);
                balance-=amount;
                a=a+amount;
            } else {
                System.out.println("INSUFFICIENT BALANCE!!!!");
            }
        }
    }

    public static class login {
        Scanner sc = new Scanner(System.in);
        void register() {
            A a = new A();
            B b = new B();
            C c = new C();
            D d = new D();
            E e = new E();
            String userId;
            int pin;
            boolean flag = false;
            System.out.println("************************\nWELCOME TO ATM INTERFACE\n************************");
            System.out.print("Enter User Id: ");
            userId = sc.next();
            System.out.print("Enter 4 digit User Pin: ");
            pin = sc.nextInt();
            int count = String.valueOf(pin).length();
            if (count == 4) {
                System.out.println("---------Logged In Successfully!!!! -----------");
                System.out.println("**************************************");
                System.out.println("WELCOME " + userId + " To ATM System");
                System.out.println("***************************************");
                flag = true;
            } else {
                System.out.println("---------Invalid Pin!!!! -------------");
            }
            while (flag) {
                flag = false;
                System.out.println("------Menu------");
                System.out.println("Select Option:");
                System.out.print("Press 1 for DEPOSIT\nPress 2 to WITHDRAW\nPress 3 to check TRANSACTION HISTORY\nPress 4 for TRANSFER\nPress 5 to check BALANCE\nPress 6 to QUIT\n");
                System.out.println("Enter your Choice:");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        a.deposit();
                        break;
                    case 2:
                        b.withdraw();
                        break;
                    case 3:
                        d.history();
                        break;
                    case 4:
                        e.transfer();
                        break;
                    case 5:
                        c.balance();
                        break;
                    case 6:
                    System.out.println("-----------------Thank You For Using Atm-------------------");
                    return;
                }
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        login l = new login();
        l.register();
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}
