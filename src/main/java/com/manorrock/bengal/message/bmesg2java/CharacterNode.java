package com.manorrock.bengal.message.bmesg2java;

/**
 * A node representing a single character.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class CharacterNode implements Node {
    
    /**
     * Stores the character.
     */
    private char character;

    /**
     * Constructor.
     */
    public CharacterNode(char character) {
        this.character = character;
    }
    
    /**
     * toString.
     */
    public String toString() {
        return Character.toString(character);
    }
}
