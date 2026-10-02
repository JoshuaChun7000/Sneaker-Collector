import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;




public class Collector {
    Sneaker none = new Sneaker("None", "", 0,
            0, true, "", 0);
    public ArrayList<Sneaker> ownedShoes;
    private final String name;
    private double money;
    private Sneaker wearingSneaker;
    private double physicalHealth;
    private int confidenceLevel;
    private int maxBench;
    private boolean dead;
    public Collector(String name, double money, Sneaker wearingSneaker,
                     double physicalHealth, int mentalHealth, int maxBench,
                     boolean dead, ArrayList<Sneaker> ownedShoes) {
        this.name = name;
        this.money = money;
        this.ownedShoes = ownedShoes;
        this.wearingSneaker = wearingSneaker;
        if (!(this.wearingSneaker.getBrand().equalsIgnoreCase(none.getBrand()))) {
            this.ownedShoes.add(this.wearingSneaker);
            this.wearingSneaker.setDeadstockStatus(false);
            this.wearingSneaker.setTimesWorn(1);
        }
        this.physicalHealth = physicalHealth;
        if (this.physicalHealth < 0) {
            this.physicalHealth = 0;
        }
        this.confidenceLevel = mentalHealth;
        if (this.confidenceLevel < 0) {
            this.confidenceLevel = 0;
        }
        this.maxBench = maxBench;
        if (this.maxBench < 0) {
            this.maxBench = 0;
        }
        this.dead = dead;
    }
    public String getName() {return name;}
    public double getMoney() {return money;}
    public void setMoney(double money) {
        this.money += money;
        if (this.money < 0) {
            this.money = 0;
        }
    }
    public Sneaker getWearingSneaker() {return wearingSneaker;}
    public void setWearingSneaker(Sneaker wearingSneaker) {
        if (wearingSneaker == null) {
            return;
        }
        if (wearingSneaker.equals(none)) {
            this.wearingSneaker = none;
        } else if (ownedShoes.contains(wearingSneaker)) {
            this.wearingSneaker = wearingSneaker;
            this.wearingSneaker.setDeadstockStatus(false);
            this.wearingSneaker.setTimesWorn(1);
        } else {
            System.out.println("You don't own that shoe!");
        }
    }
    public double getPhysicalHealth() {return physicalHealth;}
    public void setPhysicalHealth(double physicalHealth) {
        this.physicalHealth += physicalHealth;
        if (this.physicalHealth <= 0) {
            this.physicalHealth = 0;
            setDead(true);
        }
        if (this.physicalHealth > 100) {
            this.physicalHealth = 100;
        }
    }
    public int getConfidenceLevel() {return confidenceLevel;}
    public void setConfidenceLevel(int confidenceLevel) {
        this.confidenceLevel += confidenceLevel;
        if (this.confidenceLevel > 100) {
            this.confidenceLevel = 100;
        }
        if (this.confidenceLevel < 0) {
            this.confidenceLevel = 0;
        }
    }
    public int getMaxBench() {return maxBench;}
    public void setMaxBench(int maxBench) {
        this.maxBench += maxBench;
        if (this.maxBench < 0) {
            this.maxBench = 0;
        }
    }
    public boolean getDead() {return dead;}
    public void setDead(boolean dead) {this.dead = dead;}
    public String toString() {
        if (!getDead()) {
            return "Name: " + getName() + "\nMoney: "
                    + getMoney() + "\nPhysical health: " + getPhysicalHealth() +
                    "\nConfidence level: " + getConfidenceLevel() +
                    "\nMax Bench: " + getMaxBench() +
                    "\nWearing: " + getWearingSneaker();
        } else {
            return "Name: " + getName() + "\nBros dead\n";
        }
    }
    public void deleteFromCollection(Sneaker sneaker) {
        if (!(Objects.equals(sneaker.getBrand(), none.getBrand()))) {
            if (ownedShoes.contains(sneaker)) {
                ownedShoes.remove(sneaker);
                if (getWearingSneaker() == sneaker) {
                    setWearingSneaker(none);
                }
            }
        }
    }
    public Sneaker findMostExpensive(ArrayList<Sneaker> shoes) {
        if (!(shoes.isEmpty())) {
            Sneaker pricey = shoes.getFirst();
            for (Sneaker s : shoes) {
                if (s.getRetailPrice() >= pricey.getRetailPrice()) {
                    pricey = s;
                }
            }
            System.out.println("\nMost expensive shoe in " + getName() + "'s collection: \n" +
                    pricey);
            return pricey;
        } else {
            System.out.println("\n" + getName() + " doesn't have shoes");
            return null;
        }
    }
    public Sneaker findMostCheap(ArrayList<Sneaker> shoes) {
        if (!(shoes.isEmpty())) {
            Sneaker cheap = shoes.getFirst();
            for (Sneaker s : shoes) {
                if (s.getRetailPrice() <= cheap.getRetailPrice()) {
                    cheap = s;
                }
            }
            System.out.println("\nCheapest shoe in " + getName() + "'s collection:");
            return cheap;
        } else {
            System.out.println("\n" + getName() + " doesn't have shoes");
            return null;
        }
    }
    public ArrayList<Sneaker> listAll() {
        if (ownedShoes.isEmpty()) {
            System.out.println(getName() + " doesn't have any sneakers");
        } else {
            System.out.println("\nShoes in " + getName() + "'s collection");
        }
        return ownedShoes;
    }
    public void assault(Collector target) {
        System.out.print(getName() + " tries jumping " + target.getName() + "\n");
        if (getConfidenceLevel() >= 50) {
            double rawDamage = getMaxBench() * 0.25;
            double shoeBuff = getWearingSneaker().getRetailPrice() * 0.25;
            double attackDamage = rawDamage + shoeBuff;
            double enemyRawDamage = target.getMaxBench() * 0.25;
            if (attackDamage >= enemyRawDamage) {
                target.setPhysicalHealth(-attackDamage);
                if (target.getPhysicalHealth() == 0) {
                    setMoney(target.getMoney());
                    target.setMoney(-target.getMoney());
                    target.setDead(true);
                    System.out.println(getName() + " killed " + target.getName() +
                            ". " + getName() + " stole all of " + target.getName() +
                            "'s money\n");
                    if (Objects.equals(target.getWearingSneaker().getBrand(), "None")) {
                        System.out.println(target.getName() + " wasn't even wearing shoes!\n");
                    } else {
                        Sneaker stolenShoes = target.getWearingSneaker();
                        target.ownedShoes.remove(stolenShoes);
                        target.setWearingSneaker(none);
                        ownedShoes.add(stolenShoes);
                        System.out.println(target.getName() +
                                "'s shoes were stolen\n");
                    }
                } else {
                    setMoney(target.getMoney() * 0.5);
                    setConfidenceLevel(50);
                    target.setConfidenceLevel(-50);
                    target.setMoney(target.getMoney() * -0.5);
                    System.out.print(getName() + " beat " + target.getName() +
                            "'s ass." +
                            "\nThey also stole half of " + target.getName() + "'s money\n");
                }
            } else {
                setPhysicalHealth(-enemyRawDamage);
                if (getPhysicalHealth() == 0) {
                    target.setMoney(getMoney());
                    setMoney(-getMoney());
                    setDead(true);
                    System.out.println(target.getName() + " was way stronger, so " + getName()
                            + " was killed");
                } else {
                    target.setMoney(getMoney() * 0.5);
                    setConfidenceLevel(-50);
                    setMoney(getMoney() * -0.5);
                    System.out.print(target.getName() + " was stronger, so " + getName()
                            + " got their ass kicked. \nHalf of " + getName() +
                            "'s money was stolen.\n");
                }
            }
        } else {
            System.out.println(getName() +
                    "'s confidence is too low, so he chickened out\n");
        }
    }
    public void workout(int times) {
        if (!getDead()) {
            if (times < 0) {
                System.out.println("You can't work out that many times, so you just don't work out");
                times = 0;
            }
            int min = 0;
            int max = 11;
            int randomNum = (int) (Math.random() * (max-min + 1)) + min;
            if (times > randomNum) {
                System.out.println(getName() + " tried to work out " + times + " times." +
                        "\nTheir pectoral muscles low-key exploded\n" + getName() +
                        " fucking dies");
                setPhysicalHealth(-100000);
            } else {
                int additionalBench = 10 * times;
                setMaxBench(additionalBench);
                System.out.println(getName() + " worked out "
                        + times + " time(s), increasing their max bench by " + additionalBench +
                        "lbs.\n" + getName() + "\nMax bench: " + getMaxBench() + "\n");
            }
        } else {
            System.out.println(getName() + "'s dead, meaning they can't work out");
        }
    }
    public void goToHospital() {
        if (!getDead()) {
            System.out.println(getName() + " goes to the hospital");
            if (getMoney() >= 30) {
                System.out.println(getName() + " pays $30");
                setMoney(-30);
                setPhysicalHealth(100);
                System.out.println(getName() + "'s health back to full\n" +
                        "Money left: " + getMoney() + "\n");
            } else {
                System.out.println(getName() + " is too broke to get treatment\n");
            }
        } else {
            System.out.println((getName() + " is dead and can't go to the hospital\n"));
        }
    }
    public void getTherapy() {
        if (!getDead()) {
            System.out.println(getName() + " goes to the therapist");
            if (getMoney() >= 30) {
                System.out.println(getName() + " pays $30");
                setMoney(-30);
                setConfidenceLevel(100);
                System.out.println(getName() + "'s confidence back to full\n" +
                        "Money left: " + getMoney() + "\n");
            } else {
                System.out.println(getName() + " is too broke to get therapy\n");
            }
        } else {
            System.out.println(getName() + " is dead and can't get therapy\n");
        }
    }
    public void robBank() {
        if (!getDead()) {
            System.out.println(getName() + " tries robbing a bank");
            if (getConfidenceLevel() == 100) {
                if (getMaxBench() >= 450) {
                    setMoney(1000);
                    System.out.println(getName() + " beat everyone up, stole $1,000, " +
                            "and dipped.");
                    System.out.println(getName() + "'s money: " + getMoney() + "\n");
                } else {
                    System.out.println(getName() + " was caught by security");
                    setPhysicalHealth(-50);
                    if (!getDead()) {
                        if (getMoney() >= 1000) {
                            setMoney(-1000);
                            System.out.println(getName() + " was beaten up and fined $1,000");
                        } else {
                            System.out.println(getName() + " was beaten up");
                        }
                    } else {
                        System.out.println(getName() + " became a victim of police" +
                                " brutality");
                    }
                }
            } else {
                System.out.println("On second thought, " + getName() + " chickened out");
            }
        } else {
            System.out.println(getName() + " is dead, so they can't rob a bank");
        }
    }
    public void sellShoe(Scanner Wednesday) {
        if (ownedShoes.size() > 1) {
            for (int i = ownedShoes.size() - 1; i >= 0; i--) {
                System.out.println("Type " + i + " to sell the " + ownedShoes.get(i) + "\n" +
                        "Type any other random number to sell a different shoe");
                while (!Wednesday.hasNextInt()) {
                    String invalidInput = Wednesday.next();
                    System.out.println("'" + invalidInput + "' is not a valid integer.");
                    System.out.print("Please enter a valid integer: ");
                }
                int d = Wednesday.nextInt();
                Wednesday.nextLine();
                if (d == i) {
                    boolean sellable = false;
                    while (!sellable) {
                        System.out.println("What will you sell the shoe for?");
                        while (!Wednesday.hasNextDouble()) {
                            String invalidInput = Wednesday.next();
                            System.out.println("'" + invalidInput + "' is not a valid number.");
                            System.out.print("Please enter a valid number: ");
                        }
                        ownedShoes.get(i).setResalePrice(Wednesday.nextDouble());
                        Wednesday.nextLine();
                        double newPrice = ownedShoes.get(i).getResalePrice();
                        if (newPrice > ownedShoes.get(i).getRetailPrice()) {
                            System.out.println("""
                                   Are you crazy?
                                   Nobody is going to buy that shoe for that ridiculous price!
                                   Choose a better price!""");
                        } else {
                            sellable = true;
                            System.out.println("You successfully sell the shoe for " +
                                    ownedShoes.get(i).getResalePrice());
                            setMoney(ownedShoes.get(i).getResalePrice());
                            deleteFromCollection(ownedShoes.get(i));
                        }
                    }
                } else {
                    System.out.println("You opt out of selling the " +
                            ownedShoes.get(i).getBrand() + " " +
                            ownedShoes.get(i).getModel() + "s");
                }
            }
        } else {
            System.out.println("You don't own shoes you bum");
        }
    }
    public void buyShoe(Scanner Wednesday, ArrayList<Sneaker> sneakerStore) {
        System.out.println("You go to the sneaker store to buy sneakers\n" +
                "Pick what to buy and not buy from the sneaker store");
        for (int i = sneakerStore.size() - 1; i >= 0; i--) {
            System.out.println("Type 1 to buy the " + sneakerStore.get(i) + "\n" +
                    "Type any other random number to buy a different shoe");
            while (!Wednesday.hasNextInt()) {
                String invalidInput = Wednesday.next();
                System.out.println("'" + invalidInput + "' is not a valid integer.");
                System.out.print("Please enter a valid integer: ");
            }
            int d = Wednesday.nextInt();
            Wednesday.nextLine();
            if (d == 1) {
                if (getMoney() >= sneakerStore.get(i).getRetailPrice()) {
                    System.out.println("You successfully bought the shoes for $" +
                            sneakerStore.get(i).getRetailPrice());
                    setMoney(-sneakerStore.get(i).getRetailPrice());
                    Sneaker storeShoe = sneakerStore.get(i);
                    Sneaker purchasedShoe = new Sneaker(
                            storeShoe.getBrand(),
                            storeShoe.getModel(),
                            storeShoe.getRetailPrice(),
                            0,
                            true,
                            storeShoe.getColorTheme(),
                            0
                    );
                    ownedShoes.add(purchasedShoe);
                    sneakerStore.remove(sneakerStore.get(i));
                } else {
                    System.out.println("You don't have enough money to buy the shoe!");
                }
            } else {
                System.out.println("You opt out of buying the " +
                        sneakerStore.get(i).getBrand() + " " +
                        sneakerStore.get(i).getModel() + "s");
            }
        }
    }
}

