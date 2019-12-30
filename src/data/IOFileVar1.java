package data;

import java.io.*;
import java.util.Map;

public class IOFileVar1 {
    private RandomAccessFile file;
    private String pathFile;
    private Map[][] maps;

    public static void main(String[] args) {
        IOFileVar1 ioFileVar1 = new IOFileVar1();
        try {
            ioFileVar1.initFile("C:\\Users\\hp\\Desktop\\ma\\test1.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initFile(String pathFile)throws Exception{
        this.pathFile = pathFile;
        System.out.println("pathfile = " + pathFile);
        file = new RandomAccessFile(pathFile, "r");
        byte[] buf = new byte[(int) 1];
        int i = file.read(buf, 0, 1);

        System.out.println(i);
        file.close();

    }

    public void writeToFile(String addr, String text){
        try {
            FileWriter writer = new FileWriter(addr, true);
            writer.write(Addit.shfrUp(text));
            writer.close();
        } catch (Exception e) {
            System.out.println("Файл не найден");
        }
    }

    public String readFromFile(String addr){
        try {
            FileReader reader = new FileReader(addr);
            BufferedReader buff = new BufferedReader(reader);
            String currentLine;
            String text = "";
            while ((currentLine = buff.readLine()) != null) {
                text += currentLine;
            }
            text = Addit.shfrDown(text);
            return text;
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return "readFromFile";
    }

    void main2()throws Exception{
        file = new RandomAccessFile(pathFile, "r");
        int numBytes = 12;
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split.txt"));
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            readWrite(file, bw, numBytes);
        }
        bw.close();
        file.close();
    }

//    static void main1() throws Exception{
//        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\hp\\Desktop\\ma\\-MSI_vc_red.msi.txt", "r");
//        long numSplits = 10; //from user input, extract it from args
//        long sourceSize = raf.length();
//        long bytesPerSplit = sourceSize/numSplits ;
//        long remainingBytes = sourceSize % numSplits;
//        int maxReadBufferSize = 8 * 1024; //8KB
//        for(int destIx=1; destIx <= numSplits; destIx++) {
//            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split" + destIx + ".txt"));
//
//            if(bytesPerSplit > maxReadBufferSize) {
//                long numReads = bytesPerSplit/maxReadBufferSize;
//                long numRemainingRead = bytesPerSplit % maxReadBufferSize;
//                for(int i=0; i<numReads; i++) {
//                    readWrite(raf, bw, maxReadBufferSize);
//                }
//                if(numRemainingRead > 0) {
//                    readWrite(raf, bw, numRemainingRead);
//                }
//            }else {
//                readWrite(raf, bw, bytesPerSplit);
//            }
//            bw.close();
//        }
//        if(remainingBytes > 0) {
//            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split" + (numSplits+1) + "."));
//            readWrite(raf, bw, remainingBytes);
//            bw.close();
//        }
//        raf.close();
//    }


    private void readWrite(RandomAccessFile file, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = file.read(buf);
        if(val != -1) {
            bw.write(buf);
        }
    }

}
