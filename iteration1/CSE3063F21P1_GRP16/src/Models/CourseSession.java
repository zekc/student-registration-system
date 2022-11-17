package Models;

import org.json.JSONObject;

import java.sql.Time; //Java library for the Time class

public class CourseSession {

    Time LectureHour;    //An attribute representing the timing of lectures
    String LectureHall;  //An attribute representing where the lecture will be taking place 

    public Time getTime(){
        return LectureHour;  //A get method for the time 
    }


    public String getLectureHall(){  //A get method for Lecture room
        return LectureHall;   
    }

    public void setTime(Time time){
        this.LectureHour = time; //A set method to set/edit the timing of a lecture
    }

    public void setHall(String Hall){

        this.LectureHall = Hall;   //A set method to set/edit the room number the lecture will be taking place in

    }


    public CourseSession(JSONObject jsonObject) {




    }
}
