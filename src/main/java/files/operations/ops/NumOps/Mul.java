package files.operations.ops.NumOps;

import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.constant.ConstantNum;
import files.operations.ops.Operations;
import files.types.numbers.ScNumber;

import java.util.Objects;

/**
 * @author jaedango
 */

public class Mul extends NumOps{
    Constant val1;
    Constant val2;

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    public Mul(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Mul(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2.eval();
    }

    public Mul(Operations val1, Constant val2) {
        this.val1 = val1.eval();
        this.val2 = val2;
    }

    public Mul(Operations val1, Operations val2) {
        this.val1 = val1.eval();
        this.val2 = val2.eval();
    }

/*
    /**
     * Methods Override to print and assert equals

    @Override
    public int hashCode() {
        return Objects.hash(Mul.class, this.val1, this.val2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mul) {
            var other = (Mul) obj;
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " * " + val2.toString() + ")";
    }
*/
    /**
     * Eval expression value
     * @return new Constant number
     */
    @Override
    public Constant eval() {
        ScNumber v1 = (ScNumber) this.val1.getValue();
        ScNumber v2 = (ScNumber) this.val2.getValue();
        return new ConstantNum(v1.mul(v2));
    }
}
