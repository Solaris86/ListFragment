package com.buildappwithpaolo.mycourselistfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.buildappwithpaolo.mycourselistfragment.data.Course;
import com.buildappwithpaolo.mycourselistfragment.data.CourseData;

public class CourseDetailActivity extends AppCompatActivity {

    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            int position = extras.getInt("course_id");

            course = new CourseData().courseList().get(position);

            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(extras);
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }
    }
}
