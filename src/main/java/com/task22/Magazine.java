package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public class Magazine extends MailingItem {
    public String theme;

    /**
     * Constructor
     * @param department publish department
     * @param name       addresses's name
     * @param title       item's name
     */
    public Magazine(PunishmentDepartment department, String name,String title) {
        super(department, name,title);
        this.theme=new String();
    }

    /**
     * Cons
     * @param department publish department
     * @param name       addresses's name
     * @param title       item's name
     * @param theme      magazine's theme
     */
    public Magazine(PunishmentDepartment department,
                    String name,String title,
                    String theme) {
        super(department, name,title);
        this.theme=theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


}
