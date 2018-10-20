package com.buildappwithpaolo.mycourselistfragment.data;

import android.content.Context;
import android.widget.ArrayAdapter;

public class CourseArrayAdapter extends ArrayAdapter<Course> {

    public CourseArrayAdapter(Context context, int resource, Course[] objects) {
        super(context, resource, objects);
    }


}
