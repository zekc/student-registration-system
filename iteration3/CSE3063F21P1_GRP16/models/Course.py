class Course:
    def __init__(self, courseName, courseCode, quota, prerequisiteCourse, credits, semester, courseType, sessions, requiredCredits):
        self._courseName = courseName
        self._courseCode = courseCode
        self._quota = quota
        self._prerequisiteCourse = prerequisiteCourse
        self._credits = credits
        self._courseSemesterName = semester
        self._courseType = courseType
        self._sessions = sessions
        self._quotaCounter = 0
        self._requiredCredits = requiredCredits
        self._CourseEvents = []
        self.set_events()

    def set_events(self):
        self._CourseEvents.append(E0Success())
        self._CourseEvents.append(E1ReTakeCourse())
        self._CourseEvents.append(E2prerequisite())
        self._CourseEvents.append(E3HourCollusion())
        self._CourseEvents.append(E4NoEnoughCredits())
        self._CourseEvents.append(E5Quota())

    def getCourseEvents(self):
        return self._CourseEvents

    # getters and setters
    def getcourseName(self):
        return self._courseName

    def setcourseName(self, courseName):
        self._courseName = courseName

    def getCourseCode(self):
        return self._courseCode

    def setCourseCode(self, courseCode):
        self._courseCode = courseCode

    def getQuota(self):
        return self._quota

    def setQuota(self, quota):
        self._quota = quota