package files.types;

/**
 * @author jaedango
 */

public interface ScType {
    /**
     * cast this as ScString
     */
    ScString toScString();

    /**
     * add an ScString to another ScString
     */
    ScString addScString(ScString addend);
}
