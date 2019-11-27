package personal.command;

import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://www.journaldev.com/246/jsch-example-java-ssh-unix-server
//https://stackoverflow.com/questions/25657603/how-to-use-java-jsch-library-to-read-remote-file-line-by-line
//http://www.jcraft.com/jsch/examples/
public class SSHCommandTest {

    public static void main(String[] args) {
        String host="rhtstapp01";
        String user="echeng";
        String password="";
        String command1="cd /opt/local; ls -al; cd apps; ls -al; cd ta_batch_process_tst; ls -al; cd conf; ls -al; pwd";
        try{

//            Scanner keyboard = new Scanner(System.in);
//            System.out.println("enter password");
//            password = keyboard.nextLine();

//            Console console = System.console();
//            if (console == null) {
//                System.out.println("Couldn't get Console instance");
//                System.exit(0);
//            }
//
//            console.printf("Testing password%n");
//            char[] passwordArray = console.readPassword("Enter your secret password: ");
//            console.printf("Password entered was: %s%n", new String(passwordArray));
//            password = new String(passwordArray);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();

            ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
            sftp.connect();
            System.out.println(sftp);
            System.out.println(sftp.lpwd());

            InputStream stream = sftp.get("/opt/local/apps/ta_batch_process_tst/conf/confidential.properties");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                // read from br

                int b;
                while ( ( b = stream.read() ) != -1 )
                {

                    char c = (char)b;

                    System.out.print(""+(char)b); //This prints out content that is unreadable.
                    //Isn't it supposed to print out html tag?
                }

            } finally {
                stream.close();
            }
            sftp.disconnect();


            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
