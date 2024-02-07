package roulette.strategy;

public class Add1WhenLossMinus1WhenWin extends  AmountStrategy{

    private static final int initBed = 5;

    private int bed;

    public Add1WhenLossMinus1WhenWin(){
        this.bed = Add1WhenLossMinus1WhenWin.initBed;
    }
    @Override
    public int betAmount() {
        return bed;
    }

    @Override
    public void isLostInLastBet(boolean isLost) {
        if(isLost){
            bed++;
        }else {
            bed--;
            if(bed == 0){
                System.out.println("--------------------------win a cycle--------------------------------");
                bed = Add1WhenLossMinus1WhenWin.initBed;
            }
        }
    }

}
