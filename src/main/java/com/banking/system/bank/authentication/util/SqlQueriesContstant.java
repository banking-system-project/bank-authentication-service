package com.banking.system.bank.authentication.util;

public class SqlQueriesContstant {

    public static final String SQL_GET_USER_DETAILS = "SELECT * FROM bank_authentication";

    public static final String SQL_GET_USER_DETAILS_BY_USERNAME_PASSWORD = "select * from bank_authentication where user_id = ?";

    public static final String UPDATE_PASSWORD = "UPDATE bank_authentication SET password = ? , last_update = ? WHERE user_id = ?";
    public static final String EMAIL_UPDATE = "UPDATE bank_authentication SET email = ?, last_update = ? WHERE user_id = ?";
    public static final String PHONE_UPDATE = "UPDATE bank_authentication SET ph_no = ?, last_update = ? WHERE user_id = ?";
}
