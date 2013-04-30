package com.timmattison.bitcoin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/11/13
 * Time: 8:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class BlockChainTest {
    private static final boolean debug = false;
    private static final boolean innerDebug = false;

    public static Handler getHandler() throws IOException {
        Handler handler = new FileHandler("test.log");
        handler.setFormatter(new SimpleFormatter());

        return handler;
    }

    public static void main(String[] args) throws Exception {
        // Did they specify a filename (and only one filename)?
        if ((args == null) || (args.length != 1)) {
            // No, tell them that they need to specify a file
            System.out.println("A filename containing block data must be specified");
            return;
        }

        // Open the input file
        File inputFile = new File(args[0]);

        // Get a file input stream for this input file
        InputStream inputStream = new FileInputStream(inputFile);

        // Instantiate the block chain object
        BlockChain blockChain = new BlockChain(inputStream, debug, innerDebug);

        try {
            // Build the block chain
            blockChain.build();

            // Show the debug info for the entire block chain
            blockChain.showDebugInfo();
        } catch (Exception ex) {
            // There was an exception, log the block number that it happened in
            System.out.println("Exception in block #" + (BlockChain.blockNumber - 1));
            throw (ex);
        }
    }
}
