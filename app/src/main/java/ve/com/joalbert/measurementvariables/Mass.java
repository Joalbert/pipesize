package ve.com.joalbert.measurementvariables;


import java.math.BigDecimal;

/**
 * Created by joalbert on 2/18/17.
 */
public class Mass extends VariableMeasurement {

    public static final int OZ=0;
    public static final int LBS=1;
    public static final int STONE=2;
    public static final int US_TON=3;
    public static final int IMP_TON=4;
    public static final int NANOGRAMS=5;
    public static final int MICROGRAMS=6;
    public static final int MILIGRAMS=7;
    public static final int CENTIGRAMS=8;
    public static final int GRM=9;
    public static final int DECAGRAMS=10;
    public static final int HECTOGRAMS=11;
    public static final int KILOGRAMS=12;
    public static final int METRIC_TON=13;
    public static final int GIGAGRAMS=14;
    public static final int TERAGRAMS=15;

    // source: estimated from Excel file
    private static final double[][] CONVERTFACTORS={
            {1, 0.0625, 0.00446428571428571, 0.00003125, 0.0000279017857142857, 28350000000.0,
                    28350000.0, 28350.0, 2835.0, 28.35, 2.835, 0.2835, 0.02835, 0.00002835,
                    0.00000002835, 0.00000000002835
            },
            {
                    16, 1, 0.0714285714285714, 0.0005, 0.000446428571428571, 453600000000.0,
                    453600000.0, 453600.0, 45360.0, 453.6, 45.36, 4.536, 0.4536, 0.0004536,
                    0.0000004536, 0.0000000004536
            },
            {
                    224.0, 14.0, 1.0, 0.007, 0.00625, 6350400000000.0, 6350400000.0, 6350400.0, 635040.0,
                    6350.4, 635.04, 63.504, 6.3504, 0.0063504, 0.0000063504, 0.0000000063504
            },
            {
                    32000, 2000, 142.857142857143, 1.0, 0.892857142857143, 907200000000000.0,
                    907200000000.0, 907200000.0, 90720000.0, 907200.0, 90720.0, 9072.0, 907.2,
                    0.9072, 0.0009072, 0.0000009072
            },
            {
                    35840, 2240, 160, 1.12, 1, 1.016064*Math.pow(10.0,15.0), 1016064000000.0,
                    1016064000.0, 101606400.0, 1016064.0, 101606.4, 10160.64, 1016.064, 1.016064,
                    0.001016064, 0.000001016064
            },
            {
                    3.52733686067019*Math.pow(10.0,-11.0), 2.20458553791887*Math.pow(10.0,-12.0),
                    1.57470395565634*Math.pow(10.0,-13.0), 1.10229276895944*Math.pow(10.0,-15.0),
                    9.8418997228521*Math.pow(10.0,-16.0), 1.0, 0.001, 0.000001, 0.0000001,
                    Math.pow(10.0,-9.0), Math.pow(10.0,-10.0), Math.pow(10.0,-11.0),
                    Math.pow(10.0,-12.0), Math.pow(10.0,-15.0), Math.pow(10.0,-18.0),
                    Math.pow(10.0,-21.0)
            },
            {
                0.0000000352733686067019, 0.00000000220458553791887, 0.000000000157470395565634,
                0.00000000000110229276895944, 0.00000000000098418997228521, 1000.0, 1.0, 0.001,
                0.0001, 0.000001, 0.0000001, 0.00000001, 0.000000001, 0.000000000001, Math.pow(10.0,-15.0),
                Math.pow(10.0,-18.0)
            },
            {
                    0.0000352733686067019, 0.00000220458553791887, 0.000000157470395565634,
                    0.00000000110229276895944, 0.00000000098418997228521, 1000000.0, 1000.0, 1.0,
                    0.1, 0.001, 0.0001, 0.00001, 0.000001, 0.000000001, 0.000000000001,
                    Math.pow(10.0,-15.0),
            },
            {
                    0.000352733686067019, 0.0000220458553791887, 0.00000157470395565634,
                    0.0000000110229276895944, 0.0000000098418997228521, 10000000.0, 10000.0, 10.0,
                    1.0, 0.01, 0.001, 0.0001, 0.00001, 0.00000001, 0.00000000001, 0.00000000000001
            },
            {
                    0.0352733686067019, 0.00220458553791887, 0.000157470395565634,
                    0.00000110229276895944, 0.00000098418997228521, 1000000000.0, 1000000.0,
                    1000.0, 100.0, 1.0, 0.1, 0.01, 0.001, 0.000001, 0.000000001, 0.000000000001
            },
            {
                    0.352733686067019, 0.0220458553791887, 0.00157470395565634,
                    0.0000110229276895944, 0.0000098418997228521, 10000000000.0, 10000000.0,
                    10000.0, 1000.0, 10.0, 1.0, 0.1, 0.01, 0.00001, 0.00000001, 0.00000000001
            },
            {
                    3.52733686067019, 0.220458553791887, 0.0157470395565634, 0.000110229276895944,
                    0.000098418997228521, 100000000000.0, 100000000.0, 100000.0, 10000.0, 100.0,
                    10.0, 1.0, 0.1, 0.0001, 0.0000001, 0.0000000001
            },
            {
                    35.2733686067019, 2.20458553791887, 0.157470395565634, 0.00110229276895944,
                    0.00098418997228521, 1000000000000.0, 1000000000.0, 1000000.0, 100000.0,
                    1000.0, 100.0, 10.0, 1.0, 0.001, 0.000001, 0.000000001
            },
            {
                    35273.3686067019, 2204.58553791887, 157.470395565634, 1.10229276895944,
                    0.98418997228521, Math.pow(10.0,15.0), Math.pow(10.0,12.0), Math.pow(10.0,9.0),
                    Math.pow(10.0,8.0), Math.pow(10.0,6.0), Math.pow(10.0,5.0), Math.pow(10.0,4.0),
                    1000.0, 1, 0.001, 0.000001
            },
            {
                    35273368.6067019, 2204585.53791887, 157470.395565634, 1102.29276895944,
                    984.18997228521, Math.pow(10.0,18.0), Math.pow(10.0,15.0), Math.pow(10.0,12.0),
                    Math.pow(10.0,11.0), Math.pow(10.0,9.0), Math.pow(10.0,8.0), Math.pow(10.0,7.0),
                    Math.pow(10.0,6.0), 1000.0, 1.0, 0.001
            },
            {
                    35273368606.7019, 2204585537.91887, 157470395.565634, 1102292.76895944,
                    984189.97228521, Math.pow(10.0,21.0), Math.pow(10.0,18.0), Math.pow(10.0,15.0),
                    Math.pow(10.0,14.0), Math.pow(10.0,12.0), Math.pow(10.0,11.0),
                    Math.pow(10.0,10.0), Math.pow(10.0,9.0), Math.pow(10.0,6.0), 1000.0, 1.0
            }
    };

    /** @param unit has the index of the unit used for representing the object
     *  @param value has the value of mass
     * */
    public Mass(BigDecimal value, int unit)
    {
        super(value,unit);
    }


    /**Class function to perform conversion among units
     *  @param value has the value of mass
     *  @param unitFrom has the index of the unit used by the object
     *  @param unitTo has the index of the target unit for conversion
     *  @return Value in the target unit
     *  @throws MassException value is non positive a Exception is thrown
     */


    public static BigDecimal convertMass(BigDecimal value, int unitFrom, int unitTo)
            throws MassException
    {
        if(value.compareTo(BigDecimal.ZERO)<0) throw new MassException("Value must be positive");
        BigDecimal factor=new BigDecimal(CONVERTFACTORS[unitFrom][unitTo]);
        return value.multiply(factor);
    }
}


