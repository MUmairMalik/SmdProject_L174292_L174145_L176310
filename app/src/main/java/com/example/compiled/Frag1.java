package com.example.compiled;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Frag1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag1_layout,container,false);

        RecyclerView list = view.findViewById(R.id.recycle);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        Users u1=new Users("umair Sajjad","56789",R.drawable.pic);
        Users u2=new Users("umair MAlik","667899",R.drawable.pic);

        List<Users> u=new ArrayList<Users>();
        u.add(u1);
        u.add(u2);
        list.setAdapter(new RAdapter(u, new RAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Users item) {
                Toast.makeText(getActivity() , (String) "checking", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(),ViewUsers.class);
                Gson gson = new Gson();
                String myJson = gson.toJson(item);
                intent.putExtra("myjson", myJson);
                getActivity().startActivity(intent);

            }
        }));

        return view;
    }
}
