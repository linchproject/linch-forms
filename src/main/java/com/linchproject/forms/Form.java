package com.linchproject.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Georg Schmidl
 */
public class Form extends HashMap<String, Values> {

    private Map<String, Field> fields = new HashMap<String, Field>();

    private boolean valid = true;

    private Texter texter;

    public Form() {

    }

    public Form(Texter texter) {
        this.texter = texter;
    }

    public Field addField(String name) {
        Field field = new Field(this);
        fields.put(name, field);
        return field;
    }

    public Field getField(String name) {
        return fields.get(name);
    }

    public Form fill(Map<String, String[]> parameterMap) {
        for (Map.Entry<String, String[]> entry: parameterMap.entrySet()) {
            this.put(entry.getKey(), new Values(entry.getValue()));
        }
        return this;
    }

    public void validate() {
        for (Map.Entry<String, Field> entry : fields.entrySet()) {
            String name = entry.getKey();
            Field field = entry.getValue();

            Values values = get(name);
            if (values == null) {
                values = new Values();
                put(name, values);
            }

            for (Validator validator : field.getValidators()) {
                if (!validator.isValid(values.getAll(), this)) {
                    values.setError(getText(name, validator.getKey()));
                    valid = false;
                    break;
                }
            }
        }
    }

    protected String getText(String fieldName, String validatorKey) {
        if (texter != null) {
            return texter.getText(fieldName, validatorKey);
        }
        return validatorKey;
    }

    public boolean isValid() {
        return valid;
    }
}