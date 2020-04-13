import java.util.Random;
class RockPaperScissor
{
	String[] choice;
	int[][] point;
	RockPaperScissor()
	{
		choice = new String[4];
		point = new int[4][4];
		for(int i=0;i<4;i++)
		{
			for (int j=0;j<4;j++ )
			{
				if (i==j)
					point[i][j]=-1;
				else
					point[i][j]=0;
			}
		}
		for (int i=0;i<4;i++)
			choice[i] = "";
	}

	void assignChoice()
	{
		for (int i = 0 ;i<4; i++)
		{
			choice[i]=getChoice();	
		}
	}

	String getChoice()
	{
        Random rand = new Random();
        int x = rand.nextInt(3)+1;
        String ch;
        if (x == 1)
            ch = "ROCK";
        else if(x == 2)
            ch = "PAPER";
        else
            ch = "SCISSORS";
        
        return ch; 
	}

	void updateWin()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=i+1;j<4 ;j++)
			{
				int x = checkWinner(choice[i],choice[j]);
				if(x==-1)
					point[j][i]++;
				else
					point[i][j] += x;
			}
		}	
	}

	int checkWinner(String x,String y)
	{
		if (x=="ROCK")
		{
			if(y=="PAPER")
        	    return -1;
        	else if(y=="SCISSORS")
        		return 1;
        	else
        		return 0;
		}
		else if (x=="PAPER")
		{
			if(y=="PAPER")
        	    return 0;
        	else if(y=="SCISSORS")
        		return -1;
        	else
        		return 1;
		}
		else
		{
			if(y=="PAPER")
        	    return 1;
        	else if(y=="SCISSORS")
        		return 0;
        	else
        		return -1;
		}
	}

	void display(int n)
	{
		System.out.println("Iteration-"+n);
		System.out.println("\t\t"+"Choices......");
		System.out.println("Player1\tPlayer2\tPlayer3\tPlayer4");
		for (int i=0;i<4;i++)
			System.out.print(choice[i]+"\t");
		System.out.println();
		System.out.println();
		System.out.println("\t\t"+"Total Points");
		System.out.println("Player\tPlayer1\tPlayer2\tPlayer3\tPlayer4");
		for(int i=0;i<4;i++)
		{
			System.out.print("Player"+(i+1));
			for (int j=0;j<4;j++ )
			{
				if(i==j)
					System.out.print("\t-");
				else
					System.out.print("\t"+point[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}

class GameApp
{
	public static void main(String[] args)
	{
		RockPaperScissor rps = new RockPaperScissor();
		for (int i = 1; i <= 50 ; i++ )
		{
			rps.assignChoice();
			rps.updateWin();
			rps.display(i);
		}

	}
}