package Models;

import java.sql.Time;

import org.json.JSONObject;

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
