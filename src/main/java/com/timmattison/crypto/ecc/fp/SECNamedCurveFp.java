package com.timmattison.crypto.ecc.fp;

import com.timmattison.crypto.ecc.interfaces.*;

import javax.inject.Inject;
import java.math.BigInteger;

// This code is based off of the Javascript implementation found here - http://www-cs-students.stanford.edu/~tjw/jsbn/

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 5/20/13
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SECNamedCurveFp implements ECCNamedCurveFp {
    private ECCCurveFactory eccCurveFactory;
    private ECCParametersFactory eccParametersFactory;

    public SECNamedCurveFp() {
    }

    @Inject
    public SECNamedCurveFp(ECCCurveFactory eccCurveFactory, ECCParametersFactory eccParametersFactory) {
        this.eccCurveFactory = eccCurveFactory;
        this.eccParametersFactory = eccParametersFactory;
    }

    public BigInteger fromHex(String s) {
        return new BigInteger(s, 16);
    }

    public ECCParameters getSecp128r1() {
        // p = 2^128 - 2^97 - 1
        BigInteger p = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
        BigInteger a = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC");
        BigInteger b = fromHex("E87579C11079F43DD824993C2CEE5ED3");
        //byte[] S = Hex.decode("000E0D4D696E6768756151750CC03A4473D03679");
        BigInteger n = fromHex("FFFFFFFE0000000075A30D1B9038A115");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "161FF7528B899B2D0C28607CA52C5B86"
                + "CF5AC8395BAFEB13C02DA292DDED7A83");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp160k1() {
        // p = 2^160 - 2^32 - 2^14 - 2^12 - 2^9 - 2^8 - 2^7 - 2^3 - 2^2 - 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
        BigInteger a = BigInteger.ZERO;
        BigInteger b = fromHex("7");
        //byte[] S = null;
        BigInteger n = fromHex("0100000000000000000001B8FA16DFAB9ACA16B6B3");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "3B4C382CE37AA192A4019E763036F4F5DD4D7EBB"
                + "938CF935318FDCED6BC28286531733C3F03C4FEE");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp160r1() {
        // p = 2^160 - 2^31 - 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF");
        BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC");
        BigInteger b = fromHex("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45");
        //byte[] S = Hex.decode("1053CDE42C14D696E67687561517533BF3F83345");
        BigInteger n = fromHex("0100000000000000000001F4C8F927AED3CA752257");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "4A96B5688EF573284664698968C38BB913CBFC82"
                + "23A628553168947D59DCC912042351377AC5FB32");
        return eccParametersFactory.create(curve, G, n, h);
    }

   public ECCParameters getSecp192k1() {
        // p = 2^192 - 2^32 - 2^12 - 2^8 - 2^7 - 2^6 - 2^3 - 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
        BigInteger a = BigInteger.ZERO;
        BigInteger b = fromHex("3");
        //byte[] S = null;
        BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D"
                + "9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp192r1() {
        // p = 2^192 - 2^64 - 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF");
        BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC");
        BigInteger b = fromHex("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1");
        //byte[] S = Hex.decode("3045AE6FC8422F64ED579528D38120EAE12196D5");
        BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF1012"
                + "07192B95FFC8DA78631011ED6B24CDD573F977A11E794811");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp224r1() {
        // p = 2^224 - 2^96 + 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001");
        BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE");
        BigInteger b = fromHex("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4");
        //byte[] S = Hex.decode("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
        BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21"
                + "BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp256r1() {
        // p = 2^224 (2^32 - 1) + 2^192 + 2^96 - 1
        BigInteger p = fromHex("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF");
        BigInteger a = fromHex("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC");
        BigInteger b = fromHex("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B");
        //byte[] S = Hex.decode("C49D360886E704936A6678E1139D26B7819F7E90");
        BigInteger n = fromHex("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296"
                + "4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5");
        return eccParametersFactory.create(curve, G, n, h);
    }

    public ECCParameters getSecp256k1() {
        // p = 2^256 - 2^32 - 2^9 - 2^8 - 2^7 - 2^6 - 2^4 - 1
        BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
        BigInteger a = fromHex("0000000000000000000000000000000000000000000000000000000000000000");
        BigInteger b = fromHex("0000000000000000000000000000000000000000000000000000000000000007");
        BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
        BigInteger h = BigInteger.ONE;
        ECCCurve curve = eccCurveFactory.create(p, n, a, b);
        ECCPoint G = curve.decodePointHex("04"
                + "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8");
        return eccParametersFactory.create(curve, G, n, h);
    }
}
