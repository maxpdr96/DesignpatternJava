package com.hidarisoft.demodesignpattern.enums;

public enum TransactionEnum {
    TEST_SEND,
    TEST_RECEIVE;

    public static TransactionEnum validTransactionEnum(String value) {
        for (TransactionEnum transactionEnum : TransactionEnum.values()) {
            if (transactionEnum.toString().equalsIgnoreCase(value)) {
                return transactionEnum;
            }
        }
        return null;
    }
}
