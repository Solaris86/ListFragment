package com.buildappwithpaolo.mycourselistfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buildappwithpaolo.mycourselistfragment.data.Course;
import com.buildappwithpaolo.mycourselistfragment.data.CourseData;

public class CourseDetailFragment extends Fragment {

    private Course course;

    public CourseDetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("course_id")) {
            int position = bundle.getInt("course_id");
            course = new CourseData().courseList().get(position);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_detail_fragment, container, false);

        if (course != null) {
            TextView courseName = view.findViewById(R.id.detailCourseName);
            courseName.setText(course.getCourseName());

            ImageView courseImage = view.findViewById(R.id.detailsCourseImage);
            courseImage.setImageResource(course.getImageResourceId(getActivity()));

            TextView courseDescription = view.findViewById(R.id.detailsCourseDescription);
            courseDescription.setText(course.getCourseName());
        }

        return view;
    }
}
