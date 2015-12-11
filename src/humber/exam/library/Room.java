package humber.exam.library;

public class Room {
    
    private String buildingID;
    private String roomID;
    private boolean classroom;

    public Room(String buildingID, String roomID, boolean classroom) {
        this.buildingID = buildingID;
        this.roomID = roomID;
        this.classroom = classroom;
    }
    
    public Room(){
        this.buildingID = "";
        this.roomID = "";
        this.classroom = false;        
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public boolean isClassroom() {
        return classroom;
    }

    public void setClassroom(boolean classroom) {
        this.classroom = classroom;
    }
    
    public String toString() {
        return roomID;
    }
    
    
}