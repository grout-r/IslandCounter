import java.util.ArrayList;

/**
 * Created by Roman on 08/04/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        User user = new User();
        MapSet set = new MapSet();
        CommandFull command;

        while (true)
        {
            command = user.getCommand();
            switch (command.command)
            {
                case generateSet:
                    set.generateMaps(command);
                    System.out.println("Done");
                    break;
                case displaySet:
                    if (!set.isEmpty())
                        set.displaySet();
                    else
                        System.out.println("Please generate a set first.");
                    break;
                case deleteSet:
                    set.deleteSet();
                    break;
                case countIsland:
                    set.countIsland(command.id);
                    break;
            }

        }
    }

}
