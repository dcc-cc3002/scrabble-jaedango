package files.operands;

import files.types.ScBoolean;
import files.types.ScType;
import files.types.numbers.ScBinary;

/**
 * @author jaedango
 */

public interface Logical extends ScType {
    Logical and(Logical conjunct);

    Logical or(Logical conjunct);

    Logical andBool(ScBoolean operand);

    Logical orBool(ScBoolean operand);

    Logical andBinary(ScBinary operand);

    Logical orBinary(ScBinary operand);
}
