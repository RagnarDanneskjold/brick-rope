package com.timmattison.cryptocurrency.bitcoin.words.reservedwords;

import com.timmattison.cryptocurrency.bitcoin.StateMachine;
import com.timmattison.cryptocurrency.bitcoin.Word;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 8/5/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ReservedWordOp implements Word {
    @Override
    public final boolean isEnabled() {
        return true;
    }

    @Override
    public final byte[] build(byte[] data) {
        // Reserved word operations manipulate the stack but do not consume any bytes
        return data;
    }

    @Override
    public Object getOutput() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void execute(StateMachine stateMachine) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public byte[] dump() {
        byte[] dump = new byte[1];
        dump[0] = getOpcode();
        return dump;
    }

    @Override
    public String prettyDump(int indentationLevel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");

        for (int loop = 0; loop < indentationLevel; loop++) {
            stringBuilder.append("\t");
        }

        stringBuilder.append("Opcode value: ");
        stringBuilder.append((int) getOpcode() & 0xFF);
        stringBuilder.append(String.format(", 0x%02x", getOpcode()));
        stringBuilder.append(" [opcode name: ");
        stringBuilder.append(getName());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
