package com.bucom.security.exception;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserNullException extends RuntimeException implements Serializable {
    private String id;

    public  UserNullException(String id){
        super("null user");
        this.id=id;
    }

}
