package com.banking.system.bank.authentication.util;

public class SqlQueriesContstant {

    public static final String SQL_GET_USER_DETAILS = "SELECT * FROM BANK_AUTHENTICATION";

    public static final String SQL_GET_USER_DETAILS_BY_USERNAME_PASSWORD = "SELECT * FROM BANK_AUTHENTICATION WHERE USER_ID = ?";

    public static final String UPDATE_PASSWORD = "UPDATE BANK_AUTHENTICATION SET PASSWORD = ? , LAST_UPDATE = ? WHERE USER_ID = ?";
    public static final String EMAIL_UPDATE = "UPDATE BANK_AUTHENTICATION SET EMAIL = ?, LAST_UPDATE = ? WHERE USER_ID = ?";
    public static final String PHONE_UPDATE = "UPDATE BANK_AUTHENTICATION SET PH_NO = ?, LAST_UPDATE = ? WHERE USER_ID = ?";
}
