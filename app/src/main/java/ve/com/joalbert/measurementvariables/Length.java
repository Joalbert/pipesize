package ve.com.joalbert.measurementvariables;


import java.math.BigDecimal;

/**
 * Created by joalbert on 2/11/17.
 */

public class Length extends SignedLength {


    /** @param unit has the index of the unit used for representing the object
     *  @param value has the value of length
     * */
    public Length(BigDecimal value, int unit)
    {
        super(value,unit);
    }

    /**Class function to perform conversion among units
     *  @param value has the value of length
     *  @param unitFrom has the index of the unit used by the object
     *  @param unitTo has the index of the target unit for conversion
     *  @return Value in the target unit
     *  @throws if value is non positive a Exception is thrown
     */


    public static BigDecimal convertLength(BigDecimal value, int unitFrom, int unitTo)
            throws LengthException
    {
        if(value.compareTo(BigDecimal.ZERO)<0) throw new LengthException("Value must be positive");
        return SignedLength.signedConvertLength(value,unitFrom,unitTo);
    }
}

