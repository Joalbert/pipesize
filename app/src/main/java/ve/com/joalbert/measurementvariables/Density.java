package ve.com.joalbert.measurementvariables;


import java.math.BigDecimal;


/**
 * Created by joalbert on 2/11/17.
 */

public class Density extends VariableMeasurement {

    public static final int KG_M3=0;
    public static final int G_CM3=1;
    public static final int OZ_IN3=2;
    public static final int OZ_IMP_GAL=3;
    public static final int OZ_US_GAL=4;
    public static final int LB_FT3=5;
    public static final int LB_IN3=6;
    public static final int LB_YRD3=7;
    public static final int LB_IMP_GAL=8;
    public static final int LB_US_GAL=9;
    public static final int TON_YRD3=10;

        // Values from http://www.engineeringtoolbox.com/density-converter-d_1038.html

    private static final double[][] CONVERTFACTORS={
//   Kg/m3, g/cm3, oz/in3, oz/Imp gal, oz/US gal, lb/ft3, lb/in3 ,
// lb/yrd3, lb/Imp gal, lb/us gal, ton/yrd3
/*  Kg/m3 */    {1.0, 0.001,0.0005780367,0.1603586057,0.1335264712,0.0624279606,0.0000361273,
            1.6855549356,0.0100224129,0.0083454045,0.0007524799},
/*  g/m3 */     {1000.0, 1.0,0.578036672,160.35860568,133.52647123,62.427960576,0.036127292,
            1685.5549356,10.022412855,8.345404452,0.7524798819},
/* oz/in3 */    {1729.9940444, 1.7299940444,1.0,277.41943279,231.0,108.0,0.0625,
            2916.0,17.338714549,14.4375,1.3017857143},
/* oz/Imp gal*/ {6.2360232914,0.0062360233,0.0036046501,1.0,0.8326741846,0.3893022162,0.0002252906,
            10.511159837,0.0625,0.0520421365,0.0046924821},
/* oz/Us gal */ {7.4891517073,0.0074891517,0.0043290043,1.2009499255,1.0,0.4675324675,0.0002705628,
            12.623376623,0.0750593703,0.0625,0.005635436},
/* lb/ft3 */    {16.018463374,0.0160184634,0.0092592593,2.5686984518,2.1388888889,1.0,0.0005787037,
            27.0,0.1605436532,0.1336805556,0.0120535714},
/* lb/in3 */    {27679.90471,27.67990471,16.0,4438.7109247,3696.0,1728.0,1.0,
            46656.0,277.41943279,231.0,20.828571429},
/* lb/yrd3 */   {0.5932764213,0.0005932764,0.0003429355,0.0951369797,0.079218107,0.037037037,0.0000214335,
            1.0,0.0059460612,0.0049511317,0.0004464286},
/* lb/Imp gal*/ {99.776372663,0.0997763727,0.0576744024,16.0,13.322786954,6.228835459,0.0036046501,
            168.17855739,1.0,0.8326741846,0.0750797131},
/* lb/US gal */ {119.82642732,0.1198264273,0.0692640693,19.215198808,16.0,7.4805194805,0.0043290043,
            201.97402597,1.2009499255,1.0,0.0901669759},
/* ton/yrd3 */  {1328.9391836,1.3289391836,0.768175583,213.10683452,177.44855967,82.962962963,0.0480109739,
            2240.0,13.319177157,11.090534979,1.0}};

    /** @param unit has the index of the unit used for representing the object
     *  @param value has the value of density
     * */
    public Density(BigDecimal value,int unit)
    {
    super(value,unit);
    }


    /**Class function to perform conversion among units
     *  @param value has the value of density
     *  @param   unitFrom has the index of the unit used by the object
     *  @param unitTo has the index of the target unit for conversion
     *  @return Value in the target unit
     *  @throws DensityException value is non positive a Exception is thrown
     */


    public static BigDecimal convertDensity(BigDecimal value, int unitFrom, int unitTo)
            throws DensityException
    {
        if(value.compareTo(BigDecimal.ZERO)<0.0) throw new DensityException("Value must be positive");
        BigDecimal factor=new BigDecimal(CONVERTFACTORS[unitFrom][unitTo]);
        return value.multiply(factor);
    }


}
