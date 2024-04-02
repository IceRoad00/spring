package com.example.board.dto.response;

public interface ResponseMessage {
    // 200
    String SUCCESS = "Success.";

    // 400
    String VALIDATIONFAILED = "Validation failed.";
    String THISBOARDDOESNOTEXIST = "This board does not exist.";
    String DUPLICATEDNICKNAME = "Duplicated nickname.";
    String DUPLICATEDEMAIL = "Duplicated email.";
    String DUPLICATEDTELEPHONENUMBER = "Duplicated telephone number.";
    
    // 401
    String LOGININFORMATIONMISMATCH = "Login Information mismatch.";
    String THISUSERDOESNOTEXIST = "This user does not exist.";
    String AUTHORIZATIONFAILED = "Authorization Failed.";

    // 403
    String DONOTHAVEPERMISSION = "Do not have permission.";

    // 500
    String DATABASEERROR = "Database eroor.";
}