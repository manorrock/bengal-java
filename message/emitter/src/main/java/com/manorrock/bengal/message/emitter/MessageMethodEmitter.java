/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.message.emitter;

import com.manorrock.bengal.message.core.MessageMethod;

/**
 * The emitter for MessageMethod.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageMethodEmitter {
    
    /**
     * Emit the Java code.
     * 
     * @param messageMethod the MessageMethod.
     * @return the Java code.
     */
    public String emit(MessageMethod messageMethod) {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("public Object ").append(messageMethod.getName()).append("() {}");
        return javaCode.toString();
    }
}
