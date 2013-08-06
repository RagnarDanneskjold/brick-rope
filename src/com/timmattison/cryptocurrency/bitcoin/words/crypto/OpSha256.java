package com.timmattison.cryptocurrency.bitcoin.words.crypto;

import com.timmattison.bitcoin.test.script.Constants;
import com.timmattison.cryptocurrency.bitcoin.StateMachine;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 11:57 AM
 * <p/>
 * Hashes the value on the top of the stack with SHA-256
 */
public class OpSha256 extends CryptoOp {
    private static final String algorithm = Constants.SHA256_ALGORITHM;
    private static final String word = "OP_SHA256";
    private static final Byte opcode = (byte) 0xa8;

    @Override
    public void execute(StateMachine stateMachine) {
        Object value = stateMachine.pop();

        if(!(value instanceof byte[])) {
            throw new UnsupportedOperationException("Only byte arrays can be hashed");
        }

        byte[] byteArrayValue = (byte[]) value;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            stateMachine.push(messageDigest.digest(byteArrayValue));
        } catch (NoSuchAlgorithmException e) {
            throw new UnsupportedOperationException(e);
        }
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
