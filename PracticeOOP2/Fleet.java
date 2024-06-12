package PracticeOOP2;

import java.util.ArrayList;

public class Fleet {
    //data members
    private ArrayList<Vehicle> vehicles;
    private Inventory inventory;

    //constructor
    public Fleet()
    {
        this.vehicles = new ArrayList<Vehicle>();
        this.inventory = new Inventory();
    }

    //service methods
    public void createShipment(Inventory newInventory)
    {
        int currentWeight;

        inventory = newInventory;
        currentWeight = 0;

        Vehicle vehicle = new Vehicle();

        for(int n = 0; n < inventory.getItems().size(); n++)
        {
            if(vehicle.findRemainingCapacity() < inventory.getItems().get(n).getWeight() * inventory.getItems().get(n).getCount())
            {
                vehicles.add(vehicle);
                vehicle = new Vehicle();
                currentWeight = 0;

                //this "if" clause is added because the last item in the inventory is not added to newly created vehicle since we cannot enter the "else" clause
                if(vehicle.findRemainingCapacity() > inventory.getItems().get(n).getWeight() * inventory.getItems().get(n).getCount() && n == inventory.getItems().size() - 1)
                {
                    vehicle.addItem(inventory.getItems().get(n));
                    currentWeight += inventory.getItems().get(n).getWeight() * inventory.getItems().get(n).getCount();
                    vehicle.setCurrentWeight(currentWeight);
                    vehicles.add(vehicle);
                }
            }
            else
            {
                vehicle.addItem(inventory.getItems().get(n));
                currentWeight += inventory.getItems().get(n).getWeight() * inventory.getItems().get(n).getCount();
                vehicle.setCurrentWeight(currentWeight);
            }
        }
    }

    //displaying the fleet
    public void listFleet()
    {
        for(int n = 0; n < vehicles.size(); n++)
        {
            System.out.println(vehicles.get(n));
        } 
    }
}
