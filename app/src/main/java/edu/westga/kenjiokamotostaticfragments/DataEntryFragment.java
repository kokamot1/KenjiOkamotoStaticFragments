package edu.westga.kenjiokamotostaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {

    public DataEntryFragment() {}

    private EditText number1Text;
    private EditText number2Text;

    public interface DataEntryListener{
        void onDataEntry(double number1, double number2);
    }
    private DataEntryListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        this.number1Text = (EditText) theView.findViewById(R.id.editText1);
        this.number2Text = (EditText) theView.findViewById(R.id.editText2);

        final Button multiplyButton = (Button) theView.findViewById(R.id.multiply_button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 multiplyButtonClicked(v);
                                             }
                                          }

        );
        return theView;
    }

    private void multiplyButtonClicked(View v) {
        double number1 = Double.parseDouble(this.number1Text.getText().toString());
        double number2 = Double.parseDouble(this.number2Text.getText().toString());
        this.listener.onDataEntry(number1, number2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataEntryListener) {
            this.listener = (DataEntryListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet DataEntryFragment.DataEntryListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }


}
