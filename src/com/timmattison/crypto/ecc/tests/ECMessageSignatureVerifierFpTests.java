package com.timmattison.crypto.ecc.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.timmattison.crypto.ecc.interfaces.ECCKeyPair;
import com.timmattison.crypto.ecc.interfaces.ECCMessageSigner;
import com.timmattison.crypto.ecc.interfaces.ECCPoint;
import com.timmattison.crypto.ecc.interfaces.ECCSignature;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 8/23/13
 * Time: 7:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class ECMessageSignatureVerifierFpTests {
    static Injector injector = Guice.createInjector(new ECCTestModule());

    private static final BigInteger gec2_2_1_3_r = new BigInteger("1176954224688105769566774212902092897866168635793");
    private static final BigInteger gec2_2_1_3_s = new BigInteger("299742580584132926933316745664091704165278518100");
    private static final BigInteger gec2_2_1_3_dU = new BigInteger("971761939728640320549601132085879836204587084162");
    private static final byte[] gec2_2_1_3_messageBytes = "abc".getBytes();
    private static final ECCKeyPair gec2_eccKeyPair = ECCTestHelper.getKeyPair(injector, ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_dU);
    private static final ECCPoint gec2_2_1_4_Qu = gec2_eccKeyPair.getQ();

    /**
     * GEC2 2.1.4 - Verifying operation for V
     */
    @Test
    public void testGec2_2_1_4() {
        Assert.assertTrue(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, gec2_2_1_3_r, gec2_2_1_3_s));
    }

    @Test
    public void testRIsZeroReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, BigInteger.ZERO, gec2_2_1_3_s));
    }

    @Test
    public void testSIsZeroReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, gec2_2_1_3_r, BigInteger.ZERO));
    }

    @Test
    public void testRIsEqualToNReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, ECCTestHelper.getSecp160r1(injector).getN(), gec2_2_1_3_s));
    }

    @Test
    public void testSIsEqualToNReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, gec2_2_1_3_r, ECCTestHelper.getSecp160r1(injector).getN()));
    }

    @Test
    public void testRIsGreaterThanNReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, ECCTestHelper.getSecp160r1(injector).getN().add(BigInteger.ONE), gec2_2_1_3_s));
    }

    @Test
    public void testSIsGreaterThanNReturnsFalse() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu, gec2_2_1_3_r, ECCTestHelper.getSecp160r1(injector).getN().add(BigInteger.ONE)));
    }

    @Test
    public void testFailsWithInvalidSignature() {
        Assert.assertFalse(ECCTestHelper.getSignatureVerifier(injector).signatureValid(ECCTestHelper.getSecp160r1(injector), gec2_2_1_3_messageBytes, gec2_2_1_4_Qu.twice(), gec2_2_1_3_r, gec2_2_1_3_s));
    }
}
