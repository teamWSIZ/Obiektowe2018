package wsi.exec.service;

import org.springframework.stereotype.Component;
import wsi.exec.model.ExecResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Zabijanie procesów na windows:
 * lista: tasklist
 * --> znaleźć pid (process id)
 * zabijanie: taskkill /f /pid [znaleziony_pid]
 *
 */


@Component
public class ExecEngine {

    public ExecResponse executeIt(String command) {
        ExecResponse res = new ExecResponse();

//        res.setOut(Arrays.asList("linia1", "linia2"));
//        res.setErr(Arrays.asList("error1"));

        List<String> output = new ArrayList<>();
        List<String> errput = new ArrayList<>();

        try {
            String s = "";
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                output.add(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                errput.add(s);
            }
        } catch (IOException e) {
            errput.add(e.toString());
        }
        res.setOut(output);
        res.setErr(errput);
        return res;
    }

}
