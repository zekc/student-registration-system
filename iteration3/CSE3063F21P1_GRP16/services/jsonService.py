import json
import os.path



def InitAdvisors():
    print("initliazing advisors")
    

    advisors = []
    f = open(os.path.dirname(__file__) + '/../advisors.json')
    data = json.load(f)
    for i in data['advisors']:
        #advisors.append(Advisor(i["AdvisorName"],i["AdvisorLastName"]))
        print(type(i['AdvisorName']))
        
        

        
    f.close()

    return advisors




def InitLectures():
    print("initliazing lectures")
    

    courses = []
    f = open(os.path.dirname(__file__) + '/../lectures.json')
    data = json.load(f)
    for i in data['courses']:
       # print(i['courseSessions'][0]['quota'])
       courses.append(Course(i['courseName'],i['courseCode'],int(i['courseSessions'][0]['quota']),0,int(i['credit']),int(i['courseSemester']),i['courseType'],5,int(i['requiredCredits'])))
        

        
    f.close()

    return courses











