package cruises;

import java.util.*;

/**
 *
 * @author Ryan
 */
public class LuxuryCruiseCentre 
{
    //values: ships which DEPART the port
    private Map<String, Set<CruiseShip>> portMap;
    
    public LuxuryCruiseCentre()
    {
        this.portMap = new LinkedHashMap<>();
    }
    
    public boolean add(CruiseShip ship)
    {
        Set<CruiseShip> departureShipSet;
        
        if (portMap.get(ship.getDepartPort()) == null)  //port doesn't exist in map
            departureShipSet = new LinkedHashSet<>();
        else  //port does exist in map
            departureShipSet = portMap.get(ship.getDepartPort());
        
        departureShipSet.add(ship);
        portMap.put(ship.getDepartPort(), departureShipSet);
        
        return true;
    }
    
    /**
     * return list of all the uniquely possible routes from the start port and 
     * date to the end port. It does this by calling the recursive method 
     * findPaths.
     * 
     * @param startPort
     * @param startDate
     * @param endPort
     * @return 
     */
    public List<CruiseJourney> getPossibleJourneys(String startPort, Calendar startDate, 
            String endPort)
    {
        List<CruiseJourney> list = new LinkedList<>();
        
        findPaths(startPort, startDate, endPort, new CruiseJourney(), list);
        
        return list;
    }
    
    /**
     *  This method uses a depth first search technique to build up all 
     *  the possible journeys that can be undertaken between the start and end 
     *  port (if any). It does this by using the currentJourney parameter and 
     *  when the target port is found it will “clone” the current journey 
     *  and add it to the List of CruiseJourney values found.
     *  
     *  @param departPort
     *  @param departDate
     *  @param endPort
     *  @param journeyList 
     */
    private void findPaths(String departPort, Calendar departDate, String 
            endPort, CruiseJourney current, List<CruiseJourney> journeyList) 
    {
        if (departPort.equals(endPort)) 
            journeyList.add(current.cloneJourney());
        else
        {
            if (portMap.containsKey(departPort))
            {
                for (CruiseShip nextShip : portMap.get(departPort)) 
                {
                    if (departDate.compareTo(nextShip.getDepartDate()) <= 0 && 
                            !current.containsPort(nextShip.getArrivalPort()))
                    {
                        if (current.addCruise(nextShip));
                            findPaths(nextShip.getArrivalPort(), nextShip.getArrivalDate(), 
                                endPort, current, journeyList);
                        current.removeLastTrip();
                    }
                }
            }
        }
    }
}
