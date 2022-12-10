package Models;

import Types.SemesterName;

public class Semester  {

   private Integer semesterNo;
   private SemesterName semesterName;
   
   public Semester(Integer semesterNo, SemesterName semesterName) {
    this.semesterNo = semesterNo;
    this.semesterName = semesterName;
   }

   public Integer getSemesterNo() {
    return semesterNo;
   }

   public void setSemesterNo(Integer semesterNo) {
    this.semesterNo = semesterNo;
   }

   public SemesterName getSemesterName() {
    return semesterName;
   }

   public void setSemesterName(SemesterName semesterName) {
    this.semesterName = semesterName;
   }
}
