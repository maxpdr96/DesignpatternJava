package com.hidarisoft.demodesignpattern.factory;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import com.hidarisoft.demodesignpattern.model.RequestModel;

public interface ITransactionService {
    Object execute(RequestModel requestModel, TransactionEnum transactionEnum);

    boolean supports(TransactionEnum transactionEnum);

    TransactionEnum getTransactionEnum();
}
