package com.linchproject.forms.validators;

import com.linchproject.forms.Form;
import com.linchproject.forms.Validator;

import java.util.Arrays;

/**
 * @author Georg Schmidl
 */
public class EqualsValidator implements Validator {

    String otherFieldName;

    public EqualsValidator(String otherFieldName) {
        this.otherFieldName = otherFieldName;
    }

    @Override
    public String getKey() {
        return "equals";
    }

    @Override
    public boolean isValid(String[] values, Form form) {
        String[] otherValues = form.get(otherFieldName) != null ? form.get(otherFieldName).getAll() : null;
        return Arrays.equals(values, otherValues);
    }
}
