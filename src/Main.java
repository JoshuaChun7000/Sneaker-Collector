void main() { //hi
    ArrayList<Collector> botsAlive = new ArrayList<>();
    ArrayList<Sneaker> sneakerStore = getSneakers();
    Sneaker none = new Sneaker("None", "", 0, 0,
            false, "", 0);
    Sneaker moonstars = new Sneaker("Antonio Vietri", "Moonstar", 19900000,
            0, true, "Gilded Meteor", 0);
    Sneaker jordans = new Sneaker("Jordan Brand", "Air Jordan 13", 2200000,
            0, true, "Bred", 0);
    Sneaker yeezys = new Sneaker("Nike", "Air Yeezy 1 'Prototype'", 1800000,
            0, true, "All Charcoal", 0);
    Sneaker airShips = new Sneaker("Nike", "Air Ship", 1472000, 0,
            true, "White / Varsity Red", 0);
    Sneaker lebrons = new Sneaker("Nike", "LeBron 15", 100000, 0,
            true, "30K", 0);
    Sneaker sandals = new Sneaker("Sandals", "Basic", 1, 0,
            true, "Beige", 0);
    ArrayList<Sneaker> playerCollection = new ArrayList<>();
    boolean running = true; //add another comment
    Scanner Wednesday = new Scanner(System.in);
    Collector Graham = new Collector("Graham", 0, none, 1,
            1, 1, false, new ArrayList<>());
    botsAlive.add(Graham);
    Collector Arnold = new Collector("Arnold", 100, none, 100,
            100, 45, false, new ArrayList<>());
    botsAlive.add(Arnold);
    Collector Kevin = new Collector("Kevin", 150, none, 100,
            100, 45, false, new ArrayList<>());
    botsAlive.add(Kevin);
    Collector Thomas = new Collector("Thomas", 200, none, 100,
            100, 45, false, new ArrayList<>());
    botsAlive.add(Thomas);
    Collector Liam = new Collector("Liam", 200, none, 100,
            100, 135, false, new ArrayList<>());
    botsAlive.add(Liam);
    Collector Noah = new Collector("Noah", 250, none, 100,
            100, 135, false, new ArrayList<>());
    botsAlive.add(Noah);
    Collector Oliver = new Collector("Oliver", 300, none, 100,
            100, 135, false, new ArrayList<>());
    botsAlive.add(Oliver);
    Collector Theodore = new Collector("Theodore", 300, none, 100,
            100, 225, false, new ArrayList<>());
    botsAlive.add(Theodore);
    Collector James = new Collector("James", 350, none, 100,
            100, 225, false, new ArrayList<>());
    botsAlive.add(James);
    Collector Henry = new Collector("Henry", 400, none, 100,
            100, 225, false, new ArrayList<>());
    botsAlive.add(Henry);
    Collector Mateo = new Collector("Mateo", 400, none, 100,
            100, 315, false, new ArrayList<>());
    botsAlive.add(Mateo);
    Collector Elijah = new Collector("Elijah", 450, none, 100,
            100, 315, false, new ArrayList<>());
    botsAlive.add(Elijah);
    Collector Lucas = new Collector("Lucas", 500, none, 100,
            100, 315, false, new ArrayList<>());
    botsAlive.add(Lucas);
    Collector William = new Collector("William", 600, moonstars, 100,
            100, 405, false, new ArrayList<>());
    botsAlive.add(William);
    Collector Domingo = new Collector("Domingo", 700, jordans, 100,
            100, 495, false, new ArrayList<>());
    botsAlive.add(Domingo);
    Collector Brian = new Collector("Mr. Johnson", 800, yeezys, 100,
            100, 585, false, new ArrayList<>());
    botsAlive.add(Brian);
    Collector Bastion = new Collector("Big J's Son", 900, airShips, 100,
            100, 675, false, new ArrayList<>());
    botsAlive.add(Bastion);
    Collector LeBron = new Collector("The King", 1000, lebrons, 100,
            100, 765, false, new ArrayList<>());
    botsAlive.add(LeBron);
    Collector Jesus = new Collector("God", 0, sandals, 100,
            100, Integer.MAX_VALUE, false, new ArrayList<>());
    botsAlive.add(Jesus);
    IO.println("Welcome to Sneaker Collector! What's your name?");
    String name = Wednesday.nextLine();
    Collector player = new Collector(name, 100, none, 100,
            100, 1, false, playerCollection);
    IO.println("Great, let's begin!");
    IO.println(player);
    while (running) {
        IO.println("""
                1) Show stats
                2) Go to hospital
                3) Go to therapy
                4) Jump someone
                5) Workout
                6) Rob bank
                7) Buy shoe
                8) Sell shoe
                9) Wear/remove shoe
                10) End it all""");
        IO.println("Choose: ");
        while (!Wednesday.hasNextInt()) {
            String invalidInput = Wednesday.next();
            IO.println("'" + invalidInput + "' is not a valid integer.");
            IO.print("Please enter a valid integer: ");
        }
        int choice = Wednesday.nextInt();
        Wednesday.nextLine();
        if (choice == 1) {
            IO.println(player);
        } else if (choice == 2) {
            player.goToHospital();
        } else if (choice == 3) {
            player.getTherapy();
        } else if (choice == 4) {
            IO.println("Who would you like to assault?\n");
            for (Collector person : botsAlive) {
                IO.println(person + "\n----------------------");
            }
            boolean personExists = false;
            String personGettingJumped;
            while (!personExists) {
                personGettingJumped = Wednesday.nextLine();
                for (Collector person : botsAlive) {
                    if (person.getName() != null &&
                            person.getName().equalsIgnoreCase(personGettingJumped)) {
                        personExists = true;
                        if (!person.getDead()) {
                            player.assault(person);
                        } else {
                            IO.println("Chill bro " + person.getName() + "'s already dead");
                        }
                    }
                }
                if (!personExists) {
                    IO.println("Person does not exist");
                }
            }
        } else if (choice == 5) {
            IO.println("How many times would you like to work out?");
            while (!Wednesday.hasNextInt()) {
                String invalidInput = Wednesday.next();
                IO.println("'" + invalidInput + "' is not a valid integer.");
                IO.print("Please enter a valid integer: ");
            }
            int times = Wednesday.nextInt();
            player.workout(times);
        } else if (choice == 6) {
            player.robBank();
        } else if (choice == 7) {
            player.buyShoe(Wednesday, sneakerStore);
        } else if (choice == 8) {
            player.sellShoe(Wednesday);
        } else if (choice == 9) {
            IO.println("Type 1 if you would like to put on a shoe\n" +
                    "Type 2 if you would like to take off your shoe");
            boolean vi = false;
            while (!vi) {
                while (!Wednesday.hasNextInt()) {
                    String invalidInput = Wednesday.next();
                    IO.println("'" + invalidInput + "' is not a valid integer.");
                    IO.print("Please enter a valid integer: ");
                }
                int decision = Wednesday.nextInt();
                Wednesday.nextLine();
                if (decision == 1) {
                    vi = true;
                    IO.println("""
                            Which shoes would you like to see?
                            All (type 1)
                            Brands (type 2)
                            Models (type 3)
                            """);
                    while (!Wednesday.hasNextInt()) {
                        String invalidInput = Wednesday.next();
                        IO.println("'" + invalidInput + "' is not a valid integer.");
                        IO.print("Please enter a valid integer: ");
                    }
                    int c = Wednesday.nextInt();
                    Wednesday.nextLine();
                    if (c == 1) {
                        if (!(playerCollection.isEmpty())) {
                            IO.println(player.listAll());
                            int d = askWhichShoeToWear(Wednesday);
                            if (d == 1) {
                                Sneaker shoe = player.findMostExpensive(playerCollection);
                                player.setWearingSneaker(shoe);
                            } else if (d == 2) {
                                Sneaker shoe = player.findMostCheap(playerCollection);
                                player.setWearingSneaker(shoe);
                            } else if (d == 3) {
                                for (int i = 0; i < playerCollection.size(); i++) {
                                    IO.println("Type " + i + " to wear " + playerCollection.get(i));
                                }
                                while (!Wednesday.hasNextInt()) {
                                    String invalidInput = Wednesday.next();
                                    IO.println("'" + invalidInput + "' is not a valid integer.");
                                    IO.print("Please enter a valid integer: ");
                                }
                                int shoeChoice = Wednesday.nextInt();
                                Wednesday.nextLine();
                                if (shoeChoice >= 0 && shoeChoice < playerCollection.size()) {
                                    player.setWearingSneaker(playerCollection.get(shoeChoice));
                                } else {
                                    IO.println("That's not a valid option!");
                                }
                            } else if (d == 4) {
                                IO.println("You opt out of putting a shoe on");
                            } else {
                                IO.println("That's not a valid option!");
                            }
                        } else {
                            IO.println(player.getName() + " doesn't own shoes");
                        }
                    } else if (c == 2) {
                        if (!(playerCollection.isEmpty())) {
                            IO.println("Which brand?\n" +
                                    "Nike, Adidas, Skechers, New Balance, Puma");
                            boolean valid = false;
                            String chosenBrand = "";
                            while (!valid) {
                                chosenBrand = Wednesday.nextLine();
                                if (chosenBrand.equalsIgnoreCase("nike") ||
                                        (chosenBrand.equalsIgnoreCase("adidas")) ||
                                        (chosenBrand.equalsIgnoreCase("skechers")) ||
                                        (chosenBrand.equalsIgnoreCase("new balance")) ||
                                        (chosenBrand.equalsIgnoreCase("puma"))) {
                                    valid = true;
                                } else {
                                    IO.println("That's not a real brand! Choose a real brand");
                                }
                            }
                            ArrayList<Sneaker> brandShoes = new ArrayList<>();
                            for (Sneaker s : playerCollection) {
                                if (s.getBrand().equalsIgnoreCase(chosenBrand)) {
                                    brandShoes.add(s);
                                }
                            }
                            int d = askWhichShoeToWear(Wednesday);
                            if (d == 1) {
                                Sneaker shoe = player.findMostExpensive(brandShoes);
                                player.setWearingSneaker(shoe);
                            } else if (d == 2) {
                                Sneaker shoe = player.findMostCheap(brandShoes);
                                player.setWearingSneaker(shoe);
                            } else if (d == 3) {
                                for (int i = 0; i < brandShoes.size(); i++) {
                                    IO.println("Type " + i + " to wear " + brandShoes.get(i));
                                }
                                while (!Wednesday.hasNextInt()) {
                                    String invalidInput = Wednesday.next();
                                    IO.println("'" + invalidInput + "' is not a valid integer.");
                                    IO.print("Please enter a valid integer: ");
                                }
                                int shoeChoice = Wednesday.nextInt();
                                Wednesday.nextLine();
                                if (shoeChoice >= 0 && shoeChoice < brandShoes.size()) {
                                    player.setWearingSneaker(brandShoes.get(shoeChoice));
                                } else {
                                    IO.println("That's not a valid option!");
                                }
                            } else if (d == 4) {
                                IO.println("You opt out of putting a shoe on");
                            } else {
                                IO.println("That's not a valid option!");
                            }
                        } else {
                            IO.println(player.getName() + " doesn't own shoes");
                        }
                    } else if (c == 3) {
                        if (!playerCollection.isEmpty()) {
                            IO.println(player.listAll());
                            IO.println("Pick a model from your owned shoes");
                            boolean valid = false;
                            String chosenModel = "";
                            while (!valid) {
                                chosenModel = Wednesday.nextLine();
                                for (Sneaker s : player.ownedShoes) {
                                    if (s.getModel().equalsIgnoreCase(chosenModel)) {
                                        valid = true;
                                        break;
                                    }
                                }
                                if (!valid) {
                                    IO.println("That's not a real model! Choose a real model");
                                }
                            }
                            ArrayList<Sneaker> modelShoes = new ArrayList<>();
                            for (Sneaker s : playerCollection) {
                                if (s.getModel().equalsIgnoreCase(chosenModel)) {
                                    modelShoes.add(s);
                                }
                            }
                            int d = askWhichShoeToWear(Wednesday);
                            if (d == 1) {
                                Sneaker shoe = player.findMostExpensive(modelShoes);
                                player.setWearingSneaker(shoe);
                            } else if (d == 2) {
                                Sneaker shoe = player.findMostCheap(modelShoes);
                                player.setWearingSneaker(shoe);
                            } else if (d == 3) {
                                for (int i = 0; i < modelShoes.size(); i++) {
                                    IO.println("Type " + i + " to wear " + modelShoes.get(i));
                                }
                                while (!Wednesday.hasNextInt()) {
                                    String invalidInput = Wednesday.next();
                                    IO.println("'" + invalidInput + "' is not a valid integer.");
                                    IO.print("Please enter a valid integer: ");
                                }
                                int shoeChoice = Wednesday.nextInt();
                                Wednesday.nextLine();
                                if (shoeChoice >= 0 && shoeChoice < modelShoes.size()) {
                                    player.setWearingSneaker(modelShoes.get(shoeChoice));
                                } else {
                                    IO.println("That's not a valid option!");
                                }
                            } else if (d == 4) {
                                IO.println("You opt out of putting a shoe on");
                            } else {
                                IO.println("That's not a valid option!");
                            }
                        } else {
                            IO.println(player.getName() + " doesn't own shoes");
                        }
                    }
                } else if (decision == 2) {
                    vi = true;
                    if (player.getWearingSneaker().getBrand().equalsIgnoreCase(player.none.getBrand())) {
                        IO.println(player.getName() + " isn't wearing sneakers");
                    } else {
                        IO.println(player.getName() + " takes off their " +
                                player.getWearingSneaker());
                        player.setWearingSneaker(player.none);
                    }
                } else {
                    IO.println("Please choose a valid input");
                }
            }
        } else if (choice == 10) {
            IO.println(player.getName() + " was tired of life");
            player.setDead(true);
            running = false;
        } else {
            IO.println("Invalid choice!");
        }
        if (player.getDead()) {
            running = false;
        }
    }
    IO.println("====GAME OVER====");
}


