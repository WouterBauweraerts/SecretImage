package com.cegeka.secretImage.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wouterba on 20/02/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PineAppleNotFoundException extends RuntimeException {
    public PineAppleNotFoundException(String msg) {
        super(msg);
    }
}
