package com.linchproject.forms;

import com.linchproject.forms.validators.RequiredValidator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Georg Schmidl
 */
public class FormTest {

    @Test
    public void testBind() throws Exception {
        Form form = new Form()
                .addField("a");

        Map<String, String[]> parameterMap = new HashMap<String, String[]>();
        parameterMap.put("a", new String[] {"b"});

        form.bind(parameterMap);

        assertEquals("b", form.get("a").getValue());
        assertNull(form.get("b"));
    }

    @Test
    public void testValidate() throws Exception {
        Form form = new Form()
                .addField("a", new RequiredValidator());

        form.validate();
        assertFalse(form.isValid());
        assertEquals("required", form.get("a").getError());

        form.put("a", "b");
        form.validate();
        assertTrue(form.isValid());
        assertNull(form.get("a").getError());
    }
}
