/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author mfernandes
 */
public class Reflexon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        if (args[0].equals("test")) {
            System.out.println("ok");
            System.exit(0);
        }

            String dir = "/home/mfernandes/NetBeansProjects/Reflexon/";
        if (args[0].equals("compile")) {
            ///copiar o arquivo e compilar
            System.out.println("copiando de " + args[1]);
            File file = new File(args[1]);
            Files.copy(file.toPath(), new File(dir + "src/reflexon/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        
        if (args[0].equals("run")) {
            FileWriter fw = new FileWriter(dir + "src/reflexon/" + args[1] + ".java");
            fw.write(args[2]);
            fw.close();
        }
        
        if (args[0].equals("decode")) {
            FileWriter fw = new FileWriter(dir + "src/reflexon/" + args[1] + ".java");
            fw.write(new String(Base64.getDecoder().decode(args[2])));
            fw.close();
        }
        
        System.out.println("compilando...");
        Process p = Runtime.getRuntime().exec("javac,-d,class,src/reflexon/*.java".split(","), null, new File(dir));
        p.waitFor();
        System.out.println("testando...");
        p = Runtime.getRuntime().exec("java,reflexon.Reflexon,test".split(","), null, new File(dir + "class/"));
        Scanner s = new Scanner(p.getInputStream());
        if (s.nextLine().equals("ok")) {
            System.out.println("sucesso...");
        } else {
            System.out.println("ERRO");
        }
    }

}
