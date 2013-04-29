package com.timmattison.bitcoin.test.script.words.stack;

import com.timmattison.bitcoin.test.script.StateMachine;
import com.timmattison.bitcoin.test.script.Word;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class OpDup extends Word {
    private static final String word = "OP_DUP";
    private static final Byte opcode = (byte) 0x76;

    public OpDup() {
        super(word, opcode, true);
    }

    @Override
    public void execute(StateMachine stateMachine) {
        // Duplicate the top element on the stack
        stateMachine.stack.push(stateMachine.stack.peek());
    }
}
