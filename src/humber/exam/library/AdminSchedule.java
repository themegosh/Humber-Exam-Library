/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

/**
 *
 * @author mathe_000
 */
public class AdminSchedule extends Schedule {
    
    public AdminSchedule() {
        super();
    }
    
    public void removeTimeSlot(Period period)
    {
        schedule.remove(period);
    }

    public void addTimeSlot(Period period, int startHour, int startMin, int endHour, int endMin)
    {

        if (schedule.containsKey(period))
        {
            System.err.println("Slot already exists. Please delete slot or choose an unoccupied slot");
        }
        else
        {
            SchedulePeriod newPeriod = new SchedulePeriod(startHour, startMin, endHour, endMin);
            schedule.put(period, newPeriod);
        }
    }

    public void changeSlotStartTime(Period period, int numOfHours, int numOfMin)
    {
        schedule.get(period).changeStartTime(numOfHours, numOfMin);
    }

    public void changeSlotEndTime(Period period, int numOfHours, int numOfMin)
    {
        schedule.get(period).changeEndTime(numOfHours, numOfMin);
    }

    
}
