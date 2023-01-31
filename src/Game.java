import java.util.List;
import java.util.Scanner;

public class Game
{
    private Player player;
    private Generator generator;

    public void Init()
    {
        generator = new Generator();
        generator.GenerateRooms();
        player = new Player(generator.GetRooms().get(0).GetRoomID());
    }

    public void Play()
    {
        Init();
    }

    private boolean IsValidMove(String input)
    {
        return false;
    }

    private void Move()
    {

    }

    private void PrintCurrentRoom()
    {

    }
}
