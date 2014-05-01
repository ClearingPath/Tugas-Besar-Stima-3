/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package external_file;

/**
 *
 * @author Jonathan
 */
public class fileDriver {
    public static void main (String agrs[])
    {
        file start = new file("Daftar Tweet Macet.txt");
        start.readFile();
        start.writeFile();
    }
}
