package com.timmattison.cryptocurrency.bitcoin.words.reservedwords;

import com.timmattison.bitcoin.test.script.StateMachine;
import com.timmattison.bitcoin.test.script.Word;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class OpNop7 extends Word {
    private static final String word = "OP_NOP7";
    private static final Byte opcode = (byte) 0xb6;

    public OpNop7() {
        super(word, opcode, false);
    }

    @Override
    public void execute(StateMachine stateMachine) {
        throw new UnsupportedOperationException();
    }
}
