package Models;
import java.util.Random;

public class Grade {
    //private String LetterGrade;
    private Double PointGrade;

    public Double getGrade() {
        return PointGrade;
    }

    public Double generateGrade() {
        Random r = new Random();
        double Grade = r.nextDouble(100);
        if (Grade < 45) { //If grade is going to be an FF, roll once more
            Grade = r.nextDouble(100); //To increase the chance of passing the course 
        }
        return setGrade(Grade);
    };

    public Double setGrade(double Grade) {
        if (Grade >= 90 && Grade <= 100) {
            //LetterGrade = "AA";
            PointGrade = 4.00;
        } else if (Grade >= 85 && Grade <= 89) {
            //LetterGrade = "BA";
            PointGrade = 3.50;
        } else if (Grade >= 80 && Grade <= 84) {
            //LetterGrade = "BB";
            PointGrade = 3.00;
        } else if (Grade >= 75 && Grade <= 79) {
           // LetterGrade = "CB";
            PointGrade = 2.50;
        } else if (Grade >= 65 && Grade <= 74) {
            //LetterGrade = "CC";
            PointGrade = 2.00;
        } else if (Grade >= 55 && Grade <= 64) {
            //LetterGrade = "DC";
            PointGrade = 1.50;
        } else if (Grade >= 50 && Grade <= 54) {
            //LetterGrade = "DD";
            PointGrade = 1.00;
        } else if (Grade >= 45 && Grade <= 49) {
            //LetterGrade = "FD";
            PointGrade = 0.50;
        } else if (Grade <= 45) {
            //LetterGrade = "FF";
            PointGrade = 0.00;
        }
        return PointGrade;
    }
}