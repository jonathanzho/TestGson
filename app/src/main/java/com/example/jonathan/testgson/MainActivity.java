package com.example.jonathan.testgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    Student student1 = new Student("Albert", 17);
    Student student2 = new Student("Beatrice", 18);

    ParentsToStudents parentsToStudents = new ParentsToStudents(student1, student2);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(parentsToStudents);
    Log.d(TAG, "json=[" + json + "]");
  }

  class Student {
    String mName;
    int mAge;

    Student(String name, int age) {
      mName = name;
      mAge = age;
    }
  }

  class ParentsToStudents {
    Student parent1;
    Student parent2;

    ParentsToStudents(Student student1, Student student2) {
      parent1 = student1;
      parent2 = student2;
    }
  }
}