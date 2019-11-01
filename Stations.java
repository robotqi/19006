import java.io.*;
import java.util.ArrayList;

/**
 * uses arrays to navigaits lists of stations
 */
public class Stations
{
    ArrayList<String> staList = new ArrayList<String>();
    ArrayList<String> staIndex = new ArrayList<String>();

    /**
     *Reads input file and populates file with correct information
     * @throws Exception
     */
    public void staIndex()throws Exception{
        int intCntrLst = 0;
      //String[] staList = new String[176];
        String strFilePath = "C:\\Users\\Chelsea\\A19006\\Data\\FBIN.txt";
        String strRecord = "";
        //have a constructor that will accept the full fbin addresse
        File myFile = new File(strFilePath);
        if(myFile.exists())
        {System.out.println("inside loop");
            BufferedReader inputFile;
            inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(strFilePath)));
            for (int intLnCount = 0; intLnCount <= 6; intLnCount++)
            {
                strRecord = inputFile.readLine();
            }
           //  System.out.println("file found and 8 records read");
            while(inputFile.ready())
            {
                //read line + hand it to array staList
                strRecord = inputFile.readLine();
                System.out.println(strRecord);
                staList.add(strRecord);
                staIndex.add(strRecord.substring(0,3).trim());
            }

        inputFile.close();
        }
    }

    /**
     *gets length of array and returns it
     * @return intLength the length of either array, in this case staList
     * @throws Exception
     */
    public int Length()throws Exception
    {
        staIndex();
        int intLength = staList.size();
        return intLength;
    }

    /**
     * get the station weather from the arrays
     * @param strStationID hands the method stationID
     * @return strWeather containing the entire weather string
     */
    public String getStaWea(String strStationID)
    { if(exists(strStationID)){
        int intBully = staIndex.indexOf(strStationID);
        String strStaWeather = staList.get(intBully);
        return  strStaWeather;
    }
        else
        return "not existant";
    }

    /**
     * checks for the existance of the entered stationID
     * @param strStationID comes from input dialogue pane
     * @return blnStationExists indicates whether station name is contained in staIndex
     */
    public boolean exists(String strStationID)
    {
        Boolean blnStationExists = false;
        if(staIndex.contains(strStationID))
        {blnStationExists = true;}
        return blnStationExists;
    }
}
