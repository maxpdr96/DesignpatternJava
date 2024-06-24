package com.hidarisoft.demodesignpattern.service;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import com.hidarisoft.demodesignpattern.factory.ITransactionService;
import com.hidarisoft.demodesignpattern.factory.TransactionServiceFactory;
import com.hidarisoft.demodesignpattern.model.RequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TestService implements ITransactionService {

    private static final Set<TransactionEnum> SUPPORT_TYPES = Set.of(TransactionEnum.TEST_RECEIVE);

    private final TransactionServiceFactory transactionServiceFactory;

    public void testService(String enumTest) {

    }

    @Override
    public Object execute(RequestModel requestModel, TransactionEnum transactionEnum) {
        TransactionEnum validTransactionEnum = TransactionEnum.validTransactionEnum(String.valueOf(transactionEnum));

        transactionServiceFactory.getTransactionService(validTransactionEnum).execute(new RequestModel(), validTransactionEnum);
        return null;
    }

    @Override
    public boolean supports(TransactionEnum transactionEnum) {
        return SUPPORT_TYPES.contains(transactionEnum);
    }

    @Override
    public TransactionEnum getTransactionEnum() {
        return TransactionEnum.TEST_RECEIVE;
    }
}
