import java.util.*;
public class numberGuessingGame {
    public static void pattern(){
        int l=5;
        int b=25;
        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                if(i==0 ||j==0 ||i==(l-1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                if(i==1 && j==7 ){
                    System.out.print("NUMBER");
                }
                if(i==2 && j==6){
                    System.out.print("GUESSING");
                }
                if(i==3 && j==8){
                    System.out.print("GAME");
                }
                    if(i==1 && j==(b-8)){
                        System.out.print("*");
                    }
                    if(i==2 && j==(b-10)){
                        System.out.print("*");
                    }
                    if(i==3 && j==(b-6)){
                        System.out.print("*");
                    }
            }
             System.out.println();
        }
    }
    public static void game(){
           Scanner sc=new Scanner(System.in);
           int t=10;
           int count=1;
           int min=1;
           int max=100;
           int maxpoints;
           int mpoints;
           int rn=(int)(Math.random()*(max-min+1)+min); 
           System.out.println("Number should be between 1 to 100\n\n----Round 1 starts----\nYou will get only 10 chances to guess the number\n");
           for(int i=t;i>=1;i--){
               System.out.println("Enter num:");
               int num=sc.nextInt();
               if(num<rn){
                  System.out.println("Guess number greater than"+" "+num);
                }
                else if(num>rn){
                  System.out.println("Guess number less than"+" "+num);
                }
                else if(num==rn){
                   System.out.println("Congrats!!!! You Guessed it right");
                   break;
                }
                count++;
            }
               int points=110-(count*10);
               System.out.println("Round 1 points are:"+points);
               if(points==0){
                   System.out.println("OOPS!!! BETTER LUCK NEXT TIME");
                }
                System.out.println();
                if(points>0){
                    System.out.println("----Round 2 Starts----\nIn Round 2 You will get only 5 chance\n");
                    int c=1;
                    int r=(int)(Math.random()*(max-min+1)+min); 
                    for(int i=5;i>=1;i--){
                        System.out.println("Enter num:");
                        int num=sc.nextInt();
                        if(num<r){
                           System.out.println("Guess number greater than"+" "+num);
                        }
                        else if(num>r){
                           System.out.println("Guess number less than"+" "+num);
                        }
                        else if(num==r){
                           System.out.println("Congrats!!!! You Guessed it right");
                           break;
                        }
                        c++;
                    }
                        maxpoints=(60-(c*10));
                        System.out.println("Round 2 points are:"+maxpoints);
                        System.out.println();
                        if(maxpoints>0){
                            System.out.println("----Round 3 starts----\nYou will get only 3 chance\n");
                            int co=1;
                            int rnum=(int)(Math.random()*(max-min+1)+min);
                            for(int i=3;i>=1;i--){
                                System.out.println("Enter num:");
                                int num=sc.nextInt();
                                if(num<rnum){
                                    System.out.println("Guess number less than"+" "+num);
                                }
                                else if(num>rnum){
                                    System.out.println("Guess number greater than"+" "+num);
                                }
                                else if(num==rnum){
                                    System.out.println("Congrats!!!! You Guessed it right");
                                    break;
                                }
                                co++;
                            }
                            mpoints=(40-(co*10));
                            System.out.println("Round 3 points are:"+mpoints);
                            System.out.println();
                        
                        int total=maxpoints+points+mpoints;
                        System.out.println("Your total points are:"+total);
                        System.out.println();
                        System.out.println("****Game Ends****");
                    }
                }
                 sc.close();
                }
    public static void main(String[] args){
        pattern();
        System.out.print("\n");
        System.out.println("\tWELCOME!!!");
        System.out.println("****Game Starts****");
        game();
        System.out.println("Thanks For Playing!!!!!");
  }
}
