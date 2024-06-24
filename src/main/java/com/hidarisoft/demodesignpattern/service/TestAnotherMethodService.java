package com.hidarisoft.demodesignpattern.service;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import com.hidarisoft.demodesignpattern.factory.AnotherMethodTransactionFactory;
import com.hidarisoft.demodesignpattern.factory.ITransactionService;
import com.hidarisoft.demodesignpattern.model.RequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestAnotherMethodService implements ITransactionService {
    private final AnotherMethodTransactionFactory anotherMethodTransactionFactory;

    @Override
    public Object execute(RequestModel requestModel, TransactionEnum transactionEnum) {
        return anotherMethodTransactionFactory.getStrategy(transactionEnum).execute(requestModel, transactionEnum);
    }

    @Override
    public boolean supports(TransactionEnum transactionEnum) {
        return false;
    }

    @Override
    public TransactionEnum getTransactionEnum() {
        return TransactionEnum.TEST_SEND;
    }
}
