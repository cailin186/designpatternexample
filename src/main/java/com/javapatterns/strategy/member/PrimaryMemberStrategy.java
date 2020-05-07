package com.javapatterns.strategy.member;


public class PrimaryMemberStrategy implements MemberStrategy {

    public double calcPrice(double booksPrice) {

        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }

}
