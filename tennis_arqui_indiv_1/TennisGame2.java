
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
    
    public String getScore(){
        reviewForEqualPoints();
        reviewForDeuce();
        getScoreAvoidingSpecialCases();
        reviewForAdvantagePoint();
        reviewForWinner();
        return score;
    }
    
    public void setPlayer1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1Scores();
        }
            
    }
    
    public void setPlayer2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2Scores();
        }
            
    }
    
    public void player1Scores(){
        player1Points++;
    }
    
    public void player2Scores(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Scores();
        else
            player2Scores();
    }
    
    
    private String getEquivalence(int playerScore){
    	return scoreEquivalences[playerScore];
    }
    
    private String getEquivalentScore(){
    	return getEquivalence(player1Points)+"-"+getEquivalence(player2Points);
    }
    
    private void reviewForEqualPoints(){
    	 if (player1Points == player2Points && player1Points < 4)
         {
             score = getEquivalence(player1Points)+"-All";
         }
    }
    
    private void reviewForDeuce(){
    	if (isTied() && player1Points>=3)
            score = "Deuce";
    }
    
    private void reviewForWinner(){
    	if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
    }
    
    private void reviewForAdvantagePoint(){
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
    }
    
    private void getScoreAvoidingSpecialCases(){
    	if (!isTied() && hasScoreLessOrEqualThanForty(player1Points) && hasScoreLessOrEqualThanForty(player2Points) )
    	{
            score=getEquivalentScore();
    	}
    }
    
    private boolean hasScoreLessOrEqualThanForty(int playerScore){
    	return playerScore<4;
    }

    private boolean isTied(){
    	return player1Points == player2Points;
    }
}