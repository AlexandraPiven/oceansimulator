package tj.piven.coreapp.oceansimulator.util;

import tj.piven.coreapp.oceansimulator.model.Dolphin;

public class EventProducer {
    // 19% дельфин поспал - +20 энергии
    //9% дельфин просто проплыл - 7 энергии
    //9% дельфин съел водоросли - 5 энергии; + 8 здоровья
    //9% дельфин съел рыбу - 10 энергии; + 10 здоровья
    //9% на дельфина напала акула - 20 здоровья
    //9% дельфин попал в шторм - -20 энергии
    //9% дельфин поднялся на поверхность - +10 энергии
    //9% дельфин влюбился - +20 энергии
    //9% дельфин встретил браконьеров - -30 энергии
    //9% дельфин заболел - -15 энергии
    //энергия = 0 до -5 здоровья

    public void startSimulation(Dolphin dolphin) {
        while (checkStatus(dolphin)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 19) {
                sleepEvent(dolphin);
            } else if (eventNumber >= 19 && eventNumber < 28) {
                swimEvent(dolphin);
            } else if (eventNumber >= 28 && eventNumber < 37) {
                eatAlgaeEvent(dolphin);
            } else if (eventNumber >= 37 && eventNumber < 46) {
                eatFish(dolphin);
            } else if (eventNumber >= 46 && eventNumber < 55) {
                sharkAttack(dolphin);
            } else if (eventNumber >= 55 && eventNumber < 64) {
                storm(dolphin);
            } else if (eventNumber >= 64 && eventNumber < 73) {
                surface(dolphin);
            } else if (eventNumber >= 73 && eventNumber < 82) {
                fallInLove(dolphin);
            } else if (eventNumber >= 82 && eventNumber < 91) {
                poacherEncounter(dolphin);
            } else if (eventNumber >= 91 && eventNumber < 100) {
                fellIll(dolphin);
            }
        }
        System.out.println("Волк умер!");


    }

    private void sleepEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy + 20;
        if (energy > 100) ;
        energy = 100;
        dolphin.setEnergy();
        checkEnergy(dolphin);
        System.out.println("Дельфин поспал! + 20 энергии. Текущая энергия " + dolphin.getEnergy());
    }

    private void swimEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy - 7;
        if (energy < 0) ;
        energy = 0;
        dolphin.setEnergy();
        checkEnergy(dolphin);
        System.out.println("Дельфин поплавал! -7 энергии. Текущая энергия " + dolphin.getEnergy());
    }

    private void eatAlgaeEvent(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 5;
        health = health + (int) (dolphin.getFINS() * 2);
        if (energy < 0) ;
        energy = 0;
        if (health > 100) ;
        health = 100;
        dolphin.setEnergy();
        dolphin.setHealth();
        checkEnergy(dolphin);
        System.out.println("Дельфин поел водоросли! -5 энергии. Текущая энергия " + dolphin.getEnergy() + "Текущее здоровье " + dolphin.getHealth());

    }

    private void eatFish(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        int health = dolphin.getHealth();
        energy = energy - 10;
        health = health + (int) (dolphin.getFINS() * 2);
        if (energy < 0) ;
        energy = 0;
        if (health > 100) ;
        health = 100;
        dolphin.setEnergy();
        dolphin.setHealth();
        checkEnergy();
        System.out.println("Дельфин поел рыбу - 10 энергии. Текущая энергия " + dolphin.getEnergy() + "Текущее здоровье " + dolphin.getHealth());
    }

    private void sharkAttack(Dolphin dolphin) {
        int health = dolphin.getHealth();
        health = health - 20;
        if (health < 0) ;
        health = 0;
        dolphin.setHealth();
        checkEnergy(dolphin);
        System.out.println("На дельфина напала акула! - 20 энергии. Текущая энергия " + dolphin.getEnergy());
    }

    private void storm(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy - 20;
        if (energy < 0) ;
        energy = 0;
        dolphin.setEnergy();
        checkEnergy(dolphin);
        System.out.println("Дельфин попал в шторм! - 20 энергии. Текущая энергия " + dolphin.getEnergy());
    }

    private void surface(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy + 10;
        if (energy > 100) ;
        energy = 100;
        dolphin.setEnergy();
        checkEnergy(dolphin);
        System.out.println("Дельфин поднялся на поверхность  + 10 энергии" + dolphin.getEnergy());
    }

    private void fallInLove(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy + 20;
        if (energy > 100) ;
        energy = 100;
        dolphin.setEnergy();
        checkEnergy();
        System.out.println("Дельфин влюбился + 20 энергии" + dolphin.getEnergy());
    }

    private void poacherEncounter(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy - 30;
        if (energy < 0) ;
        energy = 0;
        dolphin.setEnergy();
        checkEnergy();
        System.out.println("Дельфин встретил браконьеров - 30 энергии" + dolphin.getEnergy());
    }

    private void fellIll(Dolphin dolphin) {
        int energy = dolphin.getEnergy();
        energy = energy - 15;
        if (energy < 0) ;
        energy = 0;
        dolphin.setEnergy();
        checkEnergy();
        System.out.println("Дельфин заболел - 15 энергии" + dolphin.getEnergy());
    }

    private boolean checkStatus(Dolphin dolphin) {
        System.out.println("hp: " + dolphin.getHealth() + "energy: " + dolphin.getEnergy());
        if (dolphin.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }

    }

    private void checkEnergy(Dolphin dolphin) {
        if (dolphin.getEnergy() <= 0) {
            int health = dolphin.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            dolphin.setHealth(health);
        }
    }
}
