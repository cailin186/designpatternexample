package com.javapatterns.templatemethod.InterestRate;

public class Client
{
   public static Account acct = null;


    public static void main(String[] args)
    {

        System.out.println("edddd");
    	acct = new MoneyMarketAccount();
        System.out.println("Interest earned from Money Market account = " + acct.calculateInterest());

    	acct = new CDAccount();
        System.out.println("Interest earned from CD account = " + acct.calculateInterest());


        System.out.println("到底能不能自动编译11111222");



    }
}
