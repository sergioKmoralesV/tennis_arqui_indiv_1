
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    public String score = "";
    private String player1Name;
    private String player2Name;
    private String[] scoreEquivalences = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getEquivalence(int score){
    	return scoreEquivalences[score];
    }
    public String getEquivalentScore(){
    	return getEquivalence(player1Points)+"-"+getEquivalence(player2Points);
    }
    public void reviewForEqualPoints(){
    	 if (player1Points == player2Points && player1Points < 4)
         {
             score = getEquivalence(player1Points)+"-All";
         }
    }
    public void reviewForDeuce(){
    	if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
    }
    public void reviewForWinner(){
    	if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
    }

    public void reviewForAdvantagePoint(){
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }

        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
    }

    public void getScoreAvoidingSpecialCases(){
    	if (player1Points != player2Points && player1Points<4 && player2Points<4 )
    	{
            score=getEquivalentScore();
    	}
    }
    public String getScore(){
        reviewForEqualPoints();
        reviewForDeuce();
        getScoreAvoidingSpecialCases();
        reviewForAdvantagePoint();
        reviewForWinner();
        return score;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        player1Points++;
    }

    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
