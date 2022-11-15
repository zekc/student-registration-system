package Models;

import org.json.JSONObject;

import java.sql.Time;

public class CourseSession {

    Time LectureHour;
    String LectureHall;

    public Time getTime(){
        return LectureHour;
    }


    public String getLectureHall(){
        return LectureHall;
    }

    public void setTime(Time time){
        this.LectureHour = time;
    }

    public void setHall(String Hall){

        this.LectureHall = Hall;

    }


    public CourseSession(JSONObject jsonObject) {




    }
}
