package personal.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ExecuteCommandTest {

    public static void main(String[] args){

        try {
            String[] command = new String[2];
            command[0] = "pwd";
            command[1] = "ls  -al";
//            command[0] = "bash", "-c", "ls /home/mkyong/"
//            command[2] = "f: && dir && cd snap";

//            Process p = Runtime.getRuntime().exec("pwd && ls -al");
//            Process p = Runtime.getRuntime().exec(command[0]);
            Process p = Runtime.getRuntime().exec( new String[]{"/bin/sh", "-c", "pwd ; ls -al"});


            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String Error;
            while ((Error = stdError.readLine()) != null) {
                System.out.println(Error);
            }
            while ((Error = stdInput.readLine()) != null) {
                System.out.println(Error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
