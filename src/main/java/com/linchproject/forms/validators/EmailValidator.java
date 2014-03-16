package com.linchproject.forms.validators;

import com.linchproject.forms.Form;
import com.linchproject.forms.Validator;

/**
 * @author Georg Schmidl
 */
public class EmailValidator implements Validator {

    @Override
    public String getKey() {
        return "email";
    }

    @Override
    public boolean isValid(String[] values, Form form) {
        for (String value : values) {
            if (!value.contains("@")) {
                return false;
            }
        }
        return true;
    }
}
