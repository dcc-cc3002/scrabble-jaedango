package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static files.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jaedango
 * ScIntTest : Test for ScInt
 */

public class ScIntTest {
    protected ScInt int1;
    protected ScInt int2;
    protected ScInt int3;
    Random r1 = new Random();
    Random r2 = new Random();
    Random r3 = new Random();
    protected final int n1 = r1.nextInt() % 1000;
    protected final int n2 = r2.nextInt() % 1000;
    protected final int n3 = r3.nextInt() % 1000;

    @BeforeEach
    public void setUp() {
        int1 = new ScInt(n1);
        int2 = new ScInt(n2);
        int3 = new ScInt(n3);
    }

    @RepeatedTest(200)
    void constructorTest() {
        var expectedScInt1 = new ScInt(n1);
        var expectedScInt2 = new ScInt(n2);
        var expectedScInt3 = new ScInt(n3);
        assertEquals(expectedScInt1, int1);
        assertEquals(expectedScInt2, int2);
        assertEquals(expectedScInt3, int3);
        assertEquals(expectedScInt1.toString(), int1.toString());
        assertEquals(expectedScInt2.toString(), int2.toString());
        assertEquals(expectedScInt3.toString(), int3.toString());
        assertEquals(expectedScInt1.hashCode(), int1.hashCode(), "Hashes don't match.");
        assertEquals(expectedScInt2.hashCode(), int2.hashCode(), "Hashes don't match.");
        assertEquals(expectedScInt3.hashCode(), int3.hashCode(), "Hashes don't match.");
        if (n1 != n2) {
            assertNotEquals(expectedScInt1, int2);
        }
        if (n2 != n3) {
            assertNotEquals(expectedScInt2, int3);
        }
        if (n3 != n1) {
            assertNotEquals(expectedScInt3, int1);
        }
    }

    @RepeatedTest(200)
    void transformScString() {
        ScString expectedScString1 = new ScString(String.valueOf(n1));
        ScString expectedScString2 = new ScString(String.valueOf(n2));
        ScString expectedScString3 = new ScString(String.valueOf(n3));
        ScString scStr1 = int1.toScString();
        ScString scStr2 = int2.toScString();
        ScString scStr3 = int3.toScString();
        assertEquals(expectedScString1, scStr1);
        assertEquals(expectedScString2, scStr2);
        assertEquals(expectedScString3, scStr3);
        assertEquals(expectedScString1.hashCode(), scStr1.hashCode(), "hashes don't match");
        assertEquals(expectedScString2.hashCode(), scStr2.hashCode(), "hashes don't match");
        assertEquals(expectedScString3.hashCode(), scStr3.hashCode(), "hashes don't match");
        if (n1 != n2) {
            assertNotEquals(expectedScString1, scStr2);
        }
        if (n2 != n3) {
            assertNotEquals(expectedScString2, scStr3);
        }
        if (n3 != n1) {
            assertNotEquals(expectedScString3, scStr1);
        }
    }

    @RepeatedTest(200)
    void transformScFloat() {
        ScFloat expectedScFloat1 = new ScFloat((float) n1);
        ScFloat expectedScFloat2 = new ScFloat((float) n2);
        ScFloat expectedScFloat3 = new ScFloat((float) n3);
        ScFloat scFl1 = int1.toScFloat();
        ScFloat scFl2 = int2.toScFloat();
        ScFloat scFl3 = int3.toScFloat();
        assertEquals(expectedScFloat1, scFl1);
        assertEquals(expectedScFloat2, scFl2);
        assertEquals(expectedScFloat3, scFl3);
        assertEquals(expectedScFloat1.hashCode(), scFl1.hashCode(), "Hashes don't match.");
        assertEquals(expectedScFloat2.hashCode(), scFl2.hashCode(), "Hashes don't match.");
        assertEquals(expectedScFloat3.hashCode(), scFl3.hashCode(), "Hashes don't match.");
        if (n1 != n2) {
            assertNotEquals(expectedScFloat1, scFl2);
        }
        if (n2 != n3) {
            assertNotEquals(expectedScFloat2, scFl3);
        }
        if (n3 != n1) {
            assertNotEquals(expectedScFloat3, scFl1);
        }
    }

    @RepeatedTest(200)
    void transformScBinary() {
        ScBinary expectedScBinary1 = new ScBinary(intToBin(n1));
        ScBinary expectedScBinary2 = new ScBinary(intToBin(n2));
        ScBinary expectedScBinary3 = new ScBinary(intToBin(n3));
        ScBinary bin1 = int1.toScBinary();
        ScBinary bin2 = int2.toScBinary();
        ScBinary bin3 = int3.toScBinary();
        assertEquals(expectedScBinary1, bin1);
        assertEquals(expectedScBinary2, bin2);
        assertEquals(expectedScBinary3, bin3);
        assertEquals(expectedScBinary1.hashCode(), bin1.hashCode(), "Hashes don't match");
        assertEquals(expectedScBinary2.hashCode(), bin2.hashCode(), "Hashes don't match");
        assertEquals(expectedScBinary3.hashCode(), bin3.hashCode(), "Hashes don't match");
        if (n1 != n2) {
            assertNotEquals(expectedScBinary1, bin2);
        }
        if (n2 != n3) {
            assertNotEquals(expectedScBinary2, bin3);
        }
        if (n3 != n1) {
            assertNotEquals(expectedScBinary3, bin1);
        }
    }

