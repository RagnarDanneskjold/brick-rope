package com.timmattison.bitcoin.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 4/16/13
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ByteConsumer {
    /**
     * The bytes as they came from the caller.  Nobody is allowed to touch this.
     */
    protected InputStream inputStream;

    /**
     * Whether or not the object should print out debug information.  Default is false.
     */
    private boolean debug = false;

    protected Logger logger;

    public ByteConsumer(Byte[] bytes, boolean debug) throws IOException {
        inputStream = new ByteArrayInputStream(ByteArrayHelper.JavaLangByteArrayToByteArray(bytes));
        this.debug = debug;

        build();
    }

    public ByteConsumer(List<Byte> bytes, boolean debug) throws IOException {
        inputStream = new ByteArrayInputStream(ByteArrayHelper.JavaLangByteListToByteArray(bytes));
        this.debug = debug;

        build();
    }

    public ByteConsumer(InputStream inputStream, boolean debug) throws IOException {
        this.inputStream = inputStream;
        this.debug = debug;

        build();
    }

    public ByteConsumer(InputStream inputStream, boolean debug, Object[] initializationParameters) throws IOException {
        this.inputStream = inputStream;
        this.debug = debug;

        initialize(initializationParameters);
        build();
    }

    public ByteConsumer(Byte[] bytes, boolean debug, Object[] initializationParameters) throws IOException {
        this.inputStream = inputStream;
        this.debug = debug;

        initialize(initializationParameters);
        build();
    }

    protected abstract void initialize(Object[] objects);

    protected boolean isDebug() {
        return debug;
    }

    protected byte[] pullBytes(int count) throws IOException {
        byte[] bytes = new byte[count];
        inputStream.read(bytes, 0, count);

        return bytes;
    }

    private void logBytes(Byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int loop = 0; loop < bytes.length; loop++) {
            stringBuilder.append(String.format("%02x ", bytes[loop]));
        }

        getLogger().info(stringBuilder.toString());
    }

    protected void showDebugInfo() {
        // Is this object set to debug mode?
        if (isDebug()) {
            // Yes, show the debug information
            getLogger().info(debugHeader(getName()));
            innerShowDebugInfo();
        }
    }

    protected abstract String getName();

    private String debugHeader(String name) {
        return "------ " + name;
    }

    /**
     * Print the debug information
     */
    protected abstract void innerShowDebugInfo();

    /**
     * Build the object from the input stream
     */
    protected abstract void build() throws IOException;

    protected Logger getLogger() {
        if(logger == null) {
            logger = Logger.getLogger(getName());
            logger.addHandler(BlockChainTest.handler);
        }

        return logger;
    }
}
