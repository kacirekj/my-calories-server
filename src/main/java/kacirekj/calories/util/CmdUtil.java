package kacirekj.calories.util;

import java.io.IOException;

public class CmdUtil {
    public static void runBashScript(String scriptContent) throws IOException, InterruptedException {
        System.out.println("Run script   : " + scriptContent);
        int exitValue;
        Process process;
        ProcessBuilder processBuilder = new ProcessBuilder(scriptContent);
        processBuilder.inheritIO();
        process = processBuilder.start();
        exitValue = process.waitFor();

        if (exitValue != 0) {
            throw new RuntimeException("Execution of the script failed!");
        }
    }
}
