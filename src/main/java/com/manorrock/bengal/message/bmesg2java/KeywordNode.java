package com.manorrock.bengal.message.bmesg2java;

/**
 * A keyword node.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class KeywordNode implements Node {

    /**
     * Stores the keyword.
     * 
     * @param keyword the keyword.
     */
    private String keyword;

    /**
     * Constructor.
     * 
     * @param keyword the keyword.
     */
    public KeywordNode(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Get the keyword.
     * 
     * @return the keyword.
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * toString.
     * 
     * @return the string representation.
     */
    public String toString() {
        return keyword;
    }
}
