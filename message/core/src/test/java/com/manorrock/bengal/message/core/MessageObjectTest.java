/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MessageObject class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageObjectTest {
    
    /**
     * Test of getName method, of class MessageObject.
     */
    @Test
    public void testGetName() {
        MessageObject object = new MessageObject();
        object.setName("myobject");
        assertEquals("myobject", object.getName());
    }
}
