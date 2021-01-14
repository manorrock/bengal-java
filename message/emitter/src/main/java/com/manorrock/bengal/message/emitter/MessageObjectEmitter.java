/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.emitter;

import com.manorrock.bengal.message.core.MessageObject;

/**
 * The emitter for MessageObject.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageObjectEmitter {
    
    /**
     * Emit the Java code.
     * 
     * @param messageObject the MessageObject.
     * @return the Java code.
     */
    public String emit(MessageObject messageObject) {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("public class ").append(messageObject.getName()).append(" {}");
        return javaCode.toString();
    }
}