private static ArrayList<Sneaker> getSneakers() {
    ArrayList<Sneaker> sneakerStore = new ArrayList<>();
    Sneaker shoes1 = new Sneaker("Nike", "Air Jordan 1", 129.89, 0,
            true, "Chicago", 0);
    Sneaker shoes2 = new Sneaker("Adidas", "Superstars", 109.89, 0,
            true, "Black", 0);
    Sneaker shoes3 = new Sneaker("New Balance", "990", 99.99, 0,
            true, "Aimé Leon Dore", 0);
    Sneaker shoes4 = new Sneaker("Puma", "Speedcat", 89.98, 0,
            true, "Sparco", 0);
    Sneaker shoes5 = new Sneaker("Skechers", "D'Lite", 49.99, 0,
            true, "Summer Fiesta", 0);
    Sneaker shoes6 = new Sneaker("Nike", "Air Max 90", 119.99, 0,
            true, "Silver Bullet", 0);
    Sneaker shoes7 = new Sneaker("Nike", "Air Force 1", 138.78, 0,
            true, "Triple Black", 0);
    Sneaker shoes8 = new Sneaker("Adidas", "Samba", 119.89, 0,
            true, "Collegiate Green", 0);
    Sneaker shoes9 = new Sneaker("Adidas", "Stan Smith", 129.78, 0,
            true, "Triple White", 0);
    Sneaker shoes10 = new Sneaker("New Balance", "550", 99.79, 0,
            true, "White / Team Navy", 0);
    Sneaker shoes11 = new Sneaker("New Balance", "574", 116.98, 0,
            true, "Burgundy / Castlerock", 0);
    Sneaker shoes12 = new Sneaker("Skechers", "D'Lite", 61.09, 0,
            true, "Fresh Start", 0);
    Sneaker shoes13 = new Sneaker("Skechers", "Summit", 55.55, 0,
            true, "Pastel Haze", 0);
    Sneaker shoes14 = new Sneaker("Puma", "Suede", 97.79, 0,
            true, "Regal Blue", 0);
    Sneaker shoes15 = new Sneaker("Puma", "SmashV2", 115.78, 0,
            true, "Puma Black / Team Gold", 0);
    sneakerStore.add(shoes1);
    sneakerStore.add(shoes2);
    sneakerStore.add(shoes3);
    sneakerStore.add(shoes4);
    sneakerStore.add(shoes5);
    sneakerStore.add(shoes6);
    sneakerStore.add(shoes7);
    sneakerStore.add(shoes8);
    sneakerStore.add(shoes9);
    sneakerStore.add(shoes10);
    sneakerStore.add(shoes11);
    sneakerStore.add(shoes12);
    sneakerStore.add(shoes13);
    sneakerStore.add(shoes14);
    sneakerStore.add(shoes15);
    return sneakerStore;
}


private static int askWhichShoeToWear(Scanner wednesday) {
    IO.println("""
            Type 1 to put on the most expensive shoe
            Type 2 to put on the cheapest shoe
            Type 3 to choose which shoe to put on
            Type 4 to opt out of putting on a shoe""");
    while (!wednesday.hasNextInt()) {
        String invalidInput = wednesday.next();
        IO.println("'" + invalidInput + "' is not a valid integer.");
        IO.print("Please enter a valid integer: ");
    }
    int choice = wednesday.nextInt();
    wednesday.nextLine();
    return choice;
}



