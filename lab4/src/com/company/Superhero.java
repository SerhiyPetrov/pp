package com.company;


package Superhero;
import java.util.Random;
public class Superhero {
    private String name;
    private int health;
    private int damageMin;
    private int damageMax;
    private int armor;
    private int regeneration;
    private String logo;
    private boolean isDead;
    public Superhero(String name, int health, int damageMin, int damageMax, int armor, int
            regeneration, String logo) {
        this.name = name;
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.armor = armor;
        this.regeneration = regeneration;
        this.logo = logo;
    }
    public Superhero() {}
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamageMin() {
        return damageMin;
    }
    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }
    public int getDamageMax() {
        return damageMax;
    }
    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getRegeneration() {
        return regeneration;
    }
    public void setRegeneration(int regeneration) {
        this.regeneration = regeneration;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public boolean isDeath() {
        return isDead;
    }
    public void setDeath(boolean death) {
        this.isDead = death;
    }
    public void attack(Superhero hero){
        Random randomNumber = new Random();
        int damageTaken = 1 + randomNumber.nextInt(hero.getDamageMax() -
                hero.getDamageMin()+1);
        System.out.println(hero.getLogo() + "\t" + hero.getName() + " has taken a hit from
                opponent ");
                hero.determineHealth(damageTaken , hero);
        hero.regenerationOfHealth(hero);
        System.out.println(hero.getLogo() + "\t" + "The health of " + hero.getName() + "
                is now " + hero.getHealth());
    }
    public void determineHealth(int damageTaken , Superhero hero){
        if (this.getHealth()-damageTaken<=0){
            this.setHealth(0);
            this.setDeath(true);
        }
        else{
            switch(this.probabilityOfArmor(hero)){
                case 1 : System.out.println(hero.getLogo() + "\t" + "The armor saved from
                        damage ");
                    break;
                case 2 : this.setHealth(this.health - damageTaken);
                    break;
            }
        }
    }
    public int probabilityOfArmor(Superhero hero) {
        Random rand = new Random();
        int bin = 1 + rand.nextInt( hero.getArmor() - 1 + 1);
        if (bin == 1) {
            return 1;
        }
        else {
            return 2;
        }
    }
    public int probabilityOfRegeneration(){
        Random rand = new Random();
        int numb = 1 + rand.nextInt(5 - 1 + 1);
        if (numb == 1) {
            return 1;
        }
        else{
            return 0;
        }
    }
    public void regenerationOfHealth(Superhero hero){
        Random rand = new Random();
        int regeneratedHealth = 1 + rand.nextInt( this.getRegeneration()- 1 + 1);
        if (this.probabilityOfRegeneration() == 1){
            this.setHealth(this.health + regeneratedHealth);
            System.out.println(hero.getLogo() + "\t" + hero.getName() + " regenerates his
                    health on " + regeneratedHealth);
        }
    }
}