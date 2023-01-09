from typing import List

from CourseEvents import CourseEvents

from Student import Student


class E5Quota(CourseEvents):
    def __init__(self):
        self._students = []
    
    def getStudents(self):
        return self._students
    
    def toString(self):
        s = "    Total Number of Student who couldn't take the course because the is quota full: {}".format(len(self._students))
        if self._students:
            s += "\n     -List Of Students:\n"
        else:
            s += "\n"
        for i in range(len(self._students)):
            s += "      *{} {}\n".format(self._students[i].getFirstName(), self._students[i].getLastName())
        return s
