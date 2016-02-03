package edu.westga.kenjiokamotostaticfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplaySumFragment extends Fragment {
    private TextView sumText;
    private double number1;
    private double number2;
    private double sum;

    public DisplaySumFragment() {}

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void addNumbers() {
        this.sum = this.number1 + this.number2;
    }

    public void displaySum() {
        this.sumText.setText(Double.toString(this.sum));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_display_sum, container, false);
        this.sumText = (TextView) theView.findViewById(R.id.sum_text);
        return theView;
    }

}