    @RepeatedTest(20)
    void addFloatTest() {
        float f1 = r1.nextFloat() + r3.nextFloat();
        float f2 = r2.nextFloat() - r3.nextFloat();
        var float1 = new ScFloat(f1);
        var float2 = new ScFloat(f2);
        float fl1 = (float) n1 + f1;
        float fl2 = (float) n1 + f2;
        float fl3 = (float) n2 + f1;
        float fl4 = (float) n2 + f2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = int1.add(float1);
        ScFloat actual2 = int1.add(float2);
        ScFloat actual3 = int2.add(float1);
        ScFloat actual4 = int2.add(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subFloatTest() {
        float f1 = r1.nextFloat() + r3.nextFloat();
        float f2 = r2.nextFloat() - r3.nextFloat();
        var float1 = new ScFloat(f1);
        var float2 = new ScFloat(f2);
        float fl1 = (float) n1 - f1;
        float fl2 = (float) n1 - f2;
        float fl3 = (float) n2 - f1;
        float fl4 = (float) n2 - f2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = int1.sub(float1);
        ScFloat actual2 = int1.sub(float2);
        ScFloat actual3 = int2.sub(float1);
        ScFloat actual4 = int2.sub(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulFloatTest() {
        float f1 = r1.nextFloat() + r3.nextFloat();
        float f2 = r2.nextFloat() - r3.nextFloat();
        var float1 = new ScFloat(f1);
        var float2 = new ScFloat(f2);
        float fl1 = (float) n1 * f1;
        float fl2 = (float) n1 * f2;
        float fl3 = (float) n2 * f1;
        float fl4 = (float) n2 * f2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = int1.mul(float1);
        ScFloat actual2 = int1.mul(float2);
        ScFloat actual3 = int2.mul(float1);
        ScFloat actual4 = int2.mul(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divFloatTest() {
        float f1 = r1.nextFloat() + r3.nextFloat();
        float f2 = r2.nextFloat() - r3.nextFloat();
        var float1 = new ScFloat(f1);
        var float2 = new ScFloat(f2);
        float fl1 = (float) n1 / f1;
        float fl2 = (float) n1 / f2;
        float fl3 = (float) n2 / f1;
        float fl4 = (float) n2 / f2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = int1.div(float1);
        ScFloat actual2 = int1.div(float2);
        ScFloat actual3 = int2.div(float1);
        ScFloat actual4 = int2.div(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void addIntTest() {
        int exp1 = n1 + n1;
        int exp2 = n1 + n2;
        int exp3 = n2 + n1;
        int exp4 = n2 + n2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.add(int1);
        ScInt actual2 = int1.add(int2);
        ScInt actual3 = int2.add(int1);
        ScInt actual4 = int2.add(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subIntTest() {
        int exp1 = 0;
        int exp2 = n1 - n2;
        int exp3 = n2 - n1;
        int exp4 = n3 - n2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.sub(int1);
        ScInt actual2 = int1.sub(int2);
        ScInt actual3 = int2.sub(int1);
        ScInt actual4 = int3.sub(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulIntTest() {
        int exp1 = n1 * n1;
        int exp2 = n1 * n2;
        int exp3 = n2 * n1;
        int exp4 = n2 * n2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.mul(int1);
        ScInt actual2 = int1.mul(int2);
        ScInt actual3 = int2.mul(int1);
        ScInt actual4 = int2.mul(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divIntTest() {
        int exp1 = 1;
        int exp2 = n1 / n2;
        int exp3 = n2 / n1;
        int exp4 = n3 / n2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.div(int1);
        ScInt actual2 = int1.div(int2);
        ScInt actual3 = int2.div(int1);
        ScInt actual4 = int3.div(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void addBinaryTest() {
        int num1 = n1 + n3;
        int num2 = n1 - n2;
        var bin1 = new ScBinary(intToBin(num1));
        var bin2 = new ScBinary(intToBin(num2));
        int exp1 = n1 + num1;
        int exp2 = n1 + num2;
        int exp3 = n2 + num1;
        int exp4 = n2 + num2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.add(bin1);
        ScInt actual2 = int1.add(bin2);
        ScInt actual3 = int2.add(bin1);
        ScInt actual4 = int2.add(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subBinaryTest() {
        int num1 = n1 + n3;
        int num2 = n1 - n2;
        var bin1 = new ScBinary(intToBin(num1));
        var bin2 = new ScBinary(intToBin(num2));
        int exp1 = n1 - num1;
        int exp2 = n1 - num2;
        int exp3 = n2 - num1;
        int exp4 = n2 - num2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.sub(bin1);
        ScInt actual2 = int1.sub(bin2);
        ScInt actual3 = int2.sub(bin1);
        ScInt actual4 = int2.sub(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulBinaryTest() {
        int num1 = n1 + n3;
        int num2 = n1 - n2;
        var bin1 = new ScBinary(intToBin(num1));
        var bin2 = new ScBinary(intToBin(num2));
        int exp1 = n1 * num1;
        int exp2 = n1 * num2;
        int exp3 = n2 * num1;
        int exp4 = n2 * num2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.mul(bin1);
        ScInt actual2 = int1.mul(bin2);
        ScInt actual3 = int2.mul(bin1);
        ScInt actual4 = int2.mul(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divBinaryTest() {
        int num1 = n1 + n3;
        int num2 = n1 - n2;
        var bin1 = new ScBinary(intToBin(num1));
        var bin2 = new ScBinary(intToBin(num2));
        int exp1 = n1 / num1;
        int exp2 = n1 / num2;
        int exp3 = n2 / num1;
        int exp4 = n2 / num2;
        ScInt expected1 = new ScInt(exp1);
        ScInt expected2 = new ScInt(exp2);
        ScInt expected3 = new ScInt(exp3);
        ScInt expected4 = new ScInt(exp4);
        ScInt actual1 = int1.div(bin1);
        ScInt actual2 = int1.div(bin2);
        ScInt actual3 = int2.div(bin1);
        ScInt actual4 = int2.div(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}
