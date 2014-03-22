package com.linchproject.forms;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Georg Schmidl
 */
public class Values implements Iterable<String> {

    private String[] values;

    private String error;

    public Values() {
    }

    public Values(String[] values) {
        this.values = values;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(values).iterator();
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getValue() {
        return values != null &&  values.length > 0 ? values[0] : null;
    }

    public String[] getValues() {
        return values;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
