package com.task21.strategies;

/**
 * Created by Vlad on 08.03.2017.
 */
public class MixStrategy implements Strategy{
    /*flying strategy obj*/
    private FlyingStrategy flyingStrategy;
    /*foot strategy obj*/
    private FootStrategy footStrategy;
    /*preferable strategy type*/
    private SimpleStrategyType prefSimpleStrategyType = SimpleStrategyType.FOOT;

    /**
     * Default constructor
     */
    public MixStrategy() {
        this.flyingStrategy=new FlyingStrategy();
        this.footStrategy=new FootStrategy();
    }

    /**
     * Constructor
     * @param simpleStrategyType preferable strategy type
     */
    public MixStrategy(SimpleStrategyType simpleStrategyType) {
        this();
        this.setPrefSimpleStrategyType(simpleStrategyType);
    }

    /*getter prefSimpleStrategyType*/
    public SimpleStrategyType getPrefSimpleStrategyType() {
        return prefSimpleStrategyType;
    }
    /*setter prefSimpleStrategyType*/
    public void setPrefSimpleStrategyType(SimpleStrategyType prefSimpleStrategyType) {
        if(prefSimpleStrategyType ==null)
            throw new IllegalArgumentException();

        this.prefSimpleStrategyType = prefSimpleStrategyType;
    }

    @Override
    public void flyWithMagic() {
        System.out.println("Fly with magic");
        move(SimpleStrategyType.FLY);
    }

    @Override
    public void move() {
        move(prefSimpleStrategyType);
    }

    public void move(SimpleStrategyType type) {
        if(type==null)
            throw new IllegalArgumentException();
        switch (type){
            case FLY : flyingStrategy.move(); break;
            case FOOT : footStrategy.move(); break;
            default : footStrategy.move();
        }
    }

}
