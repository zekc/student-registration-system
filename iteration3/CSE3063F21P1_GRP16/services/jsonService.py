import json
import os.path


def InitAdvisors():
    print("initliazing advisors")
    

    advisors = []
    f = open(os.path.dirname(__file__) + '/../advisors.json')
    data = json.load(f)
    for i in data['advisors']:
        print(i)
        

        
    f.close()

    return advisors












