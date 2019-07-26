package com.ahmedco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ahmedco.doodhwala.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/arslan555/RoomDatabase
//https://guides.codepath.com/android/using-the-recyclerview


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       List<Customer> customer = new ArrayList<Customer>();
        for(int i =0 ; i< 10 ; i++){
          Customer customer1 = new Customer("Arslan "+i,"abc"+i,"27 "+i,43423424);
          DataBase.getInstance(this).getCustomerDao().inseret(customer1);
        }
        customer = DataBase.getInstance(this).getCustomerDao().getAllCustomer();

        Log.i("PrintDb0: " , String.valueOf(customer.size()));
        // Initializing list view with the custom adapter
        ArrayList<String> itemList = new ArrayList<>();
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
        // Populating list items
        for(int i=0; i<customer.size(); i++){
           itemList.add(customer.get(i).getName());
        }

       //  Log.i("PrintitemList00: ",String.valueOf( itemList));


    }
}