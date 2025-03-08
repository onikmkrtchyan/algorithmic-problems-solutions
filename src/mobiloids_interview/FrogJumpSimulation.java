package mobiloids_interview;

import java.util.Random;

public class FrogJumpSimulation {
    
    // Method to check if a position is within the unit disk
    public static boolean isWithinUnitDisk(double x, double y) {
        return Math.sqrt(x*x + y*y) <= 1;

    }
    
    // Method to simulate frog jumps and estimate the probability
    public static double simulateFrogJumps(int numSimulations) {
        int numWithinUnitDisk = 0;
        Random random = new Random();
        
        for (int i = 0; i < numSimulations; i++) {
            double x = 0, y = 0;
            
            // Simulate 3 random jumps
            for (int j = 0; j < 3; j++) {
                final double v = random.nextDouble();
                double angle = v * 2 * Math.PI;
                x += Math.cos(angle);
                y += Math.sin(angle);
            }
            
            // Check if the final position is within the unit disk
            if (isWithinUnitDisk(x, y)) {
                numWithinUnitDisk++;
            }
        }
        
        // Calculate the estimated probability
        return (double) numWithinUnitDisk / numSimulations;
    }
    
    public static void main(String[] args) {
        int numSimulations = 100000000;
        
        // Simulate frog jumps and estimate the probability
        double probabilityWithinUnitDisk = simulateFrogJumps(numSimulations);
        System.out.println("Estimated probability that the frog is in the unit disk after 3 jumps: " + probabilityWithinUnitDisk);
    }
}
