package com.example.c0767722_ex4;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;


        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView lstComplaint;

   // private Complaint details;


    private void initViews() {
        //Complaint   details = new Complaint();

      // details = (Complaint) getIntent().getParcelableExtra("detials");
       lstComplaint = findViewById(R.id.lstComplaint);

        Intent intent = getIntent();
         Complaint details = intent.getParcelableExtra("detials");
        //lstComplaint.setText(details.getData());

        Log.d("dddddd", String.valueOf(details));
       lstComplaint.setText(details.getData());
        //lstComplaint.getAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }
}
