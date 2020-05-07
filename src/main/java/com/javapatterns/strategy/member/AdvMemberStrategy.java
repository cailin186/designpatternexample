package com.javapatterns.strategy.member;


public class AdvMemberStrategy implements MemberStrategy {

    public double calcPrice(double booksPrice) {

        System.out.println("对于高级会员有折扣");
        return booksPrice * 0.3;
    }

}
