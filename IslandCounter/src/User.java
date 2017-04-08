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

    private void parseArgumentGenerate(Scanner wordExtractor)
    {
        int sizex;
        int sizey;

        sizex = wordExtractor.nextInt();
        sizey = wordExtractor.nextInt();
        System.out.println(sizex);
        System.out.println(sizey);

//        while (wordExtractor.hasNext())
//        {
//
//        }
    }

    public CommandFull getCommand()
    {
        String buffer = stdin.next();
        Scanner wordExtractor = new Scanner(buffer);
        String rawCommand = wordExtractor.next();

        switch (rawCommand) {
            case "generateSet":
                parseArgumentGenerate(wordExtractor);
                break;
            case "displaySet":

                break;
            case "deleteSet":

                break;
            case "countIsland":

                break;
        }


        return new CommandFull();
    }

    private Scanner stdin;
}
