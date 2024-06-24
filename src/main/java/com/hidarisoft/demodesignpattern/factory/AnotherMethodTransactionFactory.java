package com.hidarisoft.demodesignpattern.factory;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Set;

@Component
public class AnotherMethodTransactionFactory {
    private EnumMap<TransactionEnum, ITransactionService> strategies;

    @Autowired
    public AnotherMethodTransactionFactory(Set<ITransactionService> strategySet) {
        createStrategy(strategySet);
    }

    private void createStrategy(Set<ITransactionService> strategySet) {
        strategies = new EnumMap<>(TransactionEnum.class);
        strategySet.forEach(strategy -> strategies.put(strategy.getTransactionEnum(), strategy));
    }

    public ITransactionService getStrategy(TransactionEnum transactionEnum) {
        return strategies.get(transactionEnum);
    }
}
