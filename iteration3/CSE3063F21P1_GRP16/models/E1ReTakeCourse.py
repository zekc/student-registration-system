from typing import List

from CourseEvents import CourseEvents

from Student import Student


class E1ReTakeCourse(CourseEvents):
    def __init__(self):
        self._students = []

    def getStudents(self):
        return self._students

    def toString(self):
        s = "    Total Number of Student who taking the course again: {}\n".format(len(self._students))
        if len(self._students) > 0:
            s += "     -List Of students:\n"
        else:
            s += "\n"

        for i in range(len(self._students)):
            s += "      *{} {}\n".format(self._students[i].getFirstName(), self._students[i].getLastName())

        return s
