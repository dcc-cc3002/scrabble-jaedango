package files;

import java.util.Objects;

import static files.BinaryToInt.intToBin;
import static files.BinaryToInt.toInt;

/**
 * @author jaedango
 * ScInt : Integers for Scrabble
 */

public class ScInt {
    protected int value;

    public ScInt(int n) {
        this.value = n;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScInt.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScInt) {
            var other = (ScInt) obj;
            if (Integer.compare(this.value, other.value) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    public ScFloat toScFloat() {
        return new ScFloat((float) this.value);
    }

    public ScBinary toScBinary() {
        return new ScBinary(intToBin(this.value));
    }

    public ScFloat add(ScFloat fl) {
        return new ScFloat((float) this.value + fl.value);
    }

    public ScFloat sub(ScFloat fl) {
        return new ScFloat((float) this.value - fl.value);
    }

    public ScFloat mul(ScFloat fl) {
        return new ScFloat((float) this.value * fl.value);
    }

    public ScFloat div(ScFloat fl) {
        return new ScFloat((float) this.value / fl.value);
    }

    public ScInt add(ScInt n) {
        return new ScInt(this.value + n.value);
    }

    public ScInt sub(ScInt n) {
        return new ScInt(this.value - n.value);
    }

    public ScInt mul(ScInt n) {
        return new ScInt(this.value * n.value);
    }

    public ScInt div(ScInt n) {
        return new ScInt(this.value / n.value);
    }

    public ScInt add(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScInt(this.value + n);
    }

    public ScInt sub(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScInt(this.value - n);
    }

    public ScInt mul(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScInt(this.value * n);
    }

    public ScInt div(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScInt(this.value / n);
    }


}
