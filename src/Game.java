import java.util.Scanner;

public class Game
{
    private Player player;
    private Generator generator;

    // This represents the exit the player chooses to go through (depending on their input)
    private Exit targetExit;

    private void Init()
    {
        generator = new Generator();
        generator.GenerateRooms();
        player = new Player(generator.GetRooms().get(0));
    }

    public void Play()
    {
        Init();

        // Intro to Game

        System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries. You can navigate by using the entire direction or just the first letter.");
        System.out.println("To exit(X) the game, enter X");

        Scanner input = new Scanner(System.in);

        // As long as this boolean is true the game will keep running

        boolean run = true;

        while (run)
        {
            PrintCurrentRoom();

            if(!IsLastRoom(player.GetCurrentRoom()))
            {
                System.out.println("What direction would you like to go?");

                String direction = input.nextLine();

                // As long as the player doesn't enter x/X
                // or the player's current room isn't the last room (finish) we move the player

                if(!direction.equalsIgnoreCase("X"))
                {
                    Move(direction);
                }
                else
                {
                    run = false;
                }
            }
            else
            {
                run = false;
            }
        }
    }

    private boolean IsValidMove(String input)
    {
        // Represents the first letter of the player's input

        String letter = String.valueOf(input.charAt(0));

        for(Exit e : player.GetCurrentRoom().GetExits())
        {
            // If the player inputs a direction that appropriately corresponds with an exit

            if(input.equalsIgnoreCase(e.GetDirection()))
            {
                targetExit = e;
                return true;
            }

            // If the player inputs a letter that corresponds with the first letter of an exit

            if(input.length() == 1 && letter.equalsIgnoreCase(String.valueOf(e.GetDirection().charAt(0))))
            {
                targetExit = e;
                return true;
            }
        }

        return false;
    }

    private void Move(String input)
    {
        if(IsValidMove(input))
        {
            for(Room room : generator.GetRooms())
            {
                if(room.GetRoomID() == targetExit.GetDestination())
                {
                    player.SetCurrentRoom(room);
                    room.SetVisitation(true);
                    break;
                }
            }
        }
        else
        {
            System.out.println("Invalid direction entered.");
        }
    }

    private void PrintCurrentRoom()
    {
        System.out.println("Name: " + player.GetCurrentRoom().GetName() + ", Has Visited? " + player.GetCurrentRoom().HasVisited());

        for(String s : player.GetCurrentRoom().GetDescription())
        {
            System.out.println(s);
        }

        System.out.println("You can go: ");

        for(int i = 0; i < player.GetCurrentRoom().GetExits().size(); i++)
        {
            System.out.println(player.GetCurrentRoom().GetExits().get(i).GetDirection());
        }
    }

    // Determines whether the player has reached the end of the maze or not (aka last room)
    private boolean IsLastRoom(Room room){ return room == generator.GetRooms().get(generator.GetRooms().size() - 1); }
}
