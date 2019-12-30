//package data;
//
//import java.io.*;
//
//public class IOFile {
//    public void writeToFile(String addr, String text){
//        try {
//            FileWriter writer = new FileWriter(addr, true);
//            writer.write(Addit.shfrUp(text));
//            writer.close();
//        } catch (Exception e) {
//            System.out.println("Файл не найден");
//        }
//    }
//
//    public String readFromFile(String addr){
//        try {
//            FileReader reader = new FileReader(addr);
//            BufferedReader buff = new BufferedReader(reader);
//            String currentLine;
//            String text = "";
//            while ((currentLine = buff.readLine()) != null) {
//                text += currentLine;
//            }
//            text = Addit.shfrDown(text);
//            return text;
//        } catch (IOException e) {
//            System.out.println("Файл не найден");
//        }
//        return "readFromFile";
//    }
//
//
//
//
//}
