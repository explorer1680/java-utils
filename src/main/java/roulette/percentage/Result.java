package roulette.percentage;

public enum Result {
    WIN(18f/37f), LOSS(19f/37f);
    private final float possibility;

    private Result(float p){
        this.possibility = p;
    }

    public float getPossibility(){
        return this.possibility;
    }

}
