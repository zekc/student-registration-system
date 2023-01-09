from services import jsonService


def main():
    print('Hello There')
    advisors = jsonService.InitAdvisors()
    
    courses = jsonService.InitLectures()

    for x in courses:
        print(x.getcourseName())
   


if __name__ == '__main__':
    main()
