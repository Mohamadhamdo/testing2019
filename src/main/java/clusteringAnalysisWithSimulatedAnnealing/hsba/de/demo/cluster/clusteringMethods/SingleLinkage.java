package clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.clusteringMethods;

import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.Cluster;
import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.GeneralMethods;
import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.DataProcessing;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
/**
 * Class Description:
 * Single Linkage class is an aggregated class for the methods in this project
 */

public class SingleLinkage {
    // creating instances of DataProcessing and GeneralMethods
    private DataProcessing dataProcessing = new DataProcessing();
    private GeneralMethods generalMethods = new GeneralMethods();

    /**
     * Main function to create clusters as to Single Linkage method
    */
    public void computeCluster(int numberOfCluter, List<String[]> pointsToBeClustered, int distanceMethodNumber, boolean showResultInConsole) throws Exception {
        // Start timer
        Instant start = Instant.now();
        // create empty clusters
        dataProcessing.setCreatedClusters(numberOfCluter);
        // created clusters
        List<Cluster> listOfCreatedClusters = dataProcessing.getCreatedClusters();
        // empty clusters are created. Now, we need to call the points
        List<double[]> initialList = generalMethods.dataSetStringToDoubleWithoutHeaders(pointsToBeClustered,showResultInConsole);
        // Start optimizing
        while (initialList.size()>0){
            // call the main method of Single Linkage
            generalMethods.nextPointAndItsClusterAddAndDelete(listOfCreatedClusters,initialList,numberOfCluter,distanceMethodNumber,showResultInConsole);
        }
        // Stop timer
        Instant finish = Instant.now();
        // show the result
        generalMethods.showFormedClustersSingleLinkage(listOfCreatedClusters);
        // calculate the time
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        // Print out
        System.out.println("Execution Time is "+ timeElapsed+ " (ms)");
        System.out.println("########################################");
        System.out.println("########################################");
        System.out.println("");
    }

}
