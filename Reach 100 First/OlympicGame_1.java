import java.util.Scanner; 
import java.util.Random; 

class OlympicGame_1
{ 
    int playGame (String name, int score)
    {
        int toss;
        toss = (new Random()).nextInt(2);
        
        if (toss==0) // Head
        {
            score = score+2; // Up 2 steps
            System.out.println(name + " : Head : Pos = " +score);
        }
        else // Tails
        {
            score = score-1; // Down 1 step
            System.out.println(name + " : Tails : Pos = " +score);
        }
        return score;
    }
    
    public static void main (String [] args)
    { 
        int first; 
        
        char ch='Y';
        Scanner sc = new Scanner(System.in);
        
        String[] user = {"You", "Your Friend"}; // You:0, Friend:1
        int[] pos = {50, 50};
        
        System.out.println ("Who play first , You (0) / Your Friend (1) : (0/1) ?");
        first = sc.nextInt(); // Choose who play first
        
        sc.nextLine(); // To avoid buffer issue
        OlympicGame ob = new OlympicGame();
        
        while (ch=='Y') 
        { 
            System.out.println ("Do you want to play, (Y/N) ?"); 
            ch=sc.nextLine().charAt(0); // Choice
            
            if (ch =='Y') // Play
            { 
                for (int i=0; i<2; i++)
                {
                    pos [first] = ob.playGame (user[first], pos[first]);
                    
                    if (pos[first] >= 100)
                    {
                        System.out.println ("Reached TOP, "+ user[first] +" WINS !");
                        ch = 'N';
                        break; //exits for loop
                    }
                    else if (pos[first] <= 0)
                    {
                        System.out.println ("Reached BOTTOM, "+ user[first] +" OUT !");
                        ch = 'N';
                        break; // exits for loop
                    }
                    first = (first+1)%2;
                }
                System.out.println ("-------------------------------------------");
            } 
            else // Quit => ch='N'
            {
                System.out.println ("Quitted At => You : "+ pos[0]+ " || Your Friend : "+ pos[1]);
                break; // exits while loop;
            }
        } // end of while()
            
    } // End of main()
}
