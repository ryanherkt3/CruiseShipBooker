package cruises;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Seth (modified by Ryan for simplicity)
 */
public class LuxuryCruiseTestClass {
    
    public static void main(String[] args)
    {   
        System.out.println("------ LUXURY CRUISES -----");
        LuxuryCruiseCentre centre = new LuxuryCruiseCentre();
        buildGraph(centre);
        
        //modify departFrom, date and goTo as appropriate; the mods carry over 
        //to the console printout and call to getPossibleJourneys:
        String departFrom = "Auckland";
        String goTo = "Bangkok";
        GregorianCalendar date = new GregorianCalendar(2020, Calendar.JUNE, 1);
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM");
        
        System.out.println("Leaving " + departFrom + " to " + goTo
                + " on: " + fmt.format(date.getTime()) + "\n");
        List<CruiseJourney> options = centre.getPossibleJourneys(
                departFrom, date, goTo);
        System.out.println("THERE IS/ARE " + options.size() + " POSSIBLE "
                + "JOURNEY(S):");
        for(int i=0;i<options.size();i++)
        {   System.out.println("-------------------OPTION "+(i+1)+"--------------------------");
            System.out.println(options.get(i));
        }
    }
    
    public static void buildGraph(LuxuryCruiseCentre centre)
    {
       // create a bunch of cruises, then query for options
       //ENDEAVOR 
       centre.add(new CruiseShip("Endeavour", "Auckland", new GregorianCalendar(2020, Calendar.JUNE,1), 
               "Sydney", new GregorianCalendar(2020, Calendar.JUNE, 3), 3000));
       
       centre.add(new CruiseShip("Endeavour", "Sydney", new GregorianCalendar(2020, Calendar.JUNE, 4), 
               "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 5), 2000));
       
       centre.add(new CruiseShip("Endeavour", "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 7), 
               "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 12), 9350));
       
       centre.add(new CruiseShip("Endeavour", "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 15), 
               "Samoa", new GregorianCalendar(2020, Calendar.JUNE, 17), 800));
       
       centre.add(new CruiseShip("Endeavour", "Samoa", new GregorianCalendar(2020, Calendar.JUNE, 19, 10, 0), 
               "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 21), 550));
       
       centre.add(new CruiseShip("Endeavour", "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 22, 10, 0), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 30), 8800));
       
       // NZ VICTORY
       centre.add(new CruiseShip("NZ Victory", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 2), 
               "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 4), 1000));
       
       centre.add(new CruiseShip("NZ Victory", "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 6), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 8), 1250));
       
       centre.add(new CruiseShip("NZ Victory", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 10), 
               "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 12), 990));
       
       centre.add(new CruiseShip("NZ Victory", "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 14), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 16), 700));
       
       centre.add(new CruiseShip("NZ Victory", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 18), 
               "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 20), 1340));
       
       centre.add(new CruiseShip("NZ Victory", "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 24), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 26), 1300));
       
        //Inter islander
       centre.add(new CruiseShip("Inter Islander", "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 3), 
               "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 6), 700));
       
       centre.add(new CruiseShip("Inter Islander", "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 7), 
               "Niue", new GregorianCalendar(2020, Calendar.JUNE, 9), 800));
       
       centre.add(new CruiseShip("Inter Islander", "Niue", new GregorianCalendar(2020, Calendar.JUNE, 10), 
               "Samoa", new GregorianCalendar(2020, Calendar.JUNE, 12), 900));
       
       centre.add(new CruiseShip("Inter Islander", "Samoa", new GregorianCalendar(2020, Calendar.JUNE, 13), 
               "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 18), 750));
       
       centre.add(new CruiseShip("Inter Islander", "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 20), 
               "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 25), 850));
 
       centre.add(new CruiseShip("Inter Islander", "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 27), 
               "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 30), 1200));
       
       //OZZIE 
        centre.add(new CruiseShip("Ozzie", "Sydney", new GregorianCalendar(2020, Calendar.JUNE, 3), 
               "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 4), 170));
                
        centre.add(new CruiseShip("Ozzie", "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 5), 
               "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 10), 1500));
         
        centre.add(new CruiseShip("Ozzie", "Fiji", new GregorianCalendar(2020, Calendar.JUNE, 14), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 20), 2200));
                
        centre.add(new CruiseShip("Ozzie", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 22), 
               "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 24), 1800)) ;     
        
        centre.add(new CruiseShip("Ozzie", "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 24), 
               "Sydney", new GregorianCalendar(2020, Calendar.JUNE, 25), 50));  
        
        centre.add(new CruiseShip("Ozzie", "Sydney", new GregorianCalendar(2020, Calendar.JUNE, 26), 
               "Melbourne", new GregorianCalendar(2020, Calendar.JUNE, 27), 75));  
          
       //Bangkok EXPRESS 
       centre.add(new CruiseShip("Bangkok XP", "Bangkok", new GregorianCalendar(2020, Calendar.JUNE, 1), 
               "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 7), 7000)); 
       
       centre.add(new CruiseShip("Bangkok XP", "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 9), 
               "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 11), 2000)); 
       
       centre.add(new CruiseShip("Bangkok XP", "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 18), 
               "Bangkok", new GregorianCalendar(2020, Calendar.JUNE, 28), 8000));
       
       //NZ Circuit
       centre.add(new CruiseShip("NZ Circuit", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 1), 
               "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 4), 1200));
       
       centre.add(new CruiseShip("NZ Circuit", "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 6), 
               "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 8), 1240));
       
       centre.add(new CruiseShip("NZ Circuit", "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 10), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 14), 1800));
       
       centre.add(new CruiseShip("NZ Circuit", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 18), 
               "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 20), 1100));
       
       centre.add(new CruiseShip("NZ Circuit", "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 21), 
               "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 23), 1150));
       
       centre.add(new CruiseShip("NZ Circuit", "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 24), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 28), 1860));
       
       //Antartica
       centre.add(new CruiseShip("Antartic Explorer", "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 25), 
               "Antarctica", new GregorianCalendar(2020, Calendar.JUNE, 28), 1700));
       
       //NZ ISLAND ADVENTURES
       centre.add(new CruiseShip("NZ Island Adventures", "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 1), 
               "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 2), 1550));
       
       centre.add(new CruiseShip("NZ Island Adventures", "Auckland", new GregorianCalendar(2020, Calendar.JUNE, 3), 
               "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 10), 12550));
       
       centre.add(new CruiseShip("NZ Island Adventures", "Tonga", new GregorianCalendar(2020, Calendar.JUNE, 15), 
               "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 20), 3000));
       
       centre.add(new CruiseShip("NZ Island Adventures", "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 25), 
               "Wellington", new GregorianCalendar(2020, Calendar.JUNE, 30), 2300));
        
        //CHEAP AS CHIPS ADVENTURES
        centre.add(new CruiseShip("Cheap As Chips Adventures", "Christchurch", new GregorianCalendar(2020, Calendar.JUNE, 11), 
               "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 12), 249));
        
        centre.add(new CruiseShip("Cheap As Chips Adventures", "Brisbane", new GregorianCalendar(2020, Calendar.JUNE, 13), 
               "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 16), 449));
        
        centre.add(new CruiseShip("Cheap As Chips Adventures", "Vanuatu", new GregorianCalendar(2020, Calendar.JUNE, 20), 
               "Bangkok", new GregorianCalendar(2020, Calendar.JUNE, 30), 749));
    }
}