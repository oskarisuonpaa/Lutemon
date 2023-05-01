package com.example.lutemon.lutemon;


public class Lutemon {
    protected String name;
    protected String color;
    protected int type;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int experience;
    protected int experienceCap;
    protected int health;
    protected int maxHealth;
    protected int level;
    protected int id;
    private static int idCounter = 0;
    protected boolean isAlive;
    private double[][] typeMatchMatrix = { { 0.5, 0.5, 2, 0.5, 1 }, { 2, 0.5, 0.5, 2, 1 }, { 0.5, 2, 0.5, 2, 1 },
            { 2, 1, 1, 0.5, 1 }, { 1, 2, 0.5, 1, 0.5 } };
    private String[] types = {"Fire", "Water", "Grass", "Rock", "Electric"};
    private long startedTraining;
    private long nextExperienceGain;

    public Lutemon(String name, String color, int type, int attack, int defense, int speed, int maxHealth) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHealth = maxHealth;

        this.experience = 0;
        this.experienceCap = 10;
        this.health = maxHealth;
        this.level = 1;

        this.id = idCounter;
        idCounter++;

        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTypeString() {
        return types[type];
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public int getExperience() {
        return experience;
    }
    public int getExperienceCap() {
        return experienceCap;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getLevel() {return level;}

    public int getId() {
        return id;
    }

    public long getStartedTraining() {
        return startedTraining;
    }

    public void setStartedTraining(long startedTraining) {
        this.startedTraining = startedTraining;
    }

    public long getNextExperienceGain() {
        return nextExperienceGain;
    }

    public void setNextExperienceGain(long nextExperienceGain) {
        this.nextExperienceGain = nextExperienceGain;
    }

    public void gainExperience(int amount) {
        this.experience++;
        if(experience >= experienceCap) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        attack++;
        defense++;
        speed++;
        experience -= experienceCap;
        experienceCap += 10;
    }
}
