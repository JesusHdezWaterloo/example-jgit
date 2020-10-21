/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Yo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("1232.txt"));
        FileOutputStream fos = new FileOutputStream(new File("1232Out.txt"));
        byte[] arr = new byte[5];
        while (fis.read(arr) != -1) {
            //hacerle cosas al arr, como el cifrado
            fos.write(reverse(arr));
        }
    }

    public static byte[] reverse(byte arr[]) {
        byte rev[] = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[rev.length - 1 - i] = arr[i];
        }
        return rev;
    }
}
