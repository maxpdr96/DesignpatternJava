package com.hidarisoft.demodesignpattern.model;

import com.hidarisoft.demodesignpattern.enums.TransactionEnum;
import lombok.Data;

@Data
public class RequestModel {
    private String name;
    private String cpf;
    private TransactionEnum transactionEnum;
}
