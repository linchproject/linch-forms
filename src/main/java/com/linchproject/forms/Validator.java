package com.linchproject.forms;

/**
 * @author Georg Schmidl
 */
public interface Validator {

    public String getKey();

    public boolean isValid(String[] values, Form form);
}
