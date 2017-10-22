package ve.com.joalbert.measurementvariables;


import java.math.BigDecimal;

/**
 * Created by joalbert on 2/11/17.
 */

public class VariableMeasurement
{
    // units: contains all valid units for density
    // convertFactor: has the multiply factor for conversion between units

    protected final BigDecimal value;
    protected final int unit;

    public VariableMeasurement(BigDecimal value,int unit)
    {
        this.value=value;
        this.unit=unit;
    }

   /* protected void setValue(BigDecimal value) {
        this.value = value;
    }

    protected void setUnit(int unit) {
        this.unit = unit;
    }*/

    public BigDecimal getValue()
    {
        return this.value;
    }

    public int getUnit(){
        return this.unit;
    }

}

