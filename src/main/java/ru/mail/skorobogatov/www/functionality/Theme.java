package ru.mail.skorobogatov.www.functionality;

import java.util.HashMap;
import java.util.Map;

public enum Theme {
    KINET("Кинетика"),
    FAZ("Фазовые"),
    TERM("Термодинамика"),
    elek("Электрохимия"),
    KINETK("Кинетика - контрольная"),
    KHKONE("КХ - коллоквиум 1"),
    KHKTWO("КХ - коллоквиум 2");

    private String folderName;

    Theme(String fN) {
        this.folderName = fN;
    }
 
    public String getFolder() {
        return folderName;
    }

    //****** Reverse Lookup Implementation************//

    //Lookup table
    private static final Map<String, Theme> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(Theme env : Theme.values())
        {
            lookup.put(env.getFolder(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static Theme get(String folder)
    {
        return lookup.get(folder);
    }
}