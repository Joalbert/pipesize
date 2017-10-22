package ve.com.joalbert.measurementvariables;
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joalbert
 */
public class SignedLength extends VariableMeasurement {
    public static final int MTS=0;
    public static final int DECIMETER=1;
    public static final int CENTIMETER=2;
    public static final int MILIMETER=3;
    public static final int MICROMETER=4;
    public static final int NANOMETER=5;
    public static final int ANG=6;
    public static final int HECTOMETER=7;
    public static final int KILOMETER=8;
    public static final int INCHES=9;
    public static final int FEET=10;
    public static final int YARD=11;
    public static final int MILE=12;
    public static final int NAUTICAL_MILE=13;
    public static final int CABLE=14;

    //source: http://www.engineeringtoolbox.com/length-units-converter-d_1033.html
    private static final double[][] CONVERTFACTORS={
            {1,10,100,1000,Math.pow(10.0,6.0),
                    Math.pow(10.0,9.0),Math.pow(10.0,10.0),0.01,
                    0.001,39.37, 3.28,1.09,6.21*Math.pow(10.0,-4.0),5.4*Math.pow(10.0,-4.0),
                    5.4*Math.pow(10.0,-3.0)},
            {0.1,1,10,100,Math.pow(10.0,5.0),Math.pow(10.0,8.0),
                    Math.pow(10.0,9.0),0.001,0.0001,3.937, 0.328,0.109,6.21*Math.pow(10.0,-5.0),
                    5.4*Math.pow(10.0,-5.0),
                    5.4*Math.pow(10.0,-4.0)},
            {0.01,0.1,1,10,Math.pow(10.0,4.0),Math.pow(10.0,7.0),
                    Math.pow(10.0,8.0),0.0001,0.00001,0.3937, 0.0328,0.0109,6.21*Math.pow(10.0,-6.0),
                    5.4*Math.pow(10.0,-6.0),
                    5.4*Math.pow(10.0,-5.0)},
            {0.001,0.01,0.1,1,Math.pow(10.0,3.0),Math.pow(10.0,6.0),
                    Math.pow(10.0,7.0),0.00001,0.000001,
                    0.03937, 0.00328,0.00109,6.21*Math.pow(10.0,-7.0),
                    5.4*Math.pow(10.0,-7.0),
                    5.4*Math.pow(10.0,-6.0)},
            {Math.pow(10.0,-6.0),Math.pow(10.0,-5.0),Math.pow(10.0,-4.0),Math.pow(10.0,-3.0),1,
                    Math.pow(10.0,3.0),Math.pow(10.0,4.0),Math.pow(10.0,-8.0),Math.pow(10.0,-9.0),
                    3.9*Math.pow(10.0,-5.0), 3.28*Math.pow(10.0,-6.0),1.09*Math.pow(10.0,-6.0),
                    6.2*Math.pow(10.0,-10.0),
                    5.4*Math.pow(10.0,-10.0),
                    5.4*Math.pow(10.0,-9.0)},
            {Math.pow(10.0,-9.0),Math.pow(10.0,-8.0),Math.pow(10.0,-7.0),Math.pow(10.0,-6.0),
                    Math.pow(10.0,-3.0),1,10,Math.pow(10.0,-11.0),Math.pow(10.0,-12.0),
                    3.9*Math.pow(10.0,-8.0), 3.28*Math.pow(10.0,-9.0),1.09*Math.pow(10.0,-9.0),
                    6.21*Math.pow(10.0,-13.0),
                    5.4*Math.pow(10.0,-13.0),
                    5.4*Math.pow(10.0,-12.0)},
            {Math.pow(10.0,-10.0),
                    Math.pow(10.0,-9.0),Math.pow(10.0,-8.0),Math.pow(10.0,-7.0),
                    Math.pow(10.0,-4.0),0.1,1,Math.pow(10.0,-12.0),Math.pow(10.0,-13.0),
                    3.9*Math.pow(10.0,-9.0), 3.28*Math.pow(10.0,-10.0),1.09*Math.pow(10.0,-10.0),
                    6.21*Math.pow(10.0,-14.0),5.4*Math.pow(10.0,-14.0),
                    5.4*Math.pow(10.0,-13.0)},
            {100,1000,Math.pow(10.0,4.0),
                    Math.pow(10.0,5.0),Math.pow(10.0,8.0),
                    Math.pow(10.0,11.0),Math.pow(10.0,12.0),1,0.1,
                    3937, 328,109.4,0.0621,
                    0.054,
                    0.54},
            {1000,Math.pow(10.0,4.0),
                    Math.pow(10.0,5.0),Math.pow(10.0,6.0),Math.pow(10.0,9.0),
                    Math.pow(10.0,12.0),Math.pow(10.0,13.0),10,1,
                    39370, 3280,1094,0.621,0.54,5.4},
            {0.0254,0.254,2.54,25.4,2.54*Math.pow(10.0,4.0),
                    2.54*Math.pow(10.0,7.0),2.54*Math.pow(10.0,8.0),
                    2.54*Math.pow(10.0,-4.0),2.54*Math.pow(10.0,-5.0),
                    1, 0.0833,0.0278,1.58*Math.pow(10.0,-5.0),1.37*Math.pow(10.0,-5.0),
                    1.37*Math.pow(10.0,-4.0)},
            {0.3048,3.048,30.48,304.8,3.048*Math.pow(10.0,5.0),3.048*Math.pow(10.0,8.0),
                    3.048*Math.pow(10.0,9.0),3.048*Math.pow(10.0,-3.0),3.048*Math.pow(10.0,-4.0),
                    12, 1,0.33,1.89*Math.pow(10.0,-4.0),1.65*Math.pow(10.0,-4.0),1.65*Math.pow(10.0,-3.0)},
            {0.914,9.14,91.4,914,9.14*Math.pow(10.0,5.0),9.14*Math.pow(10.0,8.0),9.14*Math.pow(10.0,9.0)
                    ,9.14*Math.pow(10.0,-3.0),9.14*Math.pow(10.0,-4.0),
                    36, 3,1,5.7*Math.pow(10.0,-4.0),4.9*Math.pow(10.0,-4.0),4.9*Math.pow(10.0,-3.0)},
            {1610,1.61*Math.pow(10.0,4.0),1.61*Math.pow(10.0,5.0),
                    1.61*Math.pow(10.0,6.0),1.61*Math.pow(10.0,9.0),
                    1.61*Math.pow(10.0,12.0),1.61*Math.pow(10.0,13.0),1.61*Math.pow(10.0,1.0),1.61,
                    63398, 5280,1761,1,0.87,8.7},
            {1852,1.852*Math.pow(10.0,4.0),1.852*Math.pow(10.0,5.0),
                    1.852*Math.pow(10.0,6.0),1.852*Math.pow(10.0,9.0),1.852*Math.pow(10.0,12.0),
                    1.852*Math.pow(10.0,13.0),1.852*Math.pow(10.0,1.0),1.852,
                    72908, 6076,2025,1.15,1,10},
            {185.2,1.852*Math.pow(10.0,3.0),1.852*Math.pow(10.0,4.0),
                    1.852*Math.pow(10.0,5.0),1.852*Math.pow(10.0,8.0),1.852*Math.pow(10.0,11.0),
                    1.852*Math.pow(10.0,12.0),1.852,0.1852,7290.8, 607.6,202.5,0.115,0.1,1}
    };

    /** @param unit has the index of the unit used for representing the object
     *  @param value has the value of length
     * */
    public SignedLength(BigDecimal value, int unit)
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


    public static BigDecimal signedConvertLength(BigDecimal value, int unitFrom, int unitTo)
    {
        BigDecimal factor=new BigDecimal(CONVERTFACTORS[unitFrom][unitTo]);
        return value.multiply(factor);
    }

    public SignedLength addSignedLength(SignedLength val){
        SignedLength result=new SignedLength(signedConvertLength(val.getValue(),
                val.getUnit(),unit),unit);
        result=new SignedLength(result.getValue().add(value),unit);
        return result;
    }

    public SignedLength subtractSignedLength(SignedLength val){
        SignedLength result=new SignedLength(signedConvertLength(val.getValue(),
                val.getUnit(),unit),unit);
        result=new SignedLength(result.getValue().subtract(value),unit);
        return result;
    }
}
