package com.example.board.dto.response;

public interface ResponseCode {
    // 200
    String SUCCESS = "SU";

    // 400
    String VALIDATIONFAILED = "VF";
    String THISBOARDDOESNOTEXIST = "NB";
    String DUPLICATEDNICKNAME = "DN";
    String DUPLICATEDEMAIL = "DE";
    String DUPLICATEDTELEPHONENUMBER = "DT";

    // 401
    String LOGININFORMATIONMISMATCH = "SF";
    String THISUSERDOESNOTEXIST = "NU";
    String AUTHORIZATIONFAILED = "AF";


    // 403
    String DONOTHAVEPERMISSION = "NP";


    // 500
    String DATABASEERROR = "DBE";
    
}
