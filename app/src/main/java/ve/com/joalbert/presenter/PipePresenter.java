package ve.com.joalbert.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

import ve.com.joalbert.measurementvariables.Length;
import ve.com.joalbert.measurementvariables.Mass;
import ve.com.joalbert.pipe.Pipe;
import ve.com.joalbert.presenter.presenterFragment;

/**
 * This class is part of the presenter for MVP pattern
 */

public class PipePresenter extends presenterFragment {

    public static void startListView(ListView lv, Context context, ArrayList<Pipe> data) {
        ve.com.joalbert.pipesize.ListViewAdapter adapter = new ve.com.joalbert.pipesize.ListViewAdapter(context, data);
        lv.setAdapter(adapter);
    }

    public static void updateListView(ListView lv, Context context, ArrayList<Pipe> data) {
        startListView(lv, context, data);
        ve.com.joalbert.pipesize.ListViewAdapter adapter = (ve.com.joalbert.pipesize.ListViewAdapter) lv.getAdapter();
        adapter.notifyDataSetChanged();
    }

    public static void clearListView(ve.com.joalbert.pipesize.ListViewAdapter adapter, ArrayList<Pipe> data) {
        adapter.clear();
    }

    public static ArrayList<Pipe> getPipes(int nominalSize, int schedule)
    {
        ArrayList<Pipe> result = new ArrayList<Pipe>();
        nominalSize--;
        schedule--;
        if (nominalSize > -1 && schedule > -1) {
            result.add(0, new Pipe(nominalSize, schedule));
        }
        else if (nominalSize == -1 && schedule == -1) {
            for (int i = 0; i < Pipe.lastNominalSize; i++) {
                for (int j = 0; j < Pipe.lastSchedule; j++) {
                    result.add(result.size(), new Pipe(i, j));
                }
            }
        }
        else if (nominalSize > -1 && schedule == -1) {
            for (int i = 0; i < Pipe.lastSchedule; i++) {
                result.add(result.size(), new Pipe(nominalSize, i));
            }
        }
        else if (nominalSize == -1 && schedule > -1) {
            for (int i = 0; i < Pipe.lastNominalSize; i++) {
                result.add(result.size(), new Pipe(i, schedule));
            }
        }
            return result;
    }

    public static int linearSearch(final String[] searchSpace, final String word){
        int len = searchSpace.length;
        int index = 0;
        do{
          if(searchSpace[index]==word)
              return index;
          index++;
        }while(index<len);
            return -1;
    }


    public static int getLengthUnit(SharedPreferences pref){
        String unit = pref.getString("unitLengthPreferences"," ");
        return Integer.valueOf(unit);
    }

    public static int getMassLengthUnit(SharedPreferences pref){
        String unit = pref.getString("unitMassLengthPreferences"," ");
        return Integer.valueOf(unit);
    }


    public static String getNominalValue(String[] nominalSizesText, String[] schedulesText,
                                         Pipe pipe)
    {
        return nominalSizesText[pipe.getNominalSize()] + " " +
                schedulesText[pipe.getSchedule()];
    }

    public static void setTextViewValue(TextView tv,double InsideDiameter,String notApply,
                                              String title,String unit){
        BigDecimal val=new BigDecimal(InsideDiameter);
        String validation =  InsideDiameter == -1 ?
                title+" "+notApply : title+" "+ val.setScale(2, BigDecimal.ROUND_HALF_UP).
                stripTrailingZeros().toEngineeringString()+" "+unit;

        tv.setText(validation);
    }

    public static double convertUnitLength(double value, int unitTo){
        Double result=value;
        try{
        if(value!=-1.0)
            result = new Double(Length.convertLength(new BigDecimal(value),Length.INCHES,unitTo).
                            toString());

        }

        catch (Exception e){

        }
        return result;
    }

    public static double convertUnitMassLength(double value, int unitTo){
        Double result=value;
        try{
            if(value!=-1.0 && unitTo == 1)
                result = new Double(Mass.convertMass(new BigDecimal(value),Mass.LBS,Mass.KILOGRAMS).
                        toString()) /
                        new Double(Length.convertLength(BigDecimal.ONE,Length.FEET,Length.MTS).
                        toString());
        }

        catch (Exception e){

        }
        return result;
    }
}

