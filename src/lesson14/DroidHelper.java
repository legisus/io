package lesson14;

import java.io.*;

public class DroidHelper {
    public static String convertConvertToCsv(Droid droid){
        StringBuilder sb = new StringBuilder();
        sb.append(droid.getName() + ";");
        sb.append(Integer.toString(droid.getMove()) + ";");
        sb.append(Double.toString(droid.getHealth()));
        return sb.toString();
    }

    public static String convertConvertToCsv(Droid[] droids){
        StringBuilder sb = new StringBuilder();
        for (var droid: droids) {
            sb.append(convertConvertToCsv(droid)+"\n");
        }
        return sb.toString();
    }
    private static void writeAllToCsv(Droid[] droids, String fileName) throws IOException {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (var droid : droids) {
                fw.write(droid.toCsvString()+"\n");
            }
        }
    }


    private static void writeToCsv(Droid[] droids, String fileName) throws IOException {
        for (var droid : droids) {
            writeToCsv(droid, fileName + droid.getName() + ".csv");

        }
    }

    private static void writeToCsv(Droid d1, String fileName) throws IOException {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(d1.toCsvString());
        }
    }

    private static void writeDroidStrCsvFile(Droid d1) throws IOException {
        FileWriter fw = new FileWriter("droidStr.csv");
        StringBuilder sb = new StringBuilder();
        sb.append(d1.getName() + ";");
        sb.append(Integer.toString(d1.getMove()) + ";");
        sb.append(Double.toString(d1.getHealth()));


        try {
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDroidStrToTxtFile(Droid d1) throws IOException {
        FileWriter fw = new FileWriter("droidStr.txt");
        try {
            fw.write(d1.getName() + " ");
            fw.write(Integer.toString(d1.getMove()) + " ");
            fw.write(Double.toString(d1.getHealth()));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDroidToTxtFile(Droid d1) throws FileNotFoundException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("droid.dat"));
        try {
            dos.writeUTF(d1.getName());
            dos.writeUTF(Integer.toString(d1.getMove()));
            dos.writeUTF(Double.toString(d1.getHealth()));
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDroidToBinFile(Droid d1) throws FileNotFoundException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("droid.dat"));
        try {
            dos.writeUTF(d1.getName());
            dos.writeInt(d1.getMove());
            dos.writeDouble(d1.getHealth());
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeDroidsToFile() throws IOException {
        Droid[] droids = {
                new Droid("Hulio", 65, 87),
                new Droid("Boby", 34, 99),
                new Droid("Yo", 99, 35)
        };
        try(FileWriter fw = new FileWriter("droidHelp.csv")){
            fw.write(DroidHelper.convertConvertToCsv(droids));
        }
    }
}
