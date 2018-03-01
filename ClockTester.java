public class ClockTester {

   /**
    * Tester method for ClockReader
    */
   public static void main(String[] args) {

      // Output: It's twelve am
      System.out.println(ClockReader.readClock("00:00"));

      // Output: It's one thirty am
      System.out.println(ClockReader.readClock("01:30"));

      // Output: It's twelve oh five pm
      System.out.println(ClockReader.readClock("12:05"));

      // Output: It's eight nineteen pm
      System.out.println(ClockReader.readClock("20:19"));

      // Output: It's eleven fifty nine pm
      System.out.println(ClockReader.readClock("23:59"));
   }
}
