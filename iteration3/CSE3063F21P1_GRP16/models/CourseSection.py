class CourseSection:
    def __init__(self, allstudent):
        self._allstudent = allstudent
        self._selectedCourses = []

    def getAllstudent(self):
        return self._allstudent

    def setAllstudent(self, allstudent):
        self._allstudent = allstudent

    def getSelectedCourses(self):
        return self._selectedCourses

    def setSelectedCourses(self, selectedCourses):
        self._selectedCourses = selectedCourses
