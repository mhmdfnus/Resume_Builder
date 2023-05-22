import java.util.ArrayList;

public class SkillsData {
    private ArrayList<String> technicalSkills;
    private ArrayList<String> languageSkills;

    public SkillsData(ArrayList<String> technicalSkills, ArrayList<String> languageSkills){
        this.technicalSkills = technicalSkills;
        this.languageSkills = languageSkills;
    }
    public ArrayList<String> getTechnicalSkills() {
        return technicalSkills;
    }
    public void setTechnicalSkills(ArrayList<String> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }
    public ArrayList<String> getLanguageSkills() {
        return languageSkills;
    }
    public void setLanguageSkills(ArrayList<String> languageSkills) {
        this.languageSkills = languageSkills;
    }

    public String toString() {
        String techSkillString = "";
        String langSkillString = "";
        for (String techSkill: technicalSkills) {
            if (techSkillString.equals("")) {
                techSkillString = techSkillString + techSkill;
            } else {
                techSkillString = techSkillString + " | " + techSkill;
            }
        }
        for (String langSkill: languageSkills) {
            if (langSkillString.equals("")) {
                langSkillString = langSkillString + langSkill;
            } else {
                langSkillString = langSkillString + " | " + langSkill;
            }
        }

        return "Technical Skills: " + techSkillString + "\nLanguage Skills: " + langSkillString;
    }
}
