package ru.mail.skorobogatov.www.functionality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DocCombiner {

    public static void combineDoc(Theme theme, String docPath, String docName) throws IOException {
        ArrayList<Integer> varNumber;

        varNumber = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            varNumber.add(i * 10 + random.nextInt(9) + 1);
        }

        String varName = docPath + "\\" + docName;
        File file = new File(varName);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.createNewFile();

        DocReader docRead = new DocReader();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
        writer.write("{");
        for (int i = 0; i < varNumber.size(); i++) {
            String filePath = docPath + "\\" + theme.getFolder() + "\\" + (((theme==Theme.KINETK)||(theme==Theme.KHKONE)||(theme==Theme.KHKTWO))?Theme.KINET:theme) + varNumber.get(i) + ".rtf";
            String str = docRead.readFile(filePath);
            str = str.substring(1, str.length() - 1);
            writer.append(str);
            writer.append("\n\n\n");
        }
        writer.append("}");
        writer.close();
    }
}