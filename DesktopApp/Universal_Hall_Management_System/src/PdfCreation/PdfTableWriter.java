package PdfCreation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author OleeAcmLab
 */
public class PdfTableWriter {

    private Document ourDoc = new Document();
    public static String getCurrentTimeInStringFormated() {

        Date now = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("[dd.MMMM.yyyy (hh.mm.aa)]");
        
        String ss = formater.format(now).replace(":", " ");
         System.out.println(ss);
         return ss;
    }
    public PdfTableWriter(String fileName,JTable table) throws DocumentException, FileNotFoundException {
     String date = getCurrentTimeInStringFormated();
        PdfWriter.getInstance(ourDoc, new FileOutputStream(new PdfCreate(fileName+"["+date+"]")));
        this.ourDoc.open();
        this.addMetaData();
        this.addToPage(this.newParagraph("UHMS EMAIL", true, false, false));
       // this.addToPage(this.newParagraph("Testing kortesiami", false, true, false));
        this.addToPage(new Paragraph(" "));
        this.addToPage(this.addTable(table));
        this.newPage();
        this.ourDoc.close();
    }

    public PdfTableWriter(String fileName,JTable table,String titel,String ...arr) throws DocumentException, FileNotFoundException {
        String date = getCurrentTimeInStringFormated();
        PdfWriter.getInstance(ourDoc, new FileOutputStream(new PdfCreate(fileName+"["+date+"]")));
        this.ourDoc.open();
        this.addMetaData();
        this.addToPage(this.newParagraph(titel+"\n"+"\n", true, false, false));
        for(String st: arr)  this.addToPage(this.newParagraph(st+"\n", false, true, false));
       
        this.addToPage(new Paragraph(" "));
        this.addToPage(this.addTable(table));
        this.newPage();
        this.ourDoc.close();
    }

    public Section addTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Section ourTableSection = new Chapter(0).addSection(this.newParagraph("Information Table", true, false, false));
        ourTableSection.add(new Paragraph(" "));
        PdfPTable ourTable = new PdfPTable(model.getColumnCount());

        for (int i = 0; i < model.getColumnCount(); i++) {
            ourTable.addCell(new PdfPCell(new Phrase(model.getColumnName(i).toString())));
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                ourTable.addCell(model.getValueAt(i, j).toString());
            }
        }
        ourTableSection.add(ourTable);

        return ourTableSection;
    }

    public void addToPage(Element toAdd) throws DocumentException {
        this.ourDoc.add(toAdd);
    }

    public void newPage() {
        this.ourDoc.newPage();
    }

    public void addMetaData() {
        ourDoc.addTitle("Information");
        ourDoc.addAuthor("Olee-Mmrs");
        ourDoc.addSubject("Hall Info");
        ourDoc.addKeywords("Metadata, iText, PDF");
        ourDoc.addCreator("uhms");
    }

    public Paragraph newParagraph(String text, boolean alignCenter, boolean alignLeft, boolean alignRight) {
        Paragraph ourParagraph = new Paragraph();
        if (alignCenter && !alignLeft && !alignRight) {
            ourParagraph.setAlignment(Element.ALIGN_CENTER);
        } else if ((!alignCenter && !alignLeft && !alignRight) && (!alignCenter && alignLeft && !alignRight)) {
            ourParagraph.setAlignment(Element.ALIGN_LEFT);
        } else if (!alignCenter && !alignLeft && alignRight) {
            ourParagraph.setAlignment(Element.ALIGN_RIGHT);
        }
        ourParagraph.add(text);
        return ourParagraph;
    }

}
