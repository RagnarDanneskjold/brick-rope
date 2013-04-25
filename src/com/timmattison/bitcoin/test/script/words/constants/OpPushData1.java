package com.timmattison.bitcoin.test.script.words.constants;

import com.timmattison.bitcoin.test.ByteArrayHelper;
import com.timmattison.bitcoin.test.script.ByteConsumingWord;
import com.timmattison.bitcoin.test.script.StateMachine;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class OpPushData1 extends ByteConsumingWord {
    private static final String word = "OP_PUSHDATA1";
    private static final Byte opcode = (byte) 0x4c;

    public OpPushData1() {
        super(word, opcode);
    }

    @Override
    protected void doAdditionalProcessing(ByteArrayInputStream input) {
        validateFirstStageInput();

        // Our input now represents the number of bytes we are going to read
        int bytesToRead = input.read();
        int inputSize = input.available();

        validateBytesToRead(bytesToRead, inputSize);

        // Get the bytes we need
        this.input = new byte[bytesToRead];
        input.read(this.input, 0, bytesToRead);
    }

    @Override
    protected boolean isAdditionalProcessingRequired() {
        return true;
    }

    @Override
    public int getInputBytesRequired() {
        return 1;
    }

    @Override
    public void execute(StateMachine stateMachine) {
        throw new UnsupportedOperationException();
    }
}
