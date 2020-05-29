package Control;

import java.io.*;

/**
 * ClassName: PrintData
 * description: creat and write a txt
 */

public class PrintData {
    private static String path;//the path of txt
    private static String filenameTemp;

    public PrintData(String path){
        this.path = path;
    }

    public static void creatTxt(String fName) throws IOException {

        try{
            filenameTemp =  path + fName + ".txt";
            File writename = new File(filenameTemp);// pathname
            if(!writename.exists()){
                writename.createNewFile(); // creat new file
            }
        }
        catch (IOException e1) {
            throw e1;
        }

    }

    public static void writeTxt(String newStr) throws IOException {
        // read the current content and write new content

        String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // path
            File file = new File(filenameTemp);
            // read file
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // store current content
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf.append(temp);
                // System.getProperty("line.separator")
                buf = buf.append(System.getProperty("line.separator"));
            }
            buf.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
        } catch (IOException e1) {
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }

    }

}
