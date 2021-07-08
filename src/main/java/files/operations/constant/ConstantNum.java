package files.operations.constant;

import files.types.ScType;
import files.types.numbers.ScNumber;

import java.util.Objects;

public class ConstantNum implements Constant {
    ScNumber value;

    public ConstantNum(ScNumber val) {
        this.value = val;
    }

    @Override
    public ScType getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ConstantNum.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantNum) {
            var other = (ConstantNum) obj;
            return this.value.equals(other.value);
        } else {
            return false;
        }
    }
}
