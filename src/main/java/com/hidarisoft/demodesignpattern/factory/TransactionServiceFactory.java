package com.hidarisoft.demodesignpattern.factory;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class TransactionServiceFactory {
    private final Map<TransactionEnum, ITransactionService> serviceMap = new EnumMap<>(TransactionEnum.class);

    public TransactionServiceFactory(List<ITransactionService> transactionServices) {
        for (ITransactionService transactionService : transactionServices) {
            for (TransactionEnum transactionEnum : TransactionEnum.values()) {
                if (transactionService.supports(transactionEnum)) {
                    serviceMap.put(transactionEnum, transactionService);
                }
            }
        }
    }

    public ITransactionService getTransactionService(TransactionEnum transactionEnum) {
        ITransactionService service = serviceMap.get(transactionEnum);
        if (service == null) {
            throw new RuntimeException("No transaction service found for " + transactionEnum);
        }

        return service;
    }
}
