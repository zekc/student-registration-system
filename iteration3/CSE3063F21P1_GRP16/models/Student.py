import json
import random
from typing import List


from CSE3063F21P1_GRP16.models.Course import Course
from CSE3063F21P1_GRP16.models.StudentUtils import StudentUtils


class Student:
    def __init__(self, new_first_name: str, new_last_name: str, all_courses: List[Course]):
        self._student_id = StudentID("CSE", str(int(max(18, random.random() * 20))), str(int(max(10, int(random.random() * 50)))))
        self._student_semester_no = int(random.random() * 5 + 2)
        self._first_name = new_first_name
        self._last_name = new_last_name
        self._transcript = Transcript(self, all_courses)
        self._student_utils = StudentUtils()

    def save_to_json(self):
        obj = {
            "Name": self._first_name,
            "LastName": self._last_name
        }

        trans = {
            "gpa": self._transcript.get_gpa()
        }

        passed_courses = [c.get_course_code() for c in self._transcript.get_passed_courses()]
        failed_courses = [c.get_course_code() for c in self._transcript.get_failed_courses()]
        selected_courses = [c.get_course_code() for c in self.get_student_utils().get_selected_courses()]

        obj["PassedCourses"] = passed_courses
        obj["FailedCourses"] = failed_courses
        obj["SelectedCourses"] = selected_courses
        obj["TranskriptObj"] = trans

        with open(f"src/students/{self._student_id.get_student_string()}.json", "w") as file:
            file.write(json.dumps(obj, indent=4))

    def get_advisor(self):
        return self.advisor

    def set_advisor(self, advisor):
        self.advisor = advisor

    def get_transcript(self):
        return self._transcript

    def set_transcript(self, transcript):
        self._transcript = transcript

    def get_student_utils(self):
        return self._student_utils

    def set_student_utils(self, student_utils):
        self._student_utils = student_utils

    def add_semester(self, courses: List[Course], semester_no: int, semester_name: SemesterName):
        self._transcript.add_semester(self, courses, semester_no, semester_name)