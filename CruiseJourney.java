package cruises;

import java.util.*;

/**
 *
 * @author Ryan
 */
public class CruiseJourney 
{
    private List<CruiseShip> shipList;
    
    public CruiseJourney()
    {
        this.shipList = new LinkedList<>();
    }
    
    public CruiseJourney(List<CruiseShip> list)
    {
        this.shipList = new LinkedList<>();
        this.shipList.addAll(list);
    }
    
    //adds a CruiseShip to the journey if the requirements below are met:
    public boolean addCruise(CruiseShip ship)
    {
        if (shipList.isEmpty())
            return shipList.add(ship);
        else if (ship.getDepartPort().equals(getEndPort()) && 
                getEndDate().compareTo(ship.getDepartDate()) <= 0 
                && !containsPort(ship.getArrivalPort()))
            return shipList.add(ship);
        else
            return false;
    }
    
    //removes the lastly added CruiseShip from the current journey (if any).
    public boolean removeLastTrip()
    {
        if(!shipList.isEmpty())
            return shipList.remove(shipList.get(shipList.size()-1));
        else
            return false;
    }
    
    //returns T/F if the given port is in the journey
    public boolean containsPort(String port)
    {
        for (int i = 0; i < shipList.size(); i++)
            if (shipList.get(i).getArrivalPort().equals(port) || 
                    shipList.get(i).getDepartPort().equals(port))
                return true;
        
        return false;
    }
    
    public String getStartPort()
    {
        if (!shipList.isEmpty())
            return shipList.get(0).getDepartPort();
        else
            return null;
    }
    
    public String getEndPort()
    {
        if (!shipList.isEmpty())
            return shipList.get(shipList.size()-1).getArrivalPort();
        else
            return null;
    }
    
    public Calendar getStartDate()
    {
        if (!shipList.isEmpty())
            return shipList.get(0).getDepartDate();
        else
            return null;
    }
    
    public Calendar getEndDate()
    {
        if (!shipList.isEmpty())
            return shipList.get(shipList.size()-1).getArrivalDate();
        else
            return null;
    }
    
    //returns a new CruiseJourney object, passing its shipList to the new 
    //instance by calling the second constructor
    public CruiseJourney cloneJourney()
    {
        return new CruiseJourney(this.shipList);
    }
    
    //returns the number of CruiseShips which comprise the journey
    public int getNumberOfTrips()
    {
        int numShips = 0;
        
        for (int i = 0; i < shipList.size(); i++)
            ++numShips;       
        
        return numShips;
    }
    
    //returns the total cost of all the CruiseShip trips in this journey
    public double getTotalCost()
    {
        double total = 0.0;
        
        for (int i = 0; i < getNumberOfTrips(); i++)
            total += shipList.get(i).getCost();       
        
        return total;
    }
    
    @Override
    public String toString()
    {
        String journey = "";
        
        for (int i = 0; i < shipList.size(); i++)
            journey += shipList.get(i) + "\n\n";
        
        journey += "Total Cost $" + getTotalCost();
        
        return journey;
    }
}
