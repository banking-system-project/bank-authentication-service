package com.banking.system.bank.authentication.util;

public class SqlQueriesContstant {

    public static final String SQL_GET_USER_DETAILS = "SELECT * FROM BANK_AUTHENTICATION";

    public static final String SQL_GET_USER_DETAILS_BY_USERNAME_PASSWORD = "SELECT * FROM BANK_AUTHENTICATION WHERE USER_ID = ?";
}
