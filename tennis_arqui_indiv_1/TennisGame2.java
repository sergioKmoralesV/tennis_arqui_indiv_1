
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
        calculateLiteralScoreForTiedButNotDeuce();
        calculateLiteralScoreForDeuce();
        getScoreAvoidingSpecialCases();
        calculateLiteralScoreForAdvantage();
        calculateLiteralScoreForWinner();
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
    
    
    private String getLiteralPoints(int playerScore){
    	return scoreEquivalences[playerScore];
    }
    
    private String getLiteralScore(){
    	return getLiteralPoints(player1Points)+"-"+getLiteralPoints(player2Points);
    }
    
    private void calculateLiteralScoreForTiedButNotDeuce(){
    	 if (isTied() && hasScoreLessOrEqualThanForty(player1Points))
             score = getLiteralPoints(player1Points)+"-All";
    }
    
    private void calculateLiteralScoreForDeuce(){
    	if (isTied() && player1Points>=3)
            score = "Deuce";
    }
    
    private void calculateLiteralScoreForWinner(){
    	if (!hasScoreLessOrEqualThanForty(player1Points) &&  hasDifferenceOfTwoOrMore(player1Points,player2Points))
            score = "Win for player1";
        if (!hasScoreLessOrEqualThanForty(player2Points) && hasDifferenceOfTwoOrMore(player2Points,player1Points))
            score = "Win for player2";
     }
    
    private void calculateLiteralScoreForAdvantage(){
        if (player1Points > player2Points && hasScoreMoreOrEqualThanForty(player2Points))
            score = "Advantage player1";
        if (player2Points > player1Points && hasScoreMoreOrEqualThanForty(player1Points))
            score = "Advantage player2";
    }
    
    private void getScoreAvoidingSpecialCases(){
    	if (!isTied() && hasScoreLessOrEqualThanForty(player1Points) && hasScoreLessOrEqualThanForty(player2Points) )
    	    score=getLiteralScore();
    }
    
    private boolean hasDifferenceOfTwoOrMore(int highestPoints, int lowestPoints){
    	return (highestPoints-lowestPoints)>=2;
    }
    
    private boolean hasScoreMoreOrEqualThanForty(int playerPoints){
    	return playerPoints>=3;
    }
    private boolean hasScoreLessOrEqualThanForty(int playerPoints){
    	return playerPoints<=3;
    }
    private boolean isTied(){
    	return player1Points == player2Points;
    }
}