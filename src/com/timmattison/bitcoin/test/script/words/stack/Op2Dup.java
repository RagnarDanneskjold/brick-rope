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
public class Op2Dup extends Word {
    private static final String word = "OP_2DUP";
    private static final Byte opcode = (byte) 0x6e;

    public Op2Dup() {
        super(word, opcode, false);
    }

    @Override
    public void execute(StateMachine stateMachine) {
        throw new UnsupportedOperationException();
    }
}
