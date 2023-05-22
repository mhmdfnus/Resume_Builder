import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        //AWARDS
        DoublyLinkedList<AwardsAndAchievementsData> testList1 = new DoublyLinkedList<>();
        DateData testDate1 = new DateData(01, 2004);
        AwardsAndAchievementsData testAward1 = new AwardsAndAchievementsData("Money", testDate1);
        DateData testDate2 = new DateData(02, 2004);
        AwardsAndAchievementsData testAward2 = new AwardsAndAchievementsData("Money", testDate2);
        DateData testDate3 = new DateData(03, 2004);
        AwardsAndAchievementsData testAward3 = new AwardsAndAchievementsData("Money", testDate3);
        DateData testDate4 = new DateData(04, 2004);
        AwardsAndAchievementsData testAward4 = new AwardsAndAchievementsData("Money", testDate4);

        testList1.insertByDate(testAward3);
        testList1.insertByDate(testAward2);
        testList1.insertByDate(testAward4);
        testList1.insertByDate(testAward1);

        System.out.println(testList1);


        System.out.println();

        //EDUCATION
        DoublyLinkedList<EducationData> testList2 = new DoublyLinkedList<>();
        LocationData testLoc1 = new LocationData("PA", "Haverford");
        EducationData testEdu1 =
                new EducationData("Haverford College", testLoc1, "MBA", "ComputerScience"
                        , testDate1, "hkshfkjsdhf", 4.0);
        EducationData testEdu2 =
                new EducationData("Haverford College", testLoc1, "MBA", "ComputerScience"
                        , testDate2, "hkshfkjsdhf", 4.0);
        EducationData testEdu3 =
                new EducationData("Haverford College", testLoc1, "MBA", "ComputerScience"
                        , testDate3, "hkshfkjsdhf", 4.0);
        EducationData testEdu4 =
                new EducationData("Haverford College", testLoc1, "MBA", "ComputerScience"
                        , testDate4, "hkshfkjsdhf", 4.0);

        testList2.insertByDate(testEdu3);
        testList2.insertByDate(testEdu2);
        testList2.insertByDate(testEdu4);
        testList2.insertByDate(testEdu1);

        System.out.println(testList2);


        System.out.println();

        //EXPERIENCE
        DoublyLinkedList<ExperienceData> testList3 = new DoublyLinkedList<>();
        ArrayList<String> testArray1 = new ArrayList<>();
        testArray1.add("being really cool");
        testArray1.add("bossing me around");
        testArray1.add("getting lots of money!");
        ExperienceData testExp1 = new ExperienceData("Cool Place", testLoc1,
                "Manager", testDate1, testDate1, testArray1);
        ExperienceData testExp2 = new ExperienceData("Cool Place", testLoc1,
                "Manager", testDate1, testDate2, testArray1);
        ExperienceData testExp3 = new ExperienceData("Cool Place", testLoc1,
                "Manager", testDate1, testDate3, testArray1);
        ExperienceData testExp4 = new ExperienceData("Cool Place", testLoc1,
                "Manager", testDate1, testDate4, testArray1);

        testList3.insertByDate(testExp3);
        testList3.insertByDate(testExp2);
        testList3.insertByDate(testExp4);
        testList3.insertByDate(testExp1);

        System.out.println(testList3);


        System.out.println();

        //PERSONAL INFORMATION
        PersonalInformationData testPerson1 = new PersonalInformationData("John Smith",
                "coolguy@haverford.edu", "111-111-1111", testLoc1, "profile");
        System.out.println(testPerson1);


        System.out.println();

        //PROJECT
        DoublyLinkedList<ProjectData> testList4 = new DoublyLinkedList<>();
        ProjectData testPro1 = new ProjectData("Program", testArray1, testDate1, testDate1);
        ProjectData testPro2 = new ProjectData("Program", testArray1, testDate1, testDate2);
        ProjectData testPro3 = new ProjectData("Program", testArray1, testDate1, testDate3);
        ProjectData testPro4 = new ProjectData("Program", testArray1, testDate1, testDate4);

        testList4.insertByDate(testPro3);
        testList4.insertByDate(testPro2);
        testList4.insertByDate(testPro4);
        testList4.insertByDate(testPro1);

        System.out.println(testList4);


        System.out.println();

        //SKILLS
        ArrayList<String> testArrayTechSkill = new ArrayList<>();
        testArrayTechSkill.add("coding");
        testArrayTechSkill.add("being cool");
        testArrayTechSkill.add("something");
        ArrayList<String> testArrayLangSkill = new ArrayList<>();
        testArrayLangSkill.add("German");
        testArrayLangSkill.add("Latin");

        SkillsData testSkills = new SkillsData(testArrayTechSkill, testArrayLangSkill);
        System.out.println(testSkills);
    }
}
