package ve.com.joalbert.pipesize;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import ve.com.joalbert.pipe.Pipe;
import ve.com.joalbert.presenter.PipePresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ve.com.joalbert.pipesize.PipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PipeFragment extends Fragment implements View.OnClickListener{
    private View v;

    public PipeFragment() {
        // Required empty public constructor
    }

    public static ve.com.joalbert.pipesize.PipeFragment newInstance() {
        ve.com.joalbert.pipesize.PipeFragment fragment = new ve.com.joalbert.pipesize.PipeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.content_main,container,false);
        setSpinnerValues(R.id.nominalSize,R.array.nominalSizes);
        setSpinnerValues(R.id.schedule,R.array.schedule);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        return v;
    }

    public void setSpinnerValues(final int viewId, final int arrayValues)
    {
        Spinner unitFrom = (Spinner) v.findViewById(viewId);
        ArrayAdapter<CharSequence> unitFromAdapter= ArrayAdapter.createFromResource(getActivity(),
                arrayValues,android.R.layout.simple_spinner_item);
        unitFromAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        unitFrom.setAdapter(unitFromAdapter);
    }


    public void onButtonPressed(Uri uri) {
    }

    public static int[] getInSpinner(){
        return new int[]{R.id.nominalSize, R.id.schedule};
    }

    public static int[] getOutTextView(){
        return new int[]{R.id.schedule,R.id.insideDiameter,R.id.outsideDiameter,
        R.id.thickness};
    }

    @Override
    public void onClick(View view) {

        ListView lv = v.findViewById(R.id.results);
        int[] positionSpinner = PipePresenter.getSpinnerPosition(getInSpinner(), v);

        ArrayList<Pipe> data = PipePresenter.getPipes(positionSpinner[0],
                positionSpinner[1]);

        if (lv.getAdapter() == null){
            PipePresenter.startListView(lv, getActivity().getApplicationContext(), data);
        }
        else {
            PipePresenter.clearListView((ListViewAdapter) lv.getAdapter(), data);
            PipePresenter.updateListView(lv, getActivity().getApplicationContext(), data);
        }
    }

    }
