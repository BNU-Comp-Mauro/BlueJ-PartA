
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
    public Module (String title, String moduleCode)
    {
        this.title = title;
        this.moduleCode = moduleCode;
        this.percentageMark = 0;
    }
    
    /**
     * Get the course's percentage mark.
     */
    public int getPercentageMark()
    {
        return percentageMark;
    }
    
    /**
     * Set the percentage mark for the module.
     */
    public void setPercentageMark(int percentageMark)
    {
        this.percentageMark = percentageMark;
        System.out.println("Current " + title + " (" + moduleCode + ") " + 
        "mark: " + percentageMark);
        System.out.println();
    }
    
    /**
     * Print the module's details.
     */
    public void printModuleDetails()
    {
        System.out.println("Module details:");
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Code: " + moduleCode);
        System.out.println("Percentage mark: " + percentageMark);
        System.out.println();
    }
}
