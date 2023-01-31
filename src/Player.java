public class Player
{
    private int currentRoom;

    public Player()
    {
        // For an empty player
    }

    public Player(int currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public void SetCurrentRoom(int roomID){ this.currentRoom = roomID; }

    public int GetCurrentRoom(){ return this.currentRoom; }
}
