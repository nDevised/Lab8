package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    public boolean hasCity(City city){
        for(int i = 0; i < cities.size(); i++){
            if (cities.get(i).getCityName() == city.getCityName() && cities.get(i).getProvinceName() == city.getProvinceName()){
                return true;
            }
        }

        return false;
    }

    /**
     * deletes specific city from the list
     * @param city City class object
     * delete the city object from the list
     * @throws Exception if the city is not deleted successfully (i.e it isn't in the list)
     */
    public void deleteCity(City city) throws Exception {
        boolean isDeleted = false;
        for(int i = 0; i < cities.size(); i++){
            if (cities.get(i).getCityName() == city.getCityName() && cities.get(i).getProvinceName() == city.getProvinceName()){
                cities.remove(i);
                isDeleted = true;
            }
        }

        // throw an exception
        if (!isDeleted) {
            throw new Exception("This city is not in the list, failed to delete.");
        }
    }

}
