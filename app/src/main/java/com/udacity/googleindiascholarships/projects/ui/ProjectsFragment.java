package com.udacity.googleindiascholarships.projects.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.googleindiascholarships.R;
import com.udacity.googleindiascholarships.projects.ui.adapter.ProjectsAdapter;
import com.udacity.googleindiascholarships.projects.entities.Project;
import com.udacity.googleindiascholarships.ui.MainActivity;
import com.udacity.googleindiascholarships.utils.ItemClickSupport;

import java.util.ArrayList;


/**
 * Created by jha.anuj.2108 on 13-04-2018.
 */

public class ProjectsFragment extends android.support.v4.app.Fragment {

    private RecyclerView projectsRecyclerView;
    private ArrayList<Project> projectList;

    private String[] projectName = {
            "GIS APP",
            "EXPLORE INDIA",
            "QUIZ APP",
            "BLOOD DONATION"
    };

    private String[] projectDescription = {
            "GIS App description here. GIS App description here. GIS App description here. GIS App description here.",
            "Explore India description here. Explore India description here. Explore India description here. Explore India description here.",
            "Quiz App description here. Quiz App description here. Quiz App description here. Quiz App description here.",
            "Blood Donation description here. Blood Donation description here. Blood Donation description here. Blood Donation description here"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_projects, container, false);

        projectsRecyclerView = rootView.findViewById(R.id.projectsRecyclerView);
        projectsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        projectList = new ArrayList<Project>();

        projectList.add(new Project(projectName[0], R.drawable.gis_placeholder,
                projectDescription[0]));

        projectList.add(new Project(projectName[1], R.drawable.explore_india_placeholder,
                projectDescription[1]));

        projectList.add(new Project(projectName[2], R.drawable.quiz_placeholder,
                projectDescription[2]));

        projectList.add(new Project(projectName[3], R.drawable.blooddonation_placholder,
                projectDescription[3]));

        ProjectsAdapter projectsAdapter = new ProjectsAdapter(getActivity(), projectList);
        projectsRecyclerView.setAdapter(projectsAdapter);
        setupProjectOnClick();
        return rootView;
    }

    private void setupProjectOnClick() {
        ItemClickSupport.addTo(projectsRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setMessage(projectDescription[position])
                        .setTitle(projectName[position])
                        .setCancelable(false)
                        .setPositiveButton("OK",null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Projects");
    }
}
