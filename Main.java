/**
 * Names: Meghan Galban, Shiza Ranamagar, Mohammad Fanous, Hanna Abrahem
 * This program is intended to generate a resume from user input
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creates an object of Scanner

        System.out.println("\nWelcome to ResumeGPT! Here, we'll teach you how to create a killer resume to land the job of your dreams! \n");
        System.out.println("What type of resume would you like to create? Type 'technical' or 'standard': ");

        String technicalORstandard = input.nextLine().toLowerCase();

        // exception handling
        while (!technicalORstandard.equalsIgnoreCase("standard")
                && !technicalORstandard.equalsIgnoreCase("technical")) {
            System.out.println("Typo! Please try again: ");
            technicalORstandard = input.nextLine().toLowerCase();
        }
        boolean isTechnical = Objects.equals(technicalORstandard.toLowerCase(), "technical");

        generateResume(isTechnical);
        System.out.println("Ta-daaa! Here's your new resume. Hope you like it!");
    }

    /**
     * This method get the user's information and applies it to the proper data structure
     * to eventually present all their information in a concise text file that is a sample resume
     * @param isTechnical a boolean that determines whether the resume is to be technical
     */
    public static void generateResume(boolean isTechnical){
        System.out.println("\nResumes commonly have the following sections: Personal Information, Education, Skills, Experience, and Awards");

        // **************************** PERSONAL INFORMATION **********************************************************

        Scanner input = new Scanner(System.in); // creates an object of Scanner
        System.out.println("Let's Start with the Personal Information Section!");

        System.out.println("\nEnter your full legal name: ");
        String fullName = input.nextLine();

        // Asks user for email, validates that it is in a valid form
        System.out.println("\nEmail: ");
        String email = input.nextLine();
        while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.println(email + " is an invalid email format. Please enter a valid email address: ");
            email = input.nextLine();
        }

        // Asks user for phone number, validates that it only contains digits
        System.out.println("\nPhone Number: ");
        String phoneNumber = input.nextLine();
        while (!phoneNumber.matches("\\d+")){ //exception handling
            System.out.println(phoneNumber + " is an invalid input. Only numbers accepted. Please try again: ");
            phoneNumber = input.nextLine();
        }

        // Asks user for their city & state, validates that the state is 2 letter abbreviation
        System.out.println("\nCity: ");
        String city = input.nextLine();
        System.out.println("\nState (abbreviated form): ");
        String state = input.nextLine().toUpperCase();
        while (state.length() != 2 || !state.matches("[a-zA-Z]+")){
            System.out.println(state +
                    " is invalid input. Please input a valid 2-letter state abbreviation: ");
            state = input.nextLine().toUpperCase();
        }
        // object to store the Users home location
        LocationData homeLocation = new LocationData(state, city);

        // Asks users for linkin profile
        System.out.println("\nLinkedIn Profile: ");
        String linkedIn = input.nextLine();

        // object to store the user's personal information
        PersonalInformationData userPersonalInformation =
                new PersonalInformationData(fullName, email, phoneNumber, homeLocation, linkedIn);

        // **************************** EDUCATION *********************************************************************

        System.out.println("\nNow, let's move on to the education section!");
        System.out.println("It's important on resumes to make sure the most " +
                "recent education comes first, followed by prior education.");

        DoublyLinkedList<EducationData> educationLinkedList = new DoublyLinkedList<>(); // creating education section linked list
        boolean moreEducationDetails = true;

        // While the user has more education
        while(moreEducationDetails) {
            // asks user for their institution name
            System.out.println("\nEnter the institution name, starting with your most recent one: ");
            String institutionName = input.nextLine();

            // asks the user for city and state of the institution name
            System.out.println("\nCity: ");
            String institutionCity = input.nextLine();
            System.out.println("\nState (abbreviated form): ");
            String institutionState = input.nextLine().toUpperCase();
            while (institutionState.length() != 2 || !institutionState.matches("[a-zA-Z]+")){
                System.out.println(institutionState +
                        " is invalid input. Please input a valid 2-letter state abbreviation: ");
                institutionState = input.nextLine().toUpperCase();
            }
            LocationData collegeLocation = new LocationData(institutionState, institutionCity);

            // asks the user for degree type and degree/major
            System.out.println("\nType of Degree (BS, BA, MA, etc): ");
            String degreeType = input.nextLine();

            System.out.println("\nDegree/Major: ");
            String degree = input.nextLine();

            // Asks the user for graduation date
            System.out.println("\nGraduation Date / Expected Graduation (mm/yyyy): ");
            String graduationDate = input.nextLine(); // stores user input
            while (!graduationDate.matches("\\d{2}/\\d{4}")){ // checks if users inputted it correctly
                // error message if date format is incorrect
                System.out.println(graduationDate +
                        " does not follow the mm/yyyy date format. Please try again: ");

                graduationDate = input.nextLine(); // stores the new input
            }
            // creates new object with users graduation date
            DateData dateOfGraduation =
                    new DateData(Integer.parseInt(graduationDate.split("/")[0]),
                            Integer.parseInt(graduationDate.split("/")[1]));

            System.out.println("\nRelevant Coursework: ");
            String relevantCoursework = input.nextLine();

            System.out.println("\nGPA: ");
            String GPA = input.nextLine();
            // loop until user inputs valid GPA
            while(!GPA.matches("\\d.\\d[0-9]?+") ||
                    !(Double.parseDouble(GPA) >= 0.0 && Double.parseDouble(GPA) <= 4.0)){
                System.out.println(GPA + " is not a valid GPA. Please try again: "); // prints error message if GPA not formatted correctly
                GPA = input.nextLine();
            }

            // EducationData object with users educational details
            EducationData userEducation =
                    new EducationData(institutionName, collegeLocation, degreeType,
                            degree, dateOfGraduation, relevantCoursework, Double.parseDouble(GPA));
            educationLinkedList.insertByDate(userEducation);

            // Asks if user wants to add more education
            System.out.println("\nDo you want to enter more education details? (Enter 'yes' or 'no')");
            String answer = input.nextLine().toLowerCase(); // reads users input and puts it in lowercase
            while (!answer.equals("yes") && !answer.equals("no")) { // exception handling
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                answer = input.nextLine().toLowerCase();
            }
            // keeps adding education entries until users says no
            moreEducationDetails = answer.equals("yes");
        }

        // **************************** SKILLS ************************************************************************

        // User is now entering skills section
        System.out.println("\nUp next is the skills section.\nLet your technical & language skills shine here!");

        // empty ArrayList to store technicalSkills
        ArrayList<String> technicalSkills = new ArrayList<>();
        // Users enters technical skills
        System.out.println("\nEnter your technical skills one by one, and enter 'done' when finished.");
        System.out.println("\nTechnical Skill: ");
        String technicalSkill = input.nextLine();
        // loop will continue until user enters done
        while (!technicalSkill.equalsIgnoreCase("done")) {
            technicalSkills.add(technicalSkill); // adds users technical skills to ArrayList
            System.out.println("Next technical skill (Type 'done' when finished): ");
            technicalSkill = input.nextLine();
        }

        //empty ArrayList to store languageSkills
        ArrayList<String> languageSkills = new ArrayList<>();
        //User enters language skills
        System.out.println("\nEnter your language skills one by one, and enter 'done' when finished.");
        System.out.println("\nLanguage Skill: ");
        String languageSkill = input.nextLine();
        // loop will continue until user enters done
        while (!languageSkill.equalsIgnoreCase("done")) {
            languageSkills.add(languageSkill); // adds users language skills to Arraylist
            System.out.println("Next language skill (Type 'done' when finished): ");
            languageSkill = input.nextLine();
        }
        // creates new instance of SkillsData with the users technical and language skills
        SkillsData userSkills = new SkillsData(technicalSkills, languageSkills);

        // **************************** EXPERIENCE ********************************************************************

        System.out.println("\nGreat! Now, let's move on to the experience section!");

        DoublyLinkedList<ExperienceData> experienceLinkedList = new DoublyLinkedList<>(); // creating education section linked list
        boolean moreExperienceDetails = true;

        // Asks user for most recent experience
        while(moreExperienceDetails) {
            System.out.println("Let's start with your most recent experience and work through the prior experiences");

            System.out.println("\nEnter the company name, starting with the most recent one: ");
            String companyName = input.nextLine();

            System.out.println("\nCity: ");
            String companyCity = input.nextLine();
            System.out.println("\nState (abbreviated form): ");
            String companyState = input.nextLine().toUpperCase();
            //loop to ready if length of companyState is all letters and is 2 letter
            while (companyState.length() != 2 || !companyState.matches("[a-zA-Z]+")){
                System.out.println(companyState +
                        " is invalid input. Please input a valid 2-letter state abbreviation: ");
                companyState = input.nextLine().toUpperCase();
            }
            // new LocationData object using companyState and companyCity values
            LocationData companyLocation = new LocationData(companyState, companyCity);

            System.out.println("\nJob Title: ");
            String jobTitle = input.nextLine();

            System.out.println("\nStart Date (mm/yyyy): ");
            String startDate = input.nextLine();
            while (!startDate.matches("\\d{2}/\\d{4}")){
                System.out.println(startDate + " does not follow the mm/yyyy date format. Please try again: ");
                startDate = input.nextLine();
            }
            DateData startingDate =
                    new DateData(Integer.parseInt(startDate.split("/")[0]),
                            Integer.parseInt(startDate.split("/")[1]));
            //this should split the date into month and year and put them in an array with those 2 things
            // and then create a DateData object

            System.out.println("\nEnd Date (mm/yyyy): "); //asks user to enter end date of job
            String endDate = input.nextLine();
            while (!endDate.matches("\\d{2}/\\d{4}")){  // starts a loop that checks if date in correct format
                System.out.println(endDate + " does not follow the mm/yyyy date format. Please try again: ");
                endDate = input.nextLine();
            }
            // split end date input into month and year to be stored as specific values
            DateData endingDate =
                    new DateData(Integer.parseInt(endDate.split("/")[0]),
                            Integer.parseInt(endDate.split("/")[1])); // same thing as starting date

            System.out.println("""

                    Now, we're going to make bullet points of each of your job responsibilities.
                    For example, 'I spearheaded the X project with my team of Y people'
                    But remember, each bullet should only be one line. So be concise!
                    """);

            // creates an empty ArrayList to store responsibilities
            ArrayList<String> responsibilities = new ArrayList<>();
            System.out.println("Enter a description (one bullet) of your " +
                    "responsibility one by one, and enter 'done' when finished: ");
            // asks user to enter description of responsibility
            String responsibility = input.nextLine();
            while(isLineTooLong(responsibility)){
                System.out.println("Oops! Looks like this bullet is too long! " +
                        "Try to keep it less than a line. Re-enter:");  //error message if too long
                responsibility = input.nextLine();
            }
            while (!responsibility.equalsIgnoreCase("done")) { // starts loop to add more responsible
                responsibilities.add(responsibility);
                System.out.println("Next responsibility (Type 'done' when finished): ");
                responsibility = input.nextLine();
                while(isLineTooLong(responsibility)){ // checks if responsibility exceeds certain limit
                    System.out.println("Oops! Looks like this bullet is too long! " +
                            "Try to keep it less than a line. Re-enter: ");
                    responsibility = input.nextLine();
                }
            }

            ExperienceData userExperience =
                    new ExperienceData(companyName, companyLocation,
                            jobTitle, startingDate, endingDate, responsibilities);
            experienceLinkedList.insertByDate(userExperience);

            System.out.println("Do you want to enter more experiences? (Enter 'yes' or 'no')");
            String answer = input.nextLine().toLowerCase();
            while (!answer.equals("yes") && !answer.equals("no")) { // exception handling
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                answer = input.nextLine().toLowerCase();
            }
            moreExperienceDetails = answer.equals("yes");
        }

        // **************************** AWARDS AND ACHIEVEMENTS *******************************************************

        //a minor difference between the two resumes
        if (isTechnical) {
            System.out.println("\nNext, we have our Awards & Achievements section!");
        } else {
            System.out.println("\nFinally, we have our Awards & Achievements section!");
        }

        DoublyLinkedList<AwardsAndAchievementsData> awardsLinkedList = new DoublyLinkedList<>(); // creating education section linked list
        System.out.println("If you're ready, press enter. But if you prefer not to enter anything for this section, enter 'skip': ");
        String skip = input.nextLine().toLowerCase();
        if(!skip.equals("skip")) { // if they enter anything else other than skip, it skips the code. Otherwise, it runs it.
            boolean moreAwardDetails = true;

            while (moreAwardDetails) {
                System.out.println("""

                        Enter an award you've received, starting with the most recent one.\s
                        Enter 'done' when finished:\s"""); //asks for the name of the award
                String award = input.nextLine();

                System.out.println("\nDate received (mm/yyyy): "); //asks for the date with exceptions
                String date = input.nextLine();
                while (!date.matches("\\d{2}/\\d{4}")) {
                    System.out.println(date +
                            " does not follow the mm/yyyy date format. Please try again: ");
                    date = input.nextLine();
                }
                DateData awardDate =
                        new DateData(Integer.parseInt(date.split("/")[0]),
                                Integer.parseInt(date.split("/")[1]));

                //makes a new object
                AwardsAndAchievementsData userAward = new AwardsAndAchievementsData(award, awardDate);
                awardsLinkedList.insertByDate(userAward); //inserts object by date

                System.out.println("Do you want to enter more awards? (Enter 'yes' or 'no')");
                String answer = input.nextLine().toLowerCase();
                while (!answer.equals("yes") && !answer.equals("no")) { // exception handling
                    System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                    answer = input.nextLine().toLowerCase();
                }
                moreAwardDetails = answer.equals("yes");
            }
        }

        // **************************** PROJECTS (if technical) *******************************************************

        DoublyLinkedList<ProjectData> projectLinkedList = new DoublyLinkedList<>(); //creates a project doubly linked list

        if (isTechnical) { // only asks the user and puts the information in if the resume is technical
            System.out.println("\nUnlike generic resumes, technical " +
                    "resumes really emphasize your projects.");

            boolean moreProjectDetails = true;

            while(moreProjectDetails) {
                System.out.println("Let's start with your most recent " +
                        "project and work through the prior projects");

                //gets project title
                System.out.println("\nEnter the project title, " +
                        "starting with the most recent one: ");
                String companyName = input.nextLine();

                //gets start date with exceptions
                System.out.println("\nStart Date (mm/yyyy): ");
                String startDate = input.nextLine();
                while (!startDate.matches("\\d{2}/\\d{4}")){
                    System.out.println(startDate +
                            " does not follow the mm/yyyy date format. Please try again: ");
                    startDate = input.nextLine();
                }
                DateData startingDate =
                        new DateData(Integer.parseInt(startDate.split("/")[0]),
                                Integer.parseInt(startDate.split("/")[1]));

                //gets end date with exceptions
                System.out.println("\nEnd Date (mm/yyyy): ");
                String endDate = input.nextLine();
                while (!endDate.matches("\\d{2}/\\d{4}")){
                    System.out.println(endDate +
                            " does not follow the mm/yyyy date format. Please try again: ");
                    endDate = input.nextLine();
                }
                DateData endingDate =
                        new DateData(Integer.parseInt(endDate.split("/")[0]),
                                Integer.parseInt(endDate.split("/")[1]));

                System.out.println("""

                        Now, we're going to make bullet points of each of your project responsibilities.
                        But remember, each bullet should only be one line. So be concise!
                        """);

                ArrayList<String> projectResponsibilities = new ArrayList<>();
                System.out.println("Enter a description (one bullet) of your project " +
                        "responsibility one by one. Enter 'done' when finished: "); //gets the description of each project
                String projectResponsibility = input.nextLine();
                while(isLineTooLong(projectResponsibility)){ //checks if description is too long
                    System.out.println("Oops! Looks like this bullet is too long!" +
                            " Try to keep it less than a line. Re-enter:");
                    projectResponsibility = input.nextLine();
                }
                while (!projectResponsibility.equalsIgnoreCase("done")) { //loops until user writes done
                    projectResponsibilities.add(projectResponsibility);
                    System.out.println("Next responsibility (Type 'done' when finished): ");
                    projectResponsibility = input.nextLine();
                    while(isLineTooLong(projectResponsibility)){
                        System.out.println("Oops! Looks like this bullet is too long! " +
                                "Try to keep it less than a line. Re-enter: ");
                        projectResponsibility = input.nextLine();
                    }
                }

                //makes new project object
                ProjectData userProjectExperience =
                        new ProjectData(companyName, projectResponsibilities, startingDate, endingDate);
                projectLinkedList.insertByDate(userProjectExperience); //inserts it within list by date

                System.out.println("Do you want to enter more projects? (Enter 'yes' or 'no')");
                String answer = input.nextLine().toLowerCase();
                while (!answer.equals("yes") && !answer.equals("no")) { // exception handling
                    System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                    answer = input.nextLine().toLowerCase();
                }
                moreProjectDetails = answer.equals("yes");
            }
        }

        // **************************** GENERATING RESUME *************************************************************

        System.out.println("\nGreat! Enter 'ready' to generate your resume: ");
        String ready = input.nextLine().toLowerCase();
        while (!ready.equals("ready")) { // exception handling
            System.out.println("Invalid response. Please enter 'ready'.");
            ready = input.nextLine();
        } try {
            FileWriter myWriter = new FileWriter("Resume.txt");
            if (!awardsLinkedList.isEmpty()){
                myWriter.write(userPersonalInformation
                        + "\n\nEDUCATION\n------------------------------\n" + educationLinkedList
                        + "\n\nSKILLS\n------------------------------\n" + userSkills
                        + "\n\nEXPERIENCE\n------------------------------\n" + experienceLinkedList
                        + "\n\nAWARDS AND ACHIEVEMENTS\n------------------------------\n" + awardsLinkedList);
            } else {
                myWriter.write(userPersonalInformation
                        + "\n\nEDUCATION\n------------------------------\n" + educationLinkedList
                        + "\n\nSKILLS\n------------------------------\n" + userSkills
                        + "\n\nEXPERIENCE\n------------------------------\n" + experienceLinkedList);
            }
            if (isTechnical) {
                myWriter.write("\n\nPROJECTS\n------------------------------\n" + projectLinkedList);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * This method determines whether a line is too long for a resume or above 80 characters
     * @param line A string that is to be evaluated
     * @return a boolean that determines if the line is over 80 or not
     */
    public static boolean isLineTooLong(String line) {
        int maxLength = 80; // 80 is the total characters in 1 line usually
        int length = line.length();
        return length > maxLength;
    }
}