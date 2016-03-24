package PdfCreation;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author OleeAcmLab
 */
public class PdfCreate extends File {

    public PdfCreate(String fileName) {
        
        super("C:\\uhms\\"+fileName + ".pdf");
        File f = new File("C:\\uhms\\");
        f.mkdirs();
        if (this.createNewFile()) {
            System.out.println("file created");
        }
        System.out.println(getAbsolutePath());
    }

    @Override
    public boolean createNewFile() {
        
        try {
            super.createNewFile();
            JOptionPane.showMessageDialog(null,"Print Successfull. Check file : "+super.getAbsolutePath());
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Print Successfuly Failed.");
            Logger.getLogger(PdfCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
