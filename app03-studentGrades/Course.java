
/**
 * The Course class represents the students' chosen course. It stores the course
 * title and the course code.
 * 
 * Mauro Duarte Nunes
 * ID 21815118
 * 4/10/2020
 */
public class Course
{
    private String title;

    private String code;

    public Module module;

    /**
     * Create a Course with a given title and code identification.
     */
    public Course(String courseTitle, String courseCode)
    {
        title = courseTitle;
        code = courseCode;
    }

    /**
    /**
     * Set the title of this Course.
     */
    public void setTitle(String courseTitle)
    {
        title  = courseTitle;
    }

    /**
     * Set the code for this Course.
     */
    public void setCode(String courseCode)
    {
        code = courseCode;
    }

    /**
     * Print the course details
     */
    public void print()
    {
        System.out.println(", Course: " + title + ", Course code: " + code +
        "\n");
    }
}

