package com.hana.delivery.db.model.seeder;

import com.hana.delivery.db.model.Artifact;
import com.hana.delivery.db.model.ArtifactComponent;
import com.hana.delivery.db.model.Bouquet;
import com.hana.delivery.db.service.ArtifactComponentService;
import com.hana.delivery.db.service.ArtifactService;
import com.hana.delivery.db.service.BouquetService;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

	@Autowired
  protected ArtifactService artifactService;
	
	@Autowired
	protected BouquetService bouquetService;
	
	@Autowired
	protected ArtifactComponentService artifactComponentService;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    Collection<Artifact> artifacts = this.artifactTableSeeder();
    Collection<ArtifactComponent> artifactComponents = this.artifactComponentSeeder(artifacts);
    Collection<Bouquet> bouquets = bouquetTableSeeder(artifactComponents);
  }

  @Transactional
  public Collection<Artifact> artifactTableSeeder() {
  	ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
  	
    if (this.artifactService.list().size() == 0) {
      Artifact artifact = Artifact.builder()
      		.name("Lavender")
      		.unitCost(2)
      		.stock(100)
      		.build();
      artifacts.add(this.artifactService.insert(artifact));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("African Daisy")
      			.unitCost(5)
      			.stock(50)
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Ageratum houstonianum")
      			.unitCost(3)
      			.stock(150)
      			.build()
      ));

      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Ageratum")
      			.unitCost(7)
      			.stock(120)
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Rose")
      			.unitCost(10)
      			.stock(200)
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("White Ribbin 1m")
      			.unitCost(2)
      			.stock(50)
      			.type("ribbin")
      			.build()
      ));

      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Yellow Ribbin 1m")
      			.unitCost(2)
      			.stock(50)
      			.type("ribbin")
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Green Ribbin 1m")
      			.unitCost(2)
      			.stock(50)
      			.type("ribbin")
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("Yellow Ribbin 40x32cm")
      			.unitCost(8)
      			.stock(50)
      			.type("paper")
      			.build()
      ));
      
      artifacts.add(this.artifactService.insert(
      		Artifact.builder()
      			.name("White Ribbin 40x32cm")
      			.unitCost(8)
      			.stock(50)
      			.type("paper")
      			.build()
      ));
    }
    
    return artifacts;
  }
  
  public Collection<ArtifactComponent> artifactComponentSeeder(Collection<Artifact> artifacts) {
  	ArrayList<ArtifactComponent> artifactComponents = new ArrayList<ArtifactComponent>();
  	if (this.artifactComponentService.getArtifactComponentRepository().count() == 0) {
  		
  	}
  	return new ArrayList<ArtifactComponent>();
  }
  
  public Collection<Bouquet> bouquetTableSeeder(Collection<ArtifactComponent> artifactComponents) {
  	ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
  	if (this.bouquetService.getBouquetRepository().count() == 0) {
  		bouquets.add(this.bouquetService.insert(
				Bouquet.builder()
					.name("Lorem ipsum")
					.imageLocation("https://images.unsplash.com/photo-1523693916903-027d144a2b7d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1575&q=80")
					.build()
  		));
  	}
  	
  	return bouquets;
  }
}
