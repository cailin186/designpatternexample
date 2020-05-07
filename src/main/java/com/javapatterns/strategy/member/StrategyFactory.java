package com.javapatterns.strategy.member;


import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private static Map<String, MemberStrategy> strategyMap = new HashMap();
    static{
        strategyMap.put("primary",new PrimaryMemberStrategy());
        strategyMap.put("adv",new AdvMemberStrategy());
    }
    public static MemberStrategy getInstance(String type){
        return strategyMap.get(type);
    }

}
