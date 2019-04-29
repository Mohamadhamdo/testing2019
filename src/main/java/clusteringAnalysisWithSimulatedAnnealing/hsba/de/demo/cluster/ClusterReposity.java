package clusteringAnalysisWithSimulatedAnnealing.hsba.de.demo.cluster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClusterReposity extends JpaRepository<Cluster, Long> {
}
