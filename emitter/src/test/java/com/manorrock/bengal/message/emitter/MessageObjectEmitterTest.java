/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.emitter;

import com.manorrock.bengal.message.core.MessageObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MessageObjectEmitter class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageObjectEmitterTest {
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit() {
        MessageObject object = new MessageObject();
        object.setName("myobject");
        MessageObjectEmitter emitter = new MessageObjectEmitter();
        assertEquals("public class myobject {}", emitter.emit(object));
    }
}
