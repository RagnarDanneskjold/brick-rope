package com.timmattison.bitcoin.test.com.timmattison.bitcoin.test.script.com.timmattison.bitcoin.test.script.words.com.timmattison.bitcoin.test.script.words.constants;

import com.timmattison.bitcoin.test.com.timmattison.bitcoin.test.script.StateMachine;
import com.timmattison.bitcoin.test.com.timmattison.bitcoin.test.script.Word;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Op8 extends Word {
    private static final String word = "OP_8";
    private static final int opcode = 0x58;

    public Op8() {
        super(word, opcode);
    }

    @Override
    public void execute(StateMachine stateMachine) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
