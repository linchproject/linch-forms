package com.linchproject.forms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georg Schmidl
 */
public class Field {

    private Form form;

    private List<Validator> validators = new ArrayList<Validator>();

    public Field(Form form) {
        this.form = form;
    }

    public Field addValidator(Validator validator) {
        this.validators.add(validator);
        return this;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public Field addField(String name) {
        return form.addField(name);
    }

    public Form form() {
        return form;
    }
}
