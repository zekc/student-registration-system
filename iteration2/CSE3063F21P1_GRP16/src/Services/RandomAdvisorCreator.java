package Services;

import Models.Advisor;

import java.util.ArrayList;

public class RandomAdvisorCreator {


    private String[] names = {"ayşe","mehmet","mustafa"};
    private String[] lastNames = {"tuncer","pala","kaya"};


    public ArrayList<Advisor> GenerateRandomAdv(int count){


        ArrayList<Advisor> advisors = new ArrayList<Advisor>();

        for (int i = 0; i <= count; i = i + 1) {

            String newName = names[(int) (Math.random()*names.length)];
            String newLastName = names[(int) (Math.random()*lastNames.length)];

            Advisor temp = new Advisor(newName,newLastName);
            advisors.add(temp);

        }


        return  advisors;



    }
}
