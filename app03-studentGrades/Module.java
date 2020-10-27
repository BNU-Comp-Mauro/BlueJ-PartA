
/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    private String title;
    
    private String moduleCode;
    
    private int percentageMark;
    
    /**
     * Create a module with a title, code and percentage mark
     */
    public Module (String title, String moduleCode, int percentageMark)
    {
        this.title = title;
        this.moduleCode = moduleCode;
        this.percentageMark = percentageMark;
    }
    
    /**
     * Get the course's percentage mark.
     */
    public int getPercentageMark()
    {
        return percentageMark;
    }
}
