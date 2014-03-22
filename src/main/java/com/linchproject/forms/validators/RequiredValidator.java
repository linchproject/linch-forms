package com.linchproject.forms.validators;

import com.linchproject.forms.Form;
import com.linchproject.forms.Validator;

/**
 * @author Georg Schmidl
 */
public class RequiredValidator implements Validator {

    @Override
    public String getErrorKey() {
        return "required";
    }

    @Override
    public boolean isValid(String[] values, Form form) {
        return !((values == null || values.length <= 0 || "".equals(values[0])));
    }
}
