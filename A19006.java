import java.io.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 @author Chelsea Dorich (Email: <a href="mailto:"robotqi@gmail.com>robotqi@gmail.com</a>)
 @version 1.1 03/012/2014
 @assignment.number A190-06
 @prgm.usage Called from the operating system
 @see "Gaddis, 2013, Starting out with Java, From Control Structures, 5th Edition"
 @see "<a href='http://docs.oracle.com/javase/7/docs/technotes/guides/javadoc/index.html'>JavaDoc Documentation</a>

 */
public class A19006
{
    public static void main(String[] args) throws Exception
    {
        //declaring ary and other variables
        String[] aryAltitudes = {"03000","06000","09000","12000","18000","24000","30000","34000","36000"};
        String strNumStations = "";
        //start doing code work with printwriter
        PrintWriter outPut = new PrintWriter("C:\\Users\\Chelsea\\A19006\\Data\\FBOUT.txt");
        outPut.println("A19006 by Chelsea Dorich");
        //create stations object
        Stations db = new Stations();
        //prompt for altitude with joption pane
        String strStaID = JOptionPane.showInputDialog("Please enter the station code " +
                "you wish to find the weather for ");
        strStaID = strStaID.toUpperCase();
        int intLength = db.Length();
        outPut.println("The number of stations in the file is: " + intLength + "\r\n");
        //find weather for stationID

        //write weather to output file
        String strStaWeather = db.getStaWea(strStaID);
        outPut.println("Station Weather for " + strStaWeather);
        //instantiate NWSFB object
        NWSFB06 fb = new NWSFB06(strStaWeather);
        fb.updateString(strStaWeather);
        DecimalFormat formatter = new DecimalFormat("#,###");
        for(int i = 0; i < aryAltitudes.length; i++){
        outPut.println("At " + formatter.format(Integer.parseInt(aryAltitudes[i])) +" feet:\t Dir= " + fb.getWindDir(aryAltitudes[i])+ " Speed= " +fb.getWindSpeed(aryAltitudes[i])
                       + " Temp= "+ fb.getWindTemp(aryAltitudes[i]));}


        System.out.println(fb.getAltitudeWeather(aryAltitudes[0])+ "****");
        //create formatted string and add it to the file

        //close file
        outPut.close();
    }
}
