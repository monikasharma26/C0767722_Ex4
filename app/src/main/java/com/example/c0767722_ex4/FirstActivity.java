package com.example.c0767722_ex4;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialAutoCompleteTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FirstActivity extends AppCompatActivity {

    @InjectView(R.id.txtSuffix)
    MaterialAutoCompleteTextView txtSuffix;
    @InjectView(R.id.txtFName)
    TextInputEditText txtFName;
    @InjectView(R.id.txtLName)
    TextInputEditText txtLName;
    @InjectView(R.id.radioFullTime)
    MaterialRadioButton radioFullTime;
    @InjectView(R.id.radioPartTime)
    MaterialRadioButton radioPartTime;
    @InjectView(R.id.radioTrainee)
    MaterialRadioButton radioTrainee;
    @InjectView(R.id.txtUnitNo)
    TextInputEditText txtUnitNo;
    @InjectView(R.id.txtStreetName)
    TextInputEditText txtStreetName;
    @InjectView(R.id.txtProvience)
    TextInputEditText txtProvience;
    @InjectView(R.id.txtCountry)
    MaterialAutoCompleteTextView txtCountry;
    @InjectView(R.id.txtPostalCode)
    TextInputEditText txtPostalCode;
    @InjectView(R.id.txtEmailId)
    TextInputEditText txtEmailId;
    @InjectView(R.id.txtPhNumber)
    TextInputEditText txtPhNumber;
    @InjectView(R.id.txtDate)
    TextInputEditText txtDate;
    @InjectView(R.id.mSpinner)
    MultipleSelectionSpinner mSpinner;
    @InjectView(R.id.ratingBar)
    RatingBar ratingBar;
    @InjectView(R.id.txtDesc)
    TextInputEditText txtDesc;
    @InjectView(R.id.btnSend)
    MaterialButton btnSend;
    @InjectView(R.id.btnClear)
    MaterialButton btnClear;
    //List which hold multiple selection spinner values
    List<String> list = new ArrayList<String>();
    @InjectView(R.id.textInputLayout3)
    TextInputLayout textInputLayout3;
    @InjectView(R.id.textView2)
    TextView textView2;
    @InjectView(R.id.txtEmpStatus)
    MaterialAutoCompleteTextView txtEmpStatus;
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;
    private SharedPreferences myPref;
    private DatePickerDialog datePicker;
    RadioButton radioType;
    String[] suffixList = {"Mr.", "Mrs.", "Ms.", "Miss.", "Dr.", "Sir", "Lord"};
    String[] designationList = {"Software Engineer", "Sr. Software Engineer", "Project Manager", "Support Engineer",
            "Designer", "Marketing"};
    String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        ButterKnife.inject(this);
        //adding items to list
        list.add("Network Problem,");
        list.add("System Crashing");
        list.add("Slow Internet");
        list.add("Software Installation");
        //set items to spinner from list
        mSpinner.setItems(list);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                }
            }
        });
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        ArrayAdapter<String> suffixListAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, suffixList);
        txtSuffix.setAdapter(suffixListAdapter);
        ArrayAdapter<String> designationListAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, designationList);
        txtEmpStatus.setAdapter(designationListAdapter);
        ArrayAdapter<String> countryListAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, countries);
        txtCountry.setAdapter(countryListAdapter);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioType =  findViewById(selectedId);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendButtonClicked();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float ratingValue = ratingBar.getRating();

                String color = "green";
                if(ratingValue <= 1){
                    color = "black";
                }
                else if(ratingValue> 1 && ratingValue <= 2){
                    color = "green";
                }
                else if(ratingValue> 2 && ratingValue <= 3){
                    color = "yellow";
                }
                else if(ratingValue> 3 && ratingValue <= 4){
                    color = "magenta";
                }
                else {
                    color = "red";
                }

                LayerDrawable starLayer = (LayerDrawable)ratingBar.getProgressDrawable();
                starLayer.getDrawable(2).setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);


            }
        });
    }

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void openDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        datePicker = new DatePickerDialog(FirstActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                        String strDate = format.format(calendar.getTime());
                        txtDate.setText(strDate.toUpperCase());
                    }
                }, year, month, day);
        datePicker.getDatePicker().setMaxDate(new Date().getTime());
        datePicker.show();
    }

    private void sendButtonClicked() {


        String suffix = txtSuffix.getText().toString();
        String fName = txtFName.getText().toString();
        String lName = txtLName.getText().toString();
        String radioStatus = radioType.getText().toString();
        String designation = txtEmpStatus.getText().toString();
        int unitNo = Integer.valueOf(String.valueOf(txtUnitNo.getText()));
        String streetName = txtStreetName.getText().toString();
        String provience = txtProvience.getText().toString();
        String Cntry = txtCountry.getText().toString();
        String postCode = txtPostalCode.getText().toString();
        String emailId = txtEmailId.getText().toString();
        String mobileNumber = txtPhNumber.getText().toString();
        String dob = txtDate.getText().toString();
     //   String date = txtDate.getText().toString();
        String desc = txtDesc.getText().toString();
        float rating = ratingBar.getRating();
      String mspinner = mSpinner.getSelectedItemsAsString().toString();
        Complaint cmb = new Complaint(suffix,fName,lName,radioStatus,designation,unitNo,streetName,provience,
        Cntry,postCode,emailId,mobileNumber,dob,desc,mspinner,rating);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("detials",cmb);
        startActivity(intent);

    }

}
