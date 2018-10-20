package com.buildappwithpaolo.mycourselistfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.buildappwithpaolo.mycourselistfragment.data.Course;
import com.buildappwithpaolo.mycourselistfragment.data.CourseArrayAdapter;
import com.buildappwithpaolo.mycourselistfragment.data.CourseData;
import com.buildappwithpaolo.mycourselistfragment.util.ScreenUtility;

import java.util.List;

public class CourseListFragment extends ListFragment {

    private List<Course> courses = new CourseData().courseList();
    private Callbacks activity;

    public CourseListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility(getActivity());

        Log.d("WIDTH", String.valueOf(screenUtility.getDpWidth()));

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_list_item, courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_list_fragment, container, false);
        return view;
    }

    public interface Callbacks {
        public void onItemSelected(Course course);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Course course = courses.get(position);
        this.activity.onItemSelected(course);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Callbacks) context;
    }
}
