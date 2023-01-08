from services import jsonService


def main():
    print('Hello There')
    advisors = jsonService.InitAdvisors()
    
    courses = jsonService.InitLectures()
   


if __name__ == '__main__':
    main()
