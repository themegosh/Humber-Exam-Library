package scheduletest;

public class Room {
    
    private String buildingID;
    private String roomID;
    private boolean classroom;

    public Room(String buildingID, String roomID, boolean classroom) {
        this.buildingID = buildingID;
        this.roomID = roomID;
        this.classroom = classroom;
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
    
    
}