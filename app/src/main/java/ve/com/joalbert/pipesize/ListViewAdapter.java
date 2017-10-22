package ve.com.joalbert.pipesize;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ve.com.joalbert.pipe.Pipe;
import ve.com.joalbert.presenter.PipePresenter;

/**
 * Created by joalbert on 24/06/17.
 */

public class ListViewAdapter extends ArrayAdapter<Pipe> {
    private final Context context;
    private ArrayList<Pipe> results;
    private final int resId;
    private String [] nominalSizes;
    private String[] schedules;

    public ListViewAdapter(Context context, ArrayList<Pipe> results)
    {
        super(context,0,results);
        this.context=context;
        this.resId=R.layout.list_view_pipe;
        this.results=results;

        String [] aux = context.getResources().getStringArray(R.array.nominalSizes);
        int size=aux.length;
        nominalSizes=new String[size-1];
        for (int i=1;i<size;i++) {
            nominalSizes[i-1]=aux[i];
        }

        aux=context.getResources().getStringArray(R.array.schedule);
        size=aux.length;
        schedules=new String[size-1];
        for (int i=1;i<size;i++) {
            schedules[i-1]=aux[i];
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).
                    inflate(resId,parent,false);
            holder = new ViewHolder();
            holder.pipeDrawing = convertView.findViewById(R.id.pipeImg);
            holder.nominalSize = convertView.findViewById(R.id.nominalSizeText);
            holder.insideDiameter = convertView.findViewById(R.id.insideDiameter);
            holder.outsideDiameter = convertView.findViewById(R.id.outsideDiameter);
            holder.weightPerFoot = convertView.findViewById(R.id.weightLenght);
            holder.thickness = convertView.findViewById(R.id.thickness);
            holder.pipeDrawing.setImageResource(R.mipmap.pipe);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        String [] unitLengthValue = getContext().getResources().getStringArray(R.array.lengthUnit);
        String [] unitMassLengthValue = getContext().getResources().
                getStringArray(R.array.massUnitDistance);

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getContext());

        int unitLength = PipePresenter.getLengthUnit(preferences);
        int unitMassLength = PipePresenter.getMassLengthUnit(preferences);
        holder.nominalSize.setText(PipePresenter.getNominalValue(nominalSizes,schedules,
                results.get(position)));

        String notApply=context.getString(R.string.NA);

        double value = PipePresenter.convertUnitLength(results.get(position).getInsideDiameter(),
                unitLength);


        PipePresenter.setTextViewValue(holder.insideDiameter,
                value,
                notApply,getContext().getString(R.string.insideDiameter),
                unitLengthValue[unitLength]);

        value = PipePresenter.convertUnitLength(results.get(position).getOutsideDiameter(),
                unitLength);

        PipePresenter.setTextViewValue(holder.outsideDiameter,
                value,
                notApply,getContext().getString(R.string.outsideDiameter),
                unitLengthValue[unitLength]);

        value = PipePresenter.convertUnitMassLength(results.get(position).getWeight(),
                unitMassLength);

        PipePresenter.setTextViewValue(holder.weightPerFoot,
                value,
                notApply, getContext().getString(R.string.weightFoot),
                unitMassLengthValue[unitMassLength]
                );

        value = PipePresenter.convertUnitLength(results.get(position).getThickness(),
                unitLength);

        PipePresenter.setTextViewValue(holder.thickness,
                value,
                notApply, getContext().getString(R.string.thickness),
                unitLengthValue[unitLength]);

        return convertView;
    }

    public static class ViewHolder {
        ImageView pipeDrawing;
        TextView nominalSize;
        TextView insideDiameter;
        TextView outsideDiameter;
        TextView weightPerFoot;
        TextView thickness;
    }
}
