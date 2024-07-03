/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railwayticketmanagementsys;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ticketbooking {
    static int available_l_berths=1;
    static int available_u_berths=1;
    static int available_m_berths=1;
    static int available_waitinglist=1;
    static int availableRacTickets = 1;
    static int availableWaitingList = 1;
    static Queue<Integer> waitingList = new LinkedList<>();
    static Queue<Integer> racList =  new LinkedList<>();
    static List<Integer> bookedTicketList =  new ArrayList<>();
    static List<Integer> lowerberth=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    static List<Integer> upperberth=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    static List<Integer> middleberth=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    static Map <Integer,passenger> passengers=new HashMap<>();
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
    public void bookticket(passenger p,int seatnum,String allotedbirth)
    {
        p.Snumber=seatnum;
        p.alloted=allotedbirth;
        passengers.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.out.println("-----------Booked Successfully--------------");
    }
    
    public void addToRAC(passenger p,int racInfo,String allotedRAC)
    {
        //assign seat number and type(RAC)
        p.Snumber = racInfo;
        p.alloted = allotedRAC;
        // add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of RAC tickets
        racList.add(p.passengerId);
        //decrease available RAC tickets by 1    
        availableRacTickets--;
        //remove the position that was alloted to the passenger
        racPositions.remove(0);

        System.out.println("------------added to RAC Successfully--------------");
    }
     public void addToWaitingList(passenger p,int waitingListInfo,String allotedWL)
    {
        //assign seat number and type(WL)
        p.Snumber = waitingListInfo; 
        p.alloted = allotedWL;
        // add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of WL tickets
        waitingList.add(p.passengerId);
        //decrease available WL tickets by 1    
        availableWaitingList--;
        //remove the position that was alloted to the passenger
        waitingListPositions.remove(0);

        System.out.println("-------------added to Waiting List Successfully-------------");
    }
     public void cancelTicket(int passengerId)
    {
        //remove the passenger from the map
        passenger p = passengers.get(passengerId);
        passengers.remove(Integer.valueOf(passengerId));
        //remove the booked ticket from the list
        bookedTicketList.remove(Integer.valueOf(passengerId));

        //take the booked position which is now free
        int positionBooked = p.Snumber;

        System.out.println("---------------cancelled Successfully");

        //add the free position to the correspoding type of list (either L,M,U)
        if(p.alloted.equals("L")) 
        { 
          available_l_berths++;
          lowerberth.add(positionBooked);
        }
        else if(p.alloted.equals("M"))
        { 
          available_m_berths++;
          middleberth.add(positionBooked);
        }
        else if(p.alloted.equals("U"))
        { 
          available_u_berths++;
          upperberth.add(positionBooked);
        }

        //check if any RAC is there
        if(racList.size() > 0)
        {
            //take passenger from RAC and increase the free space in RAC list and increase available RAC tickets
            passenger passengerFromRAC = passengers.get(racList.poll());
            int positionRac = passengerFromRAC.Snumber;
            racPositions.add(positionRac);
            racList.remove(Integer.valueOf(passengerFromRAC.passengerId));
            availableRacTickets++;

            //check if any WL is there
            if(waitingList.size()>0)
            {
                //take the passenger from WL and add them to RAC , increase the free space in waiting list and 
                //increase available WL and decrease available RAC by 1
                passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitingList.Snumber;
                waitingListPositions.add(positionWL);
                waitingList.remove(Integer.valueOf(passengerFromWaitingList.passengerId));

                passengerFromWaitingList.Snumber = racPositions.get(0);
                passengerFromWaitingList.alloted = "RAC";
                racPositions.remove(0);
                racList.add(passengerFromWaitingList.passengerId);
                
                availableWaitingList++;
                availableRacTickets--;
            }
            // now we have a passenger from RAc to whom we can book a ticket, 
            //so book the cancelled ticket to the RAC passenger
            RailwayTicketManagementSys.bookticket(passengerFromRAC);
        }
    
    }
     public void printAvailable()
    {
        System.out.println("Available Lower Berths "  + available_l_berths);
        System.out.println("Available Middle Berths "  + available_m_berths);
        System.out.println("Available Upper Berths "  + available_u_berths);
        System.out.println("Availabel RACs " + availableRacTickets);
        System.out.println("Available Waiting List " + availableWaitingList);
        System.out.println("--------------------------");
    }
     public void printPassengers()
    {
        if(passengers.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(passenger p : passengers.values())
        {
            System.out.println("PASSENGER ID " + p.passengerId );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.Snumber + p.alloted);
            System.out.println("--------------------------");
        }
    }
}
