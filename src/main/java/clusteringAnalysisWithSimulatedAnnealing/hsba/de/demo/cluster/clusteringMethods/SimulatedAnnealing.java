package clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.clusteringMethods;

import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.Cluster;
import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.GeneralMethods;
import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster.SimulatedAnnealingMethods;
import clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.data.dataProcessing.DataProcessing;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class SimulatedAnnealing {
    private DataProcessing dataProcessing = new DataProcessing();
    private GeneralMethods generalMethods = new GeneralMethods();
    private SimulatedAnnealingMethods simAnMethods = new SimulatedAnnealingMethods();

    public List<Cluster> computeCluster(int numberOfCluter, List<String[]> pointsToBeClustered, int numberOfItration, double startTemprature, double numberOfIterationPerTemprature, double alphaValue, boolean showResultInConsole) throws Exception {
        Instant start = Instant.now();
        // create empty clusters
        dataProcessing.setCreatedClusters(numberOfCluter);
        // created clusters
        List<Cluster> listOfCreatedClusters = dataProcessing.getCreatedClusters();
        System.out.println("Cluster number is "+ listOfCreatedClusters.size());
        // empty clusters are created. Now, we need to call the points
        List<double[]> initialList = generalMethods.dataSetStringToDoubleWithoutHeaders(pointsToBeClustered,showResultInConsole);
        initialList = generalMethods.normalizeDoubleList(initialList, true);

        simAnMethods.generateInitialClusterCeneters(listOfCreatedClusters,initialList,showResultInConsole);
        simAnMethods.assignPointsToClusters(listOfCreatedClusters,initialList,showResultInConsole);
        System.out.println("Total cost is "+ simAnMethods.costFunctionOfClusterList(listOfCreatedClusters));


        /*// start temprature
        while (numberOfItration*10>1){
            //generalMethods.nextPointAndItsClusterAddAndDelete(listOfCreatedClusters,initialList,numberOfCluter,distanceMethodNumber,false);



            numberOfItration = numberOfItration-1;
        }*/
        generalMethods.showFormedClusters(listOfCreatedClusters,true);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("Execution Time is "+ timeElapsed+ " (ms)");
        return dataProcessing.getCreatedClusters();
    }
}
