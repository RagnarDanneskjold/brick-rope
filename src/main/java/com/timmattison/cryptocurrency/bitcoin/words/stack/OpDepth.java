package com.timmattison.cryptocurrency.bitcoin.words.stack;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class OpDepth extends StackOp {
    private static final String word = "OP_DEPTH";
    private static final Byte opcode = (byte) 0x74;

    @Override
    public void execute(com.timmattison.cryptocurrency.bitcoin.StateMachine stateMachine) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Byte getOpcode() {
        return opcode;
    }

    @Override
    public String getName() {
        return word;
    }
}
