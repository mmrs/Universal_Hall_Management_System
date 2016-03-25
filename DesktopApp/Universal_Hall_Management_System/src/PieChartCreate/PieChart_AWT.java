/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PieChartCreate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Siyam
 */
public class PieChart_AWT extends JFrame{
    
    static String title;
    public PieChart_AWT( String title,ResultSet resultSet ) 
   {
      super( title ); 
      this.title = title;
      setContentPane(createDemoPanel(resultSet ));
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     
   }
   private static PieDataset createDataset( ResultSet resultSet ) 
   {
        try {
            DefaultPieDataset dataset = new DefaultPieDataset( );
            
            while(resultSet.next()){
                dataset.setValue( resultSet.getString(1), new Double( resultSet.getString(2)) );
            }
            return dataset;
        } catch (SQLException ex) {
            Logger.getLogger(PieChart_AWT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Department Wise " + title,  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( ResultSet resultSet )
   {
      JFreeChart chart = createChart(createDataset(resultSet ) );  
      return new ChartPanel( chart ); 
   }
   
}
