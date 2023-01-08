import json
import random
from typing import List

class Student:
    def __init__(self, new_first_name: str, new_last_name: str, all_courses: List[Course]):
        self.student_id = StudentID("CSE", str(int(max(18, random.random() * 20))), str(int(max(10, int(random.random() * 50)))))
        self.student_semester_no = int(random.random() * 5 + 2)
        self.first_name = new_first_name
        self.last_name = new_last_name
        self.transcript = Transcript(self, all_courses)
        self.student_utils = StudentUtils()

    def save_to_json(self):
        obj = {
            "Name": self.first_name,
            "LastName": self.last_name
        }

        trans = {
            "gpa": self.transcript.get_gpa()
        }

        passed_courses = [c.get_course_code() for c in self.transcript.get_passed_courses()]
        failed_courses = [c.get_course_code() for c in self.transcript.get_failed_courses()]
        selected_courses = [c.get_course_code() for c in self.get_student_utils().get_selected_courses()]

        obj["PassedCourses"] = passed_courses
        obj["FailedCourses"] = failed_courses
        obj["SelectedCourses"] = selected_courses
        obj["TranskriptObj"] = trans

        with open(f"src/students/{self.student_id.get_student_string()}.json", "w") as file:
            file.write(json.dumps(obj, indent=4))

    def get_advisor(self):
        return self.advisor

    def set_advisor(self, advisor):
        self.advisor = advisor

    def get_transcript(self):
        return self.transcript

    def set_transcript(self, transcript):
        self.transcript = transcript

    def get_student_utils(self):
        return self.student_utils

    def set_student_utils(self, student_utils):
        self.student_utils = student_utils

    def add_semester(self, courses: List[Course], semester_no: int, semester_name: SemesterName):
        self.transcript.add_semester(self, courses, semester_no, semester_name)