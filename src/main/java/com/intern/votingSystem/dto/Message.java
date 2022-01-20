package com.intern.votingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    String errorCode;
    String errorMessage;

    public static String setMessage(String errorCode, String errorMessage){
        return errorCode+ " "+ errorMessage;
    }
}
