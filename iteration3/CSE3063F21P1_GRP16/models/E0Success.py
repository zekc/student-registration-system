from typing import List
from CourseEvents import CourseEvents
from Student import Student


class E0Success(CourseEvents):
    def __init__(self):
        self._students = []
        
    def getStudents(self):
        return self._students
    
    def toString(self):
        s = "    Total Number of Student who successfully enrolled to the course: {}\n".format(len(self._students))
        if self._students:
            s += "     -List Of Students:\n"
            for i in range(len(self._students)):
                s += "      *{} {}\n".format(self._students[i].getFirstName(), self._students[i].getLastName())
        return s