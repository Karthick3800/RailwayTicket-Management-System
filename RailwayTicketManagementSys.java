/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package railwayticketmanagementsys;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class RailwayTicketManagementSys {

    /**
     * @param args the command line arguments
     */
    public static void bookticket(passenger p) {
       ticketbooking booker = new ticketbooking();
        if(ticketbooking.availableWaitingList == 0)
        {
            System.out.println("No Tickets Available");
            return;
        }
        if((p.breathPreference.equals("L") && ticketbooking.available_l_berths > 0 )||
           (p.breathPreference.equals("M") && ticketbooking.available_m_berths > 0) ||
           (p.breathPreference.equals("U") && ticketbooking.available_u_berths > 0))
        {
            System.out.println("Preferred Berth Available");
            if(p.breathPreference.equals("L"))
            {
                System.out.println("Lower Berth Given");
                //call booking function in the TicketBooker class
                booker.bookticket(p,(ticketbooking.lowerberth.get(0)),"L");
                //remove the booked position from available positions and also decrease available seats of that
                // particular type
                ticketbooking.lowerberth.remove(0);
                ticketbooking.available_l_berths--;
                
                

            }
            else if(p.breathPreference.equals("M"))
            {
                System.out.println("Middle Berth Given");
                //call booking function in the TicketBooker class
                booker.bookticket(p,(ticketbooking.middleberth.get(0)),"M");
                //remove the booked position from available positions and also decrease available seats of that
                // particular type
                ticketbooking.middleberth.remove(0);
                ticketbooking.available_m_berths--;

            }
            else if(p.breathPreference.equals("U"))
            {
                System.out.println("Upper Berth Given");
                //call booking function in the TicketBooker class
                booker.bookticket(p,(ticketbooking.upperberth.get(0)),"U");
                //remove the booked position from available positions and also decrease available seats of that
                // particular type
                ticketbooking.upperberth.remove(0);
                ticketbooking.available_u_berths--;
            }

        }
        //preference not available -> book the available berth
       
        else if(ticketbooking.available_l_berths > 0)
        {
            System.out.println("Lower Berth Given");
            //call booking function in the TicketBooker class
            booker.bookticket(p,(ticketbooking.lowerberth.get(0)),"L");
            //remove the booked position from available positions and also decrease available seats of that
            // particular type
            ticketbooking.lowerberth.remove(0);
            ticketbooking.available_l_berths--;
            

        }
        else if(ticketbooking.available_m_berths > 0)
        {
            System.out.println("Middle Berth Given");
            //call booking function in the TicketBooker class
            booker.bookticket(p,(ticketbooking.middleberth.get(0)),"M");
            //remove the booked position from available positions and also decrease available seats of that
            // particular type
            ticketbooking.middleberth.remove(0);
            ticketbooking.available_m_berths--;

        }
        else if(ticketbooking.available_u_berths > 0)
        {
            System.out.println("Upper Berth Given");
            //call booking function in the TicketBooker class
            booker.bookticket(p,(ticketbooking.upperberth.get(0)),"U");
            //remove the booked position from available positions and also decrease available seats of that
            // particular type
            ticketbooking.upperberth.remove(0);
            ticketbooking.available_u_berths--;
            
        }
        // if no berth available go to RAC
        else if(ticketbooking.availableRacTickets > 0)
        {
            System.out.println("RAC available");
            booker.addToRAC(p,(ticketbooking.racPositions.get(0)),"RAC" );
        }
        // if no RAC available go to WL
        else if(ticketbooking.availableWaitingList > 0)
        {
            System.out.println("Added to Waiting List");
            booker.addToWaitingList(p,(ticketbooking.waitingListPositions.get(0)),"WL");
            
        }}
    public static void cancelTicket(int id)
    {
        ticketbooking booker = new ticketbooking();
        //check if passenger id is valid
        if(!booker.passengers.containsKey(id))
        {
            System.out.println("Passenger detail Unknown");
        }
        else
            booker.cancelTicket(id);
    }
        public static  void main(String[] args)
        {
            Scanner ss=new Scanner(System.in);
            boolean loop=true;
            while(loop)
            {
                System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
                int choice=ss.nextInt();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.println("Enter Passenger name,age and berth preference (L,M or U)");
                        String name = ss.next();
                        int age = ss.nextInt();
                        String berthPreference = ss.next();
                        passenger p=new passenger(name,age,berthPreference);
                        bookticket(p);
                        System.out.println("-----------Booked Successfully------------");
                        break;       
                    }
                    case 2:
                    {
                    System.out.println("Enter passenger Id to cancel");
                    int id = ss.nextInt();
                     
                    }break;
                    case 3:
                    {
                        ticketbooking b=new ticketbooking ();
                        b.printAvailable();
                    }break;
                    case 4:
                    {
                          ticketbooking b = new ticketbooking();
                            b.printPassengers();
                    }break;
                    case 5:
                    {
                        loop=false;
                    }
                    break;
                    default:
                        break;
                        
                }
                
            }
        }
        }
        
    
    
   
    

