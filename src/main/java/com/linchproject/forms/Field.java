package com.linchproject.forms;

import java.util.Arrays;
import java.util.List;

/**
 * @author Georg Schmidl
 */
public class Field {

    private Form form;

    private List<Validator> validators;

    public Field(Form form, Validator... validators) {
        this.form = form;
        this.validators = Arrays.asList(validators);
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public Form form() {
        return form;
    }
}
