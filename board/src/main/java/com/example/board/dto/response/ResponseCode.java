package com.example.board.dto.response;

public interface ResponseCode {
    String SUCCESS = "SU";
    String VALIDATION_FAIL = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_BOARD = "NB";
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";
    String NO_PERMISSION = "NP";
    String DATABASE_ERROR = "DBE";

}
