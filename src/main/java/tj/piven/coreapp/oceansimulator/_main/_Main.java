package tj.piven.coreapp.oceansimulator._main;

import tj.piven.coreapp.oceansimulator.model.Dolphin;
import tj.piven.coreapp.oceansimulator.util.EventProducer;

public class _Main {
    public static void main (String [] args) {
        Dolphin dolphin = new Dolphin();
        EventProducer eventProducer = new EventProducer();
        eventProducer.startSimulation(dolphin);

    }
}
