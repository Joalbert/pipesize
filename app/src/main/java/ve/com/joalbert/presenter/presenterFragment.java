package ve.com.joalbert.presenter;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Joalbert Palacios
 * @apiNote Version 1.0
 */
// This class is part of the presenter for MVP pattern as well as package measurementvariables
public class presenterFragment
{


    public presenterFragment()
    {
    }

    /** Get the values for the edit text given in the ids
    * @param editTextIds array with all ids from the EditText in the ViewGroup
    * @param v View where the EditText are available
    * @param val values will be used as default, if EditText is null, this will be in correspondance
    *            with the order in the editTextIds array
    * @return String array with the whole values available in the ViewGroup
    * */
    public static String[] getEditText(int [] editTextIds,View v,String[] val){

        String [] editTextValue=new String[editTextIds.length];

        for (int i = 0; i < editTextIds.length; i++) {
            EditText temp = (EditText) v.findViewById(editTextIds[i]);
            editTextValue[i] = (temp.getText().toString().compareTo("")==0)?val[i]:
                    temp.getText().toString();
            temp.setText(editTextValue[i]);
        }
        return editTextValue;
    }
    /** Get the items position for each spinners from the array SpinnerIds
        @param v parent view which contains all spinners
        @param SpinnerIds Array with all ids for each spinners
        @return array of index which each position selected for each spinners of
                the array SpinnerIds
    */
    public static int [] getSpinnerPosition(int [] SpinnerIds, View v) {

       int [] spinnerValue=new int[SpinnerIds.length];
       for(int i=0;i<SpinnerIds.length;i++)
       {
           Spinner temp=(Spinner) v.findViewById(SpinnerIds[i]);
           spinnerValue[i]=temp.getSelectedItemPosition();
       }

        return spinnerValue;
   }
    /** Set text in textView specified by the outputs array, parent view must be a parent view
     * which contains every text view ids in the array textViewIds
     * @param outputs array which contains each values to be used for updating every textView
     *                from the array textViewIds
     * @param parent view which contains whole textView from the array textViewIds
     * @param textViewIds array with indexes of every textview which intended to be updated
     *                    by the function
    */
    public static void setTextView(String [] outputs, int[] textViewIds, View parent)
   {
       for(int i=0;i<outputs.length;i++)
       {
           TextView temp=(TextView) parent.findViewById(textViewIds[i]);
           temp.setText(outputs[i]);
       }

   }

}

