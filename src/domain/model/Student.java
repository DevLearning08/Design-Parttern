/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain.model;

public class Student {
    private int id;
    private String name;
    private String major;
    private int javaMark;
    private int htmlMark;
    private int cssMark;

    public Student(int id, String name, String major, int javaMark, int htmlMark, int cssMark, double averageMark) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.javaMark = javaMark;
        this.htmlMark = htmlMark;
        this.cssMark = cssMark;
    }

    // Getters and setters for the fields (omitted for brevity)

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Major: " + major + ", Java Mark: " + javaMark
                + ", HTML Mark: " + htmlMark + ", CSS Mark: " + cssMark + ", Average Mark: " + calAverage();
    }

    public double calAverage(){
        double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;
        return averageMark;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the javaMark
     */
    public int getJavaMark() {
        return javaMark;
    }

    /**
     * @param javaMark the javaMark to set
     */
    public void setJavaMark(int javaMark) {
        this.javaMark = javaMark;
    }

    /**
     * @return the htmlMark
     */
    public int getHtmlMark() {
        return htmlMark;
    }

    /**
     * @param htmlMark the htmlMark to set
     */
    public void setHtmlMark(int htmlMark) {
        this.htmlMark = htmlMark;
    }

    /**
     * @return the cssMark
     */
    public int getCssMark() {
        return cssMark;
    }

    /**
     * @param cssMark the cssMark to set
     */
    public void setCssMark(int cssMark) {
        this.cssMark = cssMark;
    }

    
}
