import java.util.Scanner;

/**
 * Created by Roman on 08/04/2017.
 */

/*
Represent the user.
Read on the stdin.
 */

public class User
{
    User()
    {
        stdin = new Scanner(System.in);
    }

    private CommandFull parseArgumentGenerate(Scanner stdin)
    {
        int sizex;
        int sizey;
        CommandFull retval = new CommandFull();

        if (!stdin.hasNextInt())
        {
            System.out.println("Bad arguments");
            return null;
        }
        sizex = stdin.nextInt();
        if (!stdin.hasNextInt())

        {
            System.out.println("Bad arguments");
            return null;
        }
        sizey = stdin.nextInt();
        retval.command = Command.generateSet;
        retval.size.x = sizex;
        retval.size.y = sizey;
        return  retval;
    }

    private CommandFull parseArgumentDisplay(Scanner stdin)
    {
        CommandFull retval = new CommandFull();
        retval.command = Command.generateSet;
        return  retval;
    }

    private CommandFull parseArgumentDelete(Scanner stdin)
    {
        CommandFull retval = new CommandFull();
        retval.command = Command.deleteSet;
        return  retval;
    }

    private CommandFull parseArgumentCount(Scanner stdin)
    {
        CommandFull retval = new CommandFull();

        if (!stdin.hasNextInt())
        {
            System.out.println("Bad arguments");
            return null;
        }
        retval.id = stdin.nextInt();
        retval.command = Command.countIsland;
        return  retval;
    }

    CommandFull getCommand()
    {
        String rawCommand;
        CommandFull retval = null;

        System.out.println("\nUsage : You can enter command\n" +
                "generateSet sizeX sizeY\n" +
                "displaySet\n" +
                "deletetSet\n" +
                "countIsland ID\n");
        System.out.printf("$> ");
        rawCommand = stdin.next();
        switch (rawCommand) {
            case "generateSet":
                retval = parseArgumentGenerate(stdin);
                break;
            case "displaySet":
                retval = parseArgumentDisplay(stdin);
                break;
            case "deleteSet":
                retval = parseArgumentDelete(stdin);
                break;
            case "countIsland":
                retval = parseArgumentCount(stdin);
                break;
        }

        if (retval == null)
            retval = getCommand();
        return retval;
    }

    private Scanner stdin;
}
