/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.emitter;

import com.manorrock.bengal.message.core.MessageMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MessageMethodEmitter class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageMethodEmitterTest {
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit() {
        MessageMethod object = new MessageMethod();
        object.setName("mymethod");
        MessageMethodEmitter emitter = new MessageMethodEmitter();
        assertEquals("public Object mymethod() {}", emitter.emit(object));
    }
}
