/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package external_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class file {
    private int bufferFlag;
    private List<String> buffer;
    private String fileName;
    public file(String name)
    {
        buffer = new ArrayList<String>();
        buffer.add("<HTML>");
        buffer.add("<HEAD>");
        buffer.add("<TITLE>Result Page</TITLE>");
        buffer.add("</HEAD>");
        fileName = name;
        bufferFlag =0;
    }
    public void readFile()
    {
        String line = null;
        String location = null;
        Path file = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");
        buffer.add("<BODY>");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)){
            
            while ((line = reader.readLine()) != null){
                if (line.startsWith("Tweet"))
                {
                    buffer.add("<P>");
                    buffer.add(line);
                    line = reader.readLine();
                    buffer.add(line);
                    buffer.add("</P>");
                }
                else if (line.startsWith("Location"))
                {
                    buffer.add("<P>");
                    buffer.add(line);
                    line = reader.readLine();
                    if (line.startsWith("==="))
                    {
                        
                    }
                    else
                    {
                        buffer.add(line);
                    }
                    buffer.add("</P>");
                }
            }
        }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        buffer.add("</BODY>");
        buffer.add("</HTML>");
    }
    public void writeFile()
    {
        int i = 0;
        try {
          File file = new File("example.html");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          while (i < buffer.size())
          {
              output.write(buffer.get(i)+"\n");
              i++;
          }
          output.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }
    }
}
