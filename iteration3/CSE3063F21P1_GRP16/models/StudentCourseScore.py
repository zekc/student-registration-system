from models import Student, Course


class StudentCourseScore:
    def __init__(self, student: Student, course: Course, score):
        self._student = student
        self._course = course
        self._score = score
