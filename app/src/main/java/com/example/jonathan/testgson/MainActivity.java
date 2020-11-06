package com.example.jonathan.testgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "TestGson MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onResume() {
    Log.d(TAG, "onResume");
    super.onResume();

    testGson();
  }

  private void testGson() {
    Log.d(TAG, "testGson");

    Student student1 = new Student("Albert", 17, true);
    Student student2 = new Student("Beatrice", 18, false);

    StudentList parentsToStudents = new StudentList(student1, student2);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(parentsToStudents);
    Log.d(TAG, "json=[" + json + "]");
  }

  class Student {
    @SerializedName("name")
    String mName;
    @SerializedName("age")
    int mAge;
    @SerializedName("1parent")
    boolean mIs1Parent;

    Student(String name, int age, boolean is1Parent) {
      mName = name;
      mAge = age;
      mIs1Parent = is1Parent;
    }
  }

  class StudentList {
    @SerializedName("student1")
    Student mStudent1;
    @SerializedName("student2")
    Student mStudent2;

    StudentList(Student student1, Student student2) {
      mStudent1 = student1;
      mStudent2 = student2;
    }
  }
}