/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.*;
/**
 *
 * @author PC 10
 */
public class Models2 {
    private String Path;
    private String Txt;
    private String Name;
    private String Email;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    private int Contador;

    public int getContador() {
        return Contador;
    }

    public void setContador(int Contador) {
        this.Contador = Contador;
    }
    public String getPath() {
        System.out.println("getPath");
        return Path;
    }

    public void setPath(String Path) {
        System.out.println("setPath");
        this.Path = Path;
    }

    public String getTxt() {
        System.out.println("getTxt");
        return Txt;
    }

    public void setTxt(String Txt) {
        System.out.println("setTxt");
        this.Txt = Txt;
    }
     public String getText(String name, String email){
        String txt = "";
        try{
            txt=name+","+email;
            System.out.println(txt);
        } catch(Exception err){
            System.err.println("error "+err.getMessage());
        }
        return txt;
    }
     
      public void primerRegistro(String txt){
        try{
            String result = txt;
            String[] arrayResult = result.split("\n");
            String[] result2 = arrayResult[0].split(",");
            this.setName(result2[0]);
            this.setEmail(result2[1]);
            System.out.println(result2[0]);
            System.out.println(result2[1]);
        } catch(Exception err){
            System.err.println("error "+err.getMessage());
        }
    }
    /**
     * Este metodo obtiene el ultimo registro del archivo CSV
     * @param txt Obtiene el texto del archivo CSV
     */
    public void ultimoRegistro(String txt){
        try{
            String result = txt;
            String[] arrayResult = result.split("\n");
            System.out.println("???????????");
            System.out.println(arrayResult[0]);
            System.out.println(arrayResult[1]);
            System.out.println("////////");
            int x = (arrayResult.length)-1;
            System.out.println(x);
            String[] result2 = arrayResult[x].split(",");
            System.out.println("@@@@@@@@@@@@@@");
            System.out.println(result2[0]);
            System.out.println(result2[1]);
            this.setName(result2[0]);
            this.setEmail(result2[1]);
        } catch(Exception err){
            System.err.println("error "+err.getMessage());
        }
    }
      public void verRegistros(String txt, int Ctd){
        try{
            String result = txt;
            String[] arrayResult = result.split("\n");
            String[] result2 = arrayResult[Ctd].split(",");
            this.setName(result2[0]);
            this.setEmail(result2[1]);
        } catch(Exception err){
            System.out.println("&&&&&");
            System.out.println(this.getContador());
            this.setContador(0); 
            System.out.println(this.getContador());
            System.err.println("error "+err.getMessage());
        }
    }
       public void witreFile(String path, String txt){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                System.out.println("--------");
                System.out.println(txt);
                printWriter.println(txt);
                printWriter.close();
            }        
        }catch(IOException err){
            System.err.println("error "+err.getMessage());
        }
    }
     public void readFile(String path){
        try{
            String row;
            String txt="";
            try(FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while((row = bufferedReader.readLine()) != null){
                    txt=txt+row+"\n";
                    System.out.println(row);
                } 
                this.setTxt(txt); 
                bufferedReader.close();
            }catch(FileNotFoundException err){
                System.out.println("Error! "+err.getMessage());   
            }
            }catch(IOException err){
                System.out.println("Error! "+err.getMessage());
        }
    }
}
