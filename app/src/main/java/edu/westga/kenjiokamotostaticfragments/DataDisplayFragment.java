package edu.westga.kenjiokamotostaticfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DataDisplayFragment extends Fragment {
    private TextView productText;
    private double number1;
    private double number2;
    private double product;

    interface CalculateSumButtonListener {
        void handleSumButtonClick();
    }
    private CalculateSumButtonListener listener;
    
    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public DataDisplayFragment() {}

    public void multiply() {
        this.product = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.productText.setText(Double.toString(this.product));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);
        this.productText = (TextView) theView.findViewById(R.id.product);

        Button sumButton = (Button) theView.findViewById(R.id.sum_button);
        sumButton.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             sumButtonClicked();
                                         }
                                     }
        );

        return theView;
    }

    private void sumButtonClicked() {
        listener.handleSumButtonClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CalculateSumButtonListener) {
            this.listener = (CalculateSumButtonListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet DataDisplayFragment.CalculateSumButtonListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }
}
