package com.timmattison.bitcoin.test.script.ByteConsumingWords.constants;

import com.timmattison.bitcoin.test.script.StateMachine;
import com.timmattison.bitcoin.test.script.ByteConsumingWord;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Op13 extends ByteConsumingWord {
    private static final String ByteConsumingWord = "OP_13";
    private static final int opcode = 0x5D;

    public Op13() {
        super(ByteConsumingWord, opcode);
    }

    @Override
    public int getInputBytesRequired() {
        return 0;
    }

    @Override
    public void execute(StateMachine stateMachine) {
        throw new UnsupportedOperationException();
    }
}
