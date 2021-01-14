/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MessageMethod class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageMethodTest {
    
    /**
     * Test getName method.
     */
    @Test
    public void testGetName() {
        MessageObject object = new MessageObject();
        object.setName("myobject");
        assertEquals("myobject", object.getName());
    }
}
