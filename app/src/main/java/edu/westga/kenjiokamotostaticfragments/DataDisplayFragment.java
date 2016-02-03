package edu.westga.kenjiokamotostaticfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataDisplayFragment extends Fragment {
    private TextView productText;
    private double number1;
    private double number2;
    private double product;

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
        return theView;
    }

}
