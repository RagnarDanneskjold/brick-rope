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
public class Op1Negate extends ByteConsumingWord {
    private static final String ByteConsumingWord = "OP_1NEGATE";
    private static final int opcode = 0x4f;

    public Op1Negate() {
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
