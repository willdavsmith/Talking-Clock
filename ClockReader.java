/**
 * @author willdavsmith
 * Class that converts a numeric time to natural language
 */
public class ClockReader {

   /**
    * Divides the input time into hours and minutes, utilizes toReadableNumber() method to return final String
    * @param time input time in HH:MM format
    * @return the time in natural language
    */
   public static String readClock(String time) {
      String hour = time.substring(0,2);
      String minutes = time.substring(3,5);
      String amOrPm;
      if (Integer.valueOf(hour)/12 > 0) {
         amOrPm = "pm";
         Integer hourValue = Integer.valueOf(hour) - 12;
         hour = hourValue.toString();
      }
      else {
         amOrPm = "am";
         if (hour.substring(0,1).equals("0")) {
            hour = hour.substring(1,2);
         }
      }
      return "It's " + toReadableNumber(hour, minutes) + amOrPm;
   }

   /**
    * A helper method for readClock(), decodes the numeric time
    * @param hour the numeric hour
    * @param minutes the numeric minutes
    * @return the time in natural language
    */
   private static String toReadableNumber(String hour, String minutes) {
      String[] times = {"0","1","2","3","4","5","6","7","8","9","10","11"};
      String[] readableTimesHours = {"twelve","one","two","three","four","five","six","seven","eight","nine","ten","eleven"};
      String[] readableTimesTensMinutes = {"oh","teen","twenty","thirty","forty","fifty"};
      String[] readableTimesOnesMinutes = {"\b","one","two","three","four","five","six","seven","eight","nine"};
      String[] readableTimesTeens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
      int index;
      index = indexOf(times, minutes.substring(1,2));
      String readableOnesMinutes = readableTimesOnesMinutes[index];
      String readableTensMinutes;
      if (minutes.substring(0,1).equals("1")) {
         index = indexOf(times, minutes.substring(1,2));
         readableTensMinutes = readableTimesTeens[index];
         readableOnesMinutes = "\b";
      }
      else if (minutes.substring(0,1).equals("0") && minutes.substring(1,2).equals("0")) {
         readableTensMinutes = "\b";
         readableOnesMinutes = "\b";

      }
      else {
         index = indexOf(times, minutes.substring(0,1));
         readableTensMinutes = readableTimesTensMinutes[index];
      }
      index = indexOf(times, hour);
      String readableHour = readableTimesHours[index];
      return readableHour + " " + readableTensMinutes + " " + readableOnesMinutes + " ";

   }

   /**
    * Helper function to find the index of a particular element in an array
    * @param array the array to be searched
    * @param element the element whose index will be returned
    * @return the index of the chosen element in the given index
    */
   private static int indexOf(String[] array, String element) {
      int i = 0;
      while (!element.equals(array[i]) && i<array.length-1) {
         i++;
      }
      return i;
   }
}