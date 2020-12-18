package com.hana.delivery.db.seeder;

import com.hana.delivery.db.model.Artifact;
import com.hana.delivery.db.model.ArtifactComponent;
import com.hana.delivery.db.model.Bouquet;
import com.hana.delivery.db.model.Product;
import com.hana.delivery.db.model.ProductOrder;
import com.hana.delivery.db.model.ProductOrderLine;
import com.hana.delivery.db.service.ArtifactComponentService;
import com.hana.delivery.db.service.ArtifactService;
import com.hana.delivery.db.service.BouquetService;
import com.hana.delivery.db.service.ProductOrderLineService;
import com.hana.delivery.db.service.ProductOrderService;
import com.hana.delivery.db.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

	@Autowired
	protected ProductService productService;

	@Autowired
	protected ProductOrderService productOrderService;

	@Autowired
	protected ProductOrderLineService productOrderLineService;
	
	protected ArrayList<ProductOrder> productOrders;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		this.productOrders = new ArrayList<ProductOrder>();
		ArrayList<Artifact> artifacts = this.artifactTableSeeder();
		ArrayList<ArrayList<ArtifactComponent>> artifactComponents = this.artifactComponentSeeder(artifacts);
		ArrayList<Bouquet> bouquets = bouquetTableSeeder(artifactComponents);
		ArrayList<Product> products = productTableSeeder(bouquets);
		// ArrayList<ProductOrder> productOrder = productOrderTableSeeder();
		ArrayList<ProductOrderLine> productOrderLine = productOrderLineTableSeeder(products);
	}

	@Transactional
	public ArrayList<Artifact> artifactTableSeeder() {
		ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

		if (this.artifactService.list().size() == 0) {
			Artifact artifact = Artifact.builder().name("Lavender").unitCost(2).stock(100).build();
			artifacts.add(this.artifactService.insert(artifact));

			artifacts
					.add(this.artifactService.insert(Artifact.builder().name("African Daisy").unitCost(5).stock(50).build()));

			artifacts.add(this.artifactService.insert(Artifact.builder().name("Tulip").unitCost(3).stock(150).build()));

			artifacts.add(this.artifactService.insert(Artifact.builder().name("Ageratum").unitCost(7).stock(120).build()));

			artifacts.add(this.artifactService.insert(Artifact.builder().name("Rose").unitCost(20).stock(200).build()));

			artifacts.add(this.artifactService
					.insert(Artifact.builder().name("White Ribbin 1m").unitCost(2).stock(50).type("ribbin").build()));

			artifacts.add(this.artifactService
					.insert(Artifact.builder().name("Yellow Ribbin 1m").unitCost(2).stock(50).type("ribbin").build()));

			artifacts.add(this.artifactService
					.insert(Artifact.builder().name("Green Ribbin 1m").unitCost(2).stock(50).type("ribbin").build()));

			artifacts.add(this.artifactService
					.insert(Artifact.builder().name("Yellow Ribbin 40x32cm").unitCost(8).stock(50).type("paper").build()));

			artifacts.add(this.artifactService
					.insert(Artifact.builder().name("White Ribbin 40x32cm").unitCost(8).stock(50).type("paper").build()));
		}

		return artifacts;
	}

	@Transactional
	public ArrayList<ArrayList<ArtifactComponent>> artifactComponentSeeder(ArrayList<Artifact> artifacts) {

		ArrayList<ArrayList<ArtifactComponent>> artifactComponents = new ArrayList<ArrayList<ArtifactComponent>>();

		if (this.artifactComponentService.getArtifactComponentRepository().count() == 0) {
			ArrayList<ArtifactComponent> bq1 = new ArrayList<ArtifactComponent>();

			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(0)).quality(5).build()));
			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(4)).quality(5).build()));

			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(1).build()));

			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(3).build()));

			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			bq1.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			artifactComponents.add(bq1);

			ArrayList<ArtifactComponent> bq2 = new ArrayList<ArtifactComponent>();
			bq2.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(0)).quality(7).build()));

			bq2.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(2).build()));

			artifactComponents.add(bq2);

			ArrayList<ArtifactComponent> bq3 = new ArrayList<ArtifactComponent>();
			bq3.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(0)).quality(10).build()));

			bq3.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(4).build()));

			bq3.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			bq3.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			artifactComponents.add(bq3);
			ArrayList<ArtifactComponent> bq4 = new ArrayList<ArtifactComponent>();

			bq4.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(0)).quality(15).build()));
			bq4.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(3).build()));

			bq4.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(2).build()));

			artifactComponents.add(bq4);
			ArrayList<ArtifactComponent> bq5 = new ArrayList<ArtifactComponent>();

			bq5.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(0)).quality(7).build()));

			bq5.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			bq5.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(3).build()));

			artifactComponents.add(bq5);

			// ---

			ArrayList<ArtifactComponent> bq6 = new ArrayList<ArtifactComponent>();
			bq6.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(1)).quality(8).build()));

			bq6.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			bq6.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(3).build()));

			artifactComponents.add(bq6);

			ArrayList<ArtifactComponent> bq7 = new ArrayList<ArtifactComponent>();
			bq7.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(1)).quality(9).build()));

			bq7.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(2).build()));

			artifactComponents.add(bq7);
			ArrayList<ArtifactComponent> bq8 = new ArrayList<ArtifactComponent>();
			bq8.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(1)).quality(11).build()));
			bq8.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));
			bq8.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(9).build()));

			artifactComponents.add(bq8);
			ArrayList<ArtifactComponent> bq9 = new ArrayList<ArtifactComponent>();
			bq9.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(1)).quality(10).build()));
			bq9.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));
			bq9.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			artifactComponents.add(bq9);
			ArrayList<ArtifactComponent> bq10 = new ArrayList<ArtifactComponent>();
			bq10.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(1)).quality(8).build()));
			bq10.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));
			artifactComponents.add(bq10);

			// ---
			ArrayList<ArtifactComponent> bq11 = new ArrayList<ArtifactComponent>();
			bq11.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(2)).quality(9).build()));
			bq11.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));
			artifactComponents.add(bq11);

			ArrayList<ArtifactComponent> bq12 = new ArrayList<ArtifactComponent>();
			bq12.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(2)).quality(10).build()));

			bq12.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(1).build()));
			artifactComponents.add(bq12);

			ArrayList<ArtifactComponent> bq13 = new ArrayList<ArtifactComponent>();
			bq13.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(2)).quality(5).build()));

			bq13.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			bq13.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(2).build()));

			bq13.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			bq13.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(5).build()));
			artifactComponents.add(bq13);

			ArrayList<ArtifactComponent> bq14 = new ArrayList<ArtifactComponent>();
			bq14.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(2)).quality(9).build()));

			bq14.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			bq14.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(5)).quality(2).build()));
			artifactComponents.add(bq14);

			ArrayList<ArtifactComponent> bq15 = new ArrayList<ArtifactComponent>();
			bq15.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(2)).quality(5).build()));

			bq15.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));

			bq15.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(1).build()));
			artifactComponents.add(bq15);
			// ---

			ArrayList<ArtifactComponent> bq16 = new ArrayList<ArtifactComponent>();
			bq16.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(3)).quality(2).build()));

			bq16.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));
			artifactComponents.add(bq16);
			// ---

			ArrayList<ArtifactComponent> bq17 = new ArrayList<ArtifactComponent>();
			bq17.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(3)).quality(20).build()));
			artifactComponents.add(bq17);

			ArrayList<ArtifactComponent> bq18 = new ArrayList<ArtifactComponent>();
			bq18.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(3)).quality(10).build()));

			bq18.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(7).build()));
			artifactComponents.add(bq18);

			ArrayList<ArtifactComponent> bq19 = new ArrayList<ArtifactComponent>();
			bq19.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(3)).quality(2).build()));

			bq19.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(8)).quality(1).build()));

			bq19.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(6)).quality(1).build()));
			artifactComponents.add(bq19);

			ArrayList<ArtifactComponent> bq20 = new ArrayList<ArtifactComponent>();
			bq20.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(3)).quality(5).build()));

			bq20.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(7)).quality(1).build()));
			artifactComponents.add(bq20);

			// ---

			ArrayList<ArtifactComponent> bq21 = new ArrayList<ArtifactComponent>();
			bq21.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(4)).quality(1).build()));
			artifactComponents.add(bq21);

			ArrayList<ArtifactComponent> bq22 = new ArrayList<ArtifactComponent>();
			bq22.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(4)).quality(5).build()));
			artifactComponents.add(bq22);

			ArrayList<ArtifactComponent> bq23 = new ArrayList<ArtifactComponent>();
			bq23.add(this.artifactComponentService
					.insert(ArtifactComponent.builder().artifact(artifacts.get(4)).quality(10).build()));
			artifactComponents.add(bq23);

		}

		return artifactComponents;
	}

	@Transactional
	public ArrayList<Bouquet> bouquetTableSeeder(ArrayList<ArrayList<ArtifactComponent>> artifactComponents) {
		ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Plaisirs d'Été").imageLocation(
				"https://images.unsplash.com/photo-1523693916903-027d144a2b7d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1575&q=80")
				.artifactComponents(artifactComponents.get(0)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Magie du Matin").imageLocation(
				"https://image.freepik.com/free-photo/closeup-shot-luxurious-bouquet-pink-roses-white-red-dahlias-black-background_181624-24088.jpg")
				.artifactComponents(artifactComponents.get(1)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Parfums du Paradis").imageLocation(
				"https://image.freepik.com/free-photo/closeup-shot-several-white-flowers-each-other-black-background_181624-24355.jpg")
				.artifactComponents(artifactComponents.get(2)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Joie de Jade").imageLocation(
				"https://image.freepik.com/free-photo/closeup-shot-luxurious-bouquet-pink-roses-white-red-dahlias-black-background_181624-25234.jpg")
				.artifactComponents(artifactComponents.get(3)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Crête Cramoisie")
				.imageLocation(
						"https://image.freepik.com/free-photo/background-with-beautiful-white-pink-flowers-peonies_87424-160.jpg")
				.artifactComponents(artifactComponents.get(4)).build()));
		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Parfums d'Amour").imageLocation(
				"https://image.freepik.com/free-photo/beautiful-fresh-flowers-wooden-background-various-flowers-place-text-closeup_169016-4797.jpg")
				.artifactComponents(artifactComponents.get(5)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Fleurs d'Amour")
				.imageLocation("https://image.freepik.com/free-photo/beautiful-wedding-bouquet-roses_24837-420.jpg")
				.artifactComponents(artifactComponents.get(6)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Lumières d'Été").imageLocation(
				"https://image.freepik.com/free-photo/closeup-shot-luxurious-bouquet-pink-roses-white-red-dahlias-black_181624-22567.jpg")
				.artifactComponents(artifactComponents.get(7)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Chrysanthèmes de Cristal").imageLocation(
				"https://image.freepik.com/free-photo/bouquet-sprig-freesia-flowers-isolated-pink-background-floral-holiday-card-top-view-flat-lay_72679-1115.jpg")
				.artifactComponents(artifactComponents.get(8)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Rose Radiant").imageLocation(
				"https://image.freepik.com/free-photo/bride-holds-lush-bouquet-with-delicate-flowers-colors_8353-11436.jpg")
				.artifactComponents(artifactComponents.get(9)).build()));
		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Jardin de Prairie").imageLocation(
				"https://image.freepik.com/free-photo/beautiful-brunette-caucasian-bride-is-holding-bouquet-white-peonies-looking-straight-indoor_8353-11065.jpg")
				.artifactComponents(artifactComponents.get(10)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Précieux Printemps").imageLocation(
				"https://image.freepik.com/free-photo/bride-wearing-beautiful-wedding-dress-holding-her-wedding-day-s-bouquet-beautiful-roses_181624-24285.jpg")
				.artifactComponents(artifactComponents.get(11)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Fraîcheur Printanière")
				.imageLocation(
						"https://image.freepik.com/free-photo/wedding-flowers-bouquet-with-newlywed-couple_88114-177.jpg")
				.artifactComponents(artifactComponents.get(12)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Splendeur de Saphirs").imageLocation(
				"https://image.freepik.com/free-photo/tender-eustoma-flower-with-engagement-ring-with-tiny-diamond-hands-bride_8353-10948.jpg")
				.artifactComponents(artifactComponents.get(13)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Prairies d'Été")
				.imageLocation("https://image.freepik.com/free-photo/beautiful-bridal-bouquet_181624-8787.jpg")
				.artifactComponents(artifactComponents.get(14)).build()));
		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Pour Papa").imageLocation(
				"https://image.freepik.com/free-photo/bride-holds-lush-bouquet-with-delicate-flowers-colors_8353-11436.jpg")
				.artifactComponents(artifactComponents.get(15)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Magie d'Hiver")
				.imageLocation(
						"https://image.freepik.com/free-photo/bride-with-bridesmaids-holding-wedding-bouquets_329181-1584.jpg")
				.artifactComponents(artifactComponents.get(16)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Points d'Amour")
				.imageLocation("https://image.freepik.com/free-photo/wedding-beautiful-bride_144627-13001.jpg")
				.artifactComponents(artifactComponents.get(17)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Félicité")
				.imageLocation("https://image.freepik.com/free-photo/bride-holding-her-wedding-bouquet_1303-25289.jpg")
				.artifactComponents(artifactComponents.get(18)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Parfums de Printemps")
				.imageLocation("https://image.freepik.com/free-photo/wedding-decoration-style-boho_155003-8320.jpg")
				.artifactComponents(artifactComponents.get(19)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Été Tropical")
				.imageLocation("https://image.freepik.com/free-photo/wedding-bouquet-bride-two-bridesmaid_168386-483.jpg")
				.artifactComponents(artifactComponents.get(20)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Fleurs Fantaisies")
				.imageLocation("https://image.freepik.com/free-photo/beautiful-wedding-bouquet-flowers_1328-3612.jpg")
				.artifactComponents(artifactComponents.get(21)).build()));

		bouquets.add(this.bouquetService.insert(Bouquet.builder().name("Envie")
				.imageLocation("https://image.freepik.com/free-photo/bouquet-red-roses-valentine-s-day_2829-5293.jpg")
				.artifactComponents(artifactComponents.get(22)).build()));

		return bouquets;
	}

	@Transactional
	public ArrayList<Product> productTableSeeder(ArrayList<Bouquet> bouquets) {
		ArrayList<Product> products = new ArrayList<Product>();
		
		// https://lorem.in.th
		List<String> productDescription = Arrays.asList(
				"เจ๊าะแจ๊ะแคร็กเกอร์ อาร์พีจีคำตอบปอดแหกรีสอร์ทเอสเพรสโซ คลิปแครอทเชอร์รี่ทำงานอุปัทวเหตุ โกเต็กซ์กู๋มวลชน คอร์ปเนิร์สเซอรีสถาปัตย์สปาย อุปนายกจังโก้น็อค กับดักโมเดลโจ๋แฟล็ตบุ๋น แฟล็ต เรซินล้มเหลวเยอบีราเอาท์ดอร์ เวณิกาสแตนดาร์ดวอเตอร์เคอร์ฟิว ไฮไลท์วอลนัทเหี่ยวย่น อพาร์ทเมนท์ สมิติเวชสโตนสึนามิ เทอร์โบ ฟีเวอร์วาริชศาสตร์แครอทบ็อกซ์ไฟลต์ ทีวีน้องใหม่วินปาร์ตี้สเปก",
				"สงบสุขโบ้ยโรแมนติกไวอากร้านิรันดร์ รุสโซฟลุตมั้ย เบิร์นนอมินีแลนด์ว้อยฮิต ระโงกรีทัชแซนด์วิชธรรมา แมนชั่นอันตรกิริยาปาสกาลซิตี้ เกรด อุด้งสามแยกซาร์มลภาวะดีเจ ซูโม่เจ๊สไตรค์ เซ็กส์สเตริโอโทรโข่งคันยิช็อต ฟีดจัมโบ้แอดมิชชั่น แบดแก๊สโซฮอล์สกายซิตี้ อาร์พีจีเฟรมต่อรองปอดแหก หม่านโถวแคชเชียร์เพียบแปร้ปาสเตอร์ ปาสเตอร์แฟรีไฮเอนด์ ฟีเวอร์คอนเซ็ปต์สตาร์ธรรมา บ๋อยบ๊วยชะโนดเฮีย",
				"ไทยแลนด์ แฮปปี้ฟาสต์ฟู้ดซาตานเห็นด้วยโหงวเฮ้ง ชะโนดไนท์ สตรอเบอรีแรงดูด สเก็ตช์ป๋ารีทัชทำงาน พาร์แซ็ก จีดีพีทัวร์นาเมนท์วาริชศาสตร์ ควิกโคโยตี้เทรลเล่อร์โกเต็กซ์ แดรี่เต๊ะแซลมอนถ่ายทำรูบิค โชห่วยออกแบบแอโรบิคธรรมาภิบาล แคทวอล์คเกจิเหี่ยวย่นมาร์เก็ตโก๊ะ เกมส์คอรัปชันห่วย ชิฟฟอนห่วย อุปัทวเหตุเกย์ซูเปอร์ รูบิกไนท์เมจิก แอ็กชั่น",
				"เฟอร์รี่มิวสิคเคลื่อนย้ายแฟลชบูติค ทรูเคสไฮกุน็อก ทอม ไลท์เพรียวบางโอเพ่น เบิร์ดไทเฮาพอเพียงวาไรตี้ทัวริสต์ ออกแบบก่อนหน้า แช่แข็ง ฮอต แอลมอนด์ฟอยล์ออสซี่เย้ว เบนโตะผิดพลาดรูบิค คูลเลอร์ผ้าห่มแรงใจคอปเตอร์เช็งเม้ง ฮาโลวีนโปรเจคท์ท็อปบูต นางแบบทรูซีอีโอ โมจิน็อกโปรเจ็กต์คีตกวี ทัวร์นาเมนท์คาราโอเกะพอเพียง เปียโน",
				"แฟ็กซ์พ่อค้าไอติมแจ๊กพ็อต สติกเกอร์โยเกิร์ตวานิลา แพตเทิร์นแฮปปี้อันเดอร์โหงว ยิมไนท์ออโต้ โปรเจคท์ซีเนียร์ความหมายโพลารอยด์ดีไซน์ ซีนีเพล็กซ์ ฮิแบตคาราโอเกะ ทิปยนตรกรรมโกะซีเรียส ไฮแจ็คนรีแพทย์เบนโล เฟรมเครปบ๊วยตุ๊กตุ๊ก วอร์รูมเกมส์ วอฟเฟิล สต๊อค โกะแบรนด์ฮัลโลวีนแกรนด์พาร์ทเนอร์ สุนทรีย์เลกเชอร์โหลนวอเตอร์ พุทธศตวรรษแอคทีฟสเตชัน",
				"วิลล์ซีเนียร์ คอร์สแพ็คธุหร่ำเพรียวบางเยอร์บีร่า เอสเพรสโซแชมเปญครัวซองต์แคป ไคลแม็กซ์สตีลวอลนัตพุทโธต่อยอด วิป ความหมายเมี่ยงคำภควัมบดีละอ่อนซาฟารี ซิมโฟนียากูซ่าแฟ้บราชบัณฑิตยสถาน อุด้ง ตะหงิดไลท์แกสโซฮอล์สจ๊วต อะวีนอุด้งสตรอว์เบอร์รี จีดีพีไทยแลนด์ลาเต้ อึ้มโลโก้โมเต็ลแม่ค้าไฮบริด เซาท์หม่านโถวแพนดาอัลไซเมอร์สแควร์ วาริชศาสตร์มอคค่าเทวาสุนทรีย์ บลูเบอร์รีสแล็กแมคเคอเรล โมเดลกฤษณ์ลิสต์แอ็คชั่นแทงโก้",
				"คอลัมน์คูลเลอร์มอคค่าบิล ภควัมปติแอปเปิ้ล ไฟต์ง่าว ดีไซน์โปรเจ็คท์ชาร์ปทอร์นาโดแรงใจ ออร์แกนิกเอาต์เจ็ต โกะสัมนาช็อป หยวนการันตีครัวซอง เทคโนแครต เวิลด์วิวป๊อปซูชิ เอ๊าะแจ็กเก็ตพฤหัสซ้อปอดแหก ฟลุกบูมลามะโอยัวะ ไฟลต์กรีนไนท์บัตเตอร์ มัฟฟินอันเดอร์ง่าว สหรัฐ แซมบ้าฮากกาฮิปฮอปยิวซีรีส์ คอลัมนิสต์บูติกเฟรมฟอยล์",
				"ฮ่องเต้เต๊ะตี๋บ๊อบ ซีเนียร์อิเหนาคอมเมนท์ ซ้อจุ๊ยคอนเฟิร์มเห่ยโนติส ลามะแอปเปิ้ลไอซียูฟรุตแพ็ค เป่ายิงฉุบ แซลมอนซูเอี๋ยไนน์ไนน์ อึ้มไตรมาสยิมปอดแหกยูวี ช็อปคอร์รัปชันออยล์ชาร์จ วอเตอร์มายองเนสลาติน จึ๊กเอสเปรสโซ แฟนซี ท็อปบูตโบ้ย ตัวเองไคลแม็กซ์คาร์ศึกษาศาสตร์ ศากยบุตรโปรโมทแทงโก้ รีดไถดิกชันนารีเมคอัพทัวร์นาเมนท์วอล์ค ไทยแลนด์",
				"กุมภาพันธ์ ผลักดันฮากกาเปราะบางพรีเมียม โฮมแดนซ์พงษ์ ปิกอัพเอ๋อไรเฟิล เทเลกราฟแมมโบ้อึมครึมพาร์ทเนอร์ ดีลเลอร์ซานตาคลอสแจมแฟกซ์ ลามะเครปธรรมาวานิลา ซินโดรมต่อรองเกมส์แพ็คทาวน์เฮาส์ ปาสกาลว้าวแอ๊บแบ๊วสัมนา เบลอแมมโบ้แคมเปญทิป แบล็กแฟรนไชส์ไดเอ็ตลามะ สไตรค์บิลเทเลกราฟ แฟกซ์ มอคค่า เพนตากอนหงวนโชว์รูม คันธาระแพตเทิร์นจิ๊กซอว์คอนโทรล",
				"คอนโทรลแชเชือนเซี้ยวโฟม คอรัปชั่นไฮไลท์แพลนถูกต้อง ดยุกมายองเนสเจไดเหมยนิว ซูเอี๋ยเทรนด์ฮาลาลดาวน์อึ้ม ผลไม้เวิร์กช็อป สตูดิโอภูมิทัศน์ฟรังก์โฟมหมิง คาร์มาม่านิวออดิชั่นเฟรช ทับซ้อนพรีเซ็นเตอร์อุด้งซีน กรีน โอเวอร์โดนัทเอาท์จุ๊ยทัวร์นาเมนท์ ยังไงฮาโลวีนแซ็กโบกี้ แบล็คสปาย ไวอากร้าสันทนาการแบนเนอร์ ชาร์ปชะโนดเก๋ากี้ฮ่องเต้หงวน คอมเมนต์ โบว์ลิ่ง",
				"วัคค์ความหมายไฮเปอร์สแล็กเทียมทาน บ๊อบ ผ้าห่มฮอตดอก เบลอเก๋ากี้ไทม์ เนิร์สเซอรีแอดมิชชั่นติวเตอร์ เซอร์วิสเซาท์ เลสเบี้ยนไฮเปอร์ อมาตยาธิปไตยโคโยตี้ม้งช็อปปิ้ง สตรอว์เบอร์รีเปียโน โปรโมเตอร์ตื้บโยโย่สโรชาอุปนายิกา นิวส์สเตย์ แคทวอล์คคาเฟ่โทรโข่งพริตตี้ เจ๊าะแจ๊ะสปาชิฟฟอนดีพาร์ทเมนต์ แชมเปี้ยนผลไม้แคร็กเกอร์รีทัช อุรังคธาตุ บาร์บีคิวอ่วมแหม็บเซอร์ไพรส์คันธาระ",
				"เต๊ะ ศึกษาศาสตร์ตี๋แล็บโบ้ยแคมเปญ แม็กกาซีนเพาเวอร์ปิกอัพโต๋เต๋ วาริชศาสตร์บูติคดอกเตอร์สแล็กโอเวอร์ เซอร์ดีพาร์ตเมนต์ ไฟลท์เนิร์สเซอรีเก๊ะ อะ โมเต็ลเฟรชชี่มอคค่าแชมเปญภารตะ สตรอว์เบอร์รีสี่แยก ร็อคเชอร์รี่ บู๊สโตนผิดพลาด เทคโนแบนเนอร์สวีท อิมพีเรียลโก๊ะคอนโทรลซาดิสต์ซะ แฮมเบอร์เกอร์สแล็ก เยลลี่วิวยิว เคสเบิร์นคอร์รัปชั่น",
				"แพนงเชิญรีทัชเดโมโอเปร่าโมจิ แจ็กเก็ตมั้ง ไฮเวย์มั้ยซีอีโอ ดีลเลอร์ตาปรือออร์แกนิกคาแรคเตอร์พาร์ตเนอร์ ไมเกรน สตรอว์เบอร์รีอันเดอร์กิมจิ แมมโบ้ธุหร่ำลีเมอร์เชอร์รี่ มินท์สโลว์เซ็กซ์มอบตัว ออเดอร์บอดี้ไงสไตรค์ลาติน ฮัมแคนูวันเวย์พงษ์ฮาราคีรี โหงวเฮ้งอพาร์ทเมนท์แฟนตาซีซาฟารีสโตน จตุคาม จิ๊กโก๋ ชะโนดวิวเซอร์ไพรส์เจ็ต ซัพพลายสโตร์ เซี้ยวคอนแท็คอึมครึมกระดี๊กระด๊าหน่อมแน้ม",
				"สมาพันธ์ก่อนหน้ากฤษณ์ ตุ๊กวิภัชภาค ศิรินทร์อุตสาหการโปรเจ็กเตอร์ฮาร์ดซิมโฟนี สกายเจ็ตเฮียพูล กีวีโกลด์อาร์พีจีแอนด์ คูลเลอร์แจ๊กเก็ตสุริยยาตร เบอร์รีล็อตศึกษาศาสตร์แรลลี่เคส ทัวริสต์ แจ็กพอตกิฟท์แคนูเซ็นทรัลบ๋อย สเก็ตช์เทอร์โบม้าหินอ่อนคอนโดภควัมปติ ทำงานป๊อปเปียโนยอมรับแชมพู เลสเบี้ยนมาร์เก็ตติ้งแก๊สโซฮอล์ถูกต้อง ซีเรียสไวอะกร้า ติงต๊องสะเด่า ฮ่องเต้ ว้อยโฮปนิรันดร์เอ๋",
				"ตังค์ไคลแม็กซ์ออเดอร์พล็อต โอยัวะควิกรายชื่อ เบนโตะทัวร์สโลว์แคทวอล์คสโตน แพลนคอมพ์อิสรชนจิ๊กไอเดีย จัมโบ้﻿กรรมาชนวิภัชภาคอาร์ติสต์ เพลซเฝอ เป่ายิงฉุบเรตติ้งเกสต์เฮาส์บูมแจ็กเก็ต เซ็กซ์ โปรเจ็กต์ออร์แกนผิดพลาดเปราะบางคอมเมนต์ พาร์ทเนอร์กีวีคาปูชิโน สจ๊วต วอลล์สุริยยาตรไดเอ็ตซิตี้ โมเดลร็อครีสอร์ทบูติคออกแบบ ดิกชันนารีบึ้มมาร์เก็ตติ้ง ไลท์มินท์คอร์ปแต๋ว อวอร์ด",
				"แพกเกจเพทนาการ สตูดิโอง่าวอิเลียดสต็อก สุริยยาตรโต๊ะจีน ท็อปบู๊ทบุ๋นมาร์กทอร์นาโดสโตร์ ซาดิสม์ฟรังก์อันตรกิริยา หม่านโถวเลิฟสต็อค เห็นด้วยโลโก้ วิภัชภาค โมเดล มอยส์เจอไรเซอร์จตุคามเอ๋อแฟรนไชส์โพลารอยด์ เฟรชชี่วิดีโอ เฟิร์มแพลน เดี้ยงช็อค ภควัมบดีโหงวไฮบริดเซฟตี้ เอนทรานซ์ฮิปฮอปพะเรอ เวิลด์เบลออีสต์",
				"วัจนะซันตาคลอส เรตชาร์ต แฮนด์โรลออนออสซี่สงบสุขบลูเบอร์รี่ ตุ๋ยติวเตอร์โดมิโน คีตราชันฮิปฮอปแจ็กเก็ตเจได พุทโธไฟต์เสกสรรค์ซาดิสม์มวลชน พุทโธบาร์บีคิวทัวริสต์มอคคาแซมบ้า เฟิร์มซีเรียสวาริชศาสตร์แก๊สโซฮอล์ โบรกเกอร์อีสต์ น็อคแซนด์วิช พุทโธกิฟท์ป๊อปก่อนหน้า นายพรานนรีแพทย์ออร์เดอร์ บอกซ์กุมภาพันธ์ไฮไลต์ คอมเมนต์ก๊วนเอ็กซ์เพรสเอสเพรสโซอริยสงฆ์ เบนโลเอเซีย รีไทร์กลาส",
				"คอนโดเท็กซ์สแล็กแพนดาอาข่า วิภัชภาคหงวนโฟล์คจุ๊ยมะกัน ฟีดทับซ้อนแฟนตาซีวิดีโอ วัจนะพาสปอร์ต แหววเกมส์ไฟลท์ไลท์แฟล็ต แครกเกอร์สหัสวรรษโหงวเฮ้งกฤษณ์ ซื่อบื้อฮาโลวีนป๋อหลอสามแยกทัวริสต์ เซ็นเตอร์แบนเนอร์ เช็งเม้งแซ็กโซโฟนรีไทร์ โพลารอยด์ เดบิตชินบัญชรโฮลวีตโปรเจคท์ มั้งแรลลีเสกสรรค์ฮิตแพ็ค คอรัปชันแพนงเชิญแดนเซอร์เบิร์นซูโม่ โก๊ะ แบคโฮสลัมสคริปต์เอ๋อเซลส์แมน วีเจ",
				"ไนท์โอยัวะ ว้าวสุริยยาตรกิมจิ เอสเพรสโซพะเรอฟลุก ต่อรองแผดเผาสต๊อคไฟแนนซ์ เปียโน มาร์จินกรุ๊ปโทรมั้ง เชฟออดิชั่น แฟนตาซีไทม์ สปอตตู้เซฟยะเยือก สเปค เฟอร์นิเจอร์แชมป์บิ๊กนิว แคมป์ซีดาน แก๊สโซฮอล์ สปิริตหมวย จิ๊กเยอบีร่า เซ่นไหว้เทรนด์ชีสธุรกรรม",
				"ราชบัณฑิตยสถานตาปรือดีมานด์สะบึมส์ ซาฟารีแอร์ ว่ะ นิรันดร์ เฮอร์ริเคนหงวนโจ๋เทอร์โบ เดี้ยงเอ๋เวิร์คอิมพีเรียลเกย์ เซลส์แมนไวกิ้งฮาร์ดบรรพชน อาว์อุปัทวเหตุ แฟรนไชส์แอพพริคอทฟลุท แบนเนอร์แฟกซ์ว้อดก้า ผู้นำไลท์ ฮวงจุ้ยแมคเคอเรล แมกกาซีนไนน์ หลวงพี่ ซากุระสต๊อค หม่านโถว",
				"สแตนเลสคณาญาติ ฟลุตสตีล﻿กรรมาชนเทวา เซี้ยวฟาสต์ฟู้ดสโตร์ซูชิไวกิ้ง แมคเคอเรลบรรพชนเมจิคเดโม ราเม็งวิลล์อิกัวนา โปรเจ็กเตอร์โลชั่นโครนานอร์ทออดิทอเรียม หน่อมแน้ม ซิตี้ซิ้มมาร์ต บราหมิงเคลียร์ เมจิกโอเลี้ยงไฮเอนด์กาญจน์แกงค์ เอ็นทรานซ์มวลชนสตริง สป็อต ดีลเลอร์สามช่า โชว์รูมอุปนายิกาเมคอัพ ออร์แกนผู้นำฮ่องเต้เอาต์ กุมภาพันธ์",
				"ตื้บอัลไซเมอร์จิ๊ก โพลล์ดีมานด์โหลนไฮบริด ไดเอ็ตซิมเฮอร์ริเคน เอนทรานซ์ ผลักดันดีพาร์ตเมนท์ชาร์ตจูเนียร์ คอร์รัปชั่นซีรีส์พ่อค้าอพาร์ทเมนต์ รวมมิตรตอกย้ำฮัมซ้อ ต่อรองมั้ง สัมนาอัลบัม ศึกษาศาสตร์อิออน อุปนายกสถาปัตย์ โค้กเวิร์กช็อปพุทธศตวรรษ พลานุภาพสโตนภูมิทัศน์ซูชิบอยคอต สตีลแอ็คชั่นโมจิตุ๋ย ล็อตบัตเตอร์ปูอัดผิดพลาด สต็อคอิมพีเรียล",
				"รายชื่อ เยอบีร่ามลภาวะ เปปเปอร์มินต์ พุทธศตวรรษเลสเบี้ยนสเตย์สวีทบุญคุณ ไมค์ชาร์ตวัจนะ ศึกษาศาสตร์ตาปรือ วิทย์ซิ้ม คาเฟ่ คลับเจลโอ้ย ฮิตเอ็นจีโอเอาท์ดอร์ ซิมโฟนี่ คณาญาติธุรกรรม ซีเรียสหยวนแอโรบิค ครูเสด ไอเดียเอฟเฟ็กต์ เอาท์ดอร์",
				"แอนด์ สึนามิไตรมาสทริป ชาร์จริคเตอร์ แฮปปี้สไตรค์ ซังเตแฟลชโต๊ะจีนเทคโนฮัลโหล นิวส์รอยัลตี้แหววไชน่า โซน คันยิช็อปโฟนไทเฮาภูมิทัศน์ ครัวซองต์รีดไถแฟลช วิกแคมปัสสกายคีตกวี คอนโดมิเนียมโค้ชสปอร์ตสแล็ก ศิรินทร์ลอจิสติกส์ นายแบบ ปอดแหกคอนโดมิเนียม ถูกต้องอึ้มบุญคุณโฟน เซ็กซ์วิปเลกเชอร์",
				"แฟ้บแฮนด์ฟลุกแจ็กพอต ปัจเจกชนฮิปฮอปคำตอบ โอเพ่นสโตน เกจิแรงดูดเดโมสหัสวรรษฟรุต ซิ่งโต๊ะจีนฟลุก ภูมิทัศน์ฟรุตเซาท์ อิสรชน เด้ออาร์พีจีโซลาร์สโรชาซิตี คอนโดมิเนียม โฟนพงษ์ เตี๊ยมโบรชัวร์ภูมิทัศน์ ไชน่าแบล็กโทรแผดเผาสารขัณฑ์ คาราโอเกะแหม็บเก๋ากี้ นอมินีพาสเจอร์ไรส์เบิร์ดซามูไร แพทยสภาโค้ชอาร์พีจี โชว์รูมควิกถูกต้องรีทัช",
				"มั้งโจ๋ยาวีอพาร์ทเมนต์เบิร์น เฝอซานตาคลอสเบอร์เกอร์โอ้ยช็อค เทียมทานคันยิ หมวยแรลลี่เก๊ะชัตเตอร์อิสรชน นพมาศซิ้มซิลเวอร์คูลเลอร์ อีสเตอร์ลาตินสต็อค ฟลุทสคริปต์ ซ้อโพลารอยด์สามแยกสุนทรีย์ภควัมบดี แครกเกอร์รีโมทเปียโนเวสต์วีเจ ไชน่าซาตาน ซาตานเมเปิลแบคโฮ แพนดา คอนเซปต์ฮีโร่คาแรคเตอร์ ไทยแลนด์มั้ง รุสโซซิมเซอร์วิสล็อตฟีเวอร์ ออเดอร์โค้ช",
				"เซลส์ เอ็นจีโออ่อนด้อยอัลบั้มหงวน มาร์กไฟลท์โฟม แฟนตาซีเมี่ยงคำบริกรรีสอร์ต หมิงหงวนตื้บคำตอบ สติกเกอร์แทงกั๊กบลูเบอร์รี่ดิสเครดิต เลดี้เวอร์ ซิมโฟนี่บรา เอ๋อแจ็กเก็ตโซนี่รีทัช ซีเนียร์มาร์กอิสรชนบัสยูโร คลับเก๊ะ สโรชา แดนซ์คูลเลอร์ ไทเฮา ซูเปอร์ โปรดิวเซอร์",
				"สุริยยาตร์คันยิโยเกิร์ตบอยคอตหลวงพี่ ไทยแลนด์ ไทยแลนด์ถูกต้อง เจ๊าะแจ๊ะมาร์เก็ตติ้งเทอร์โบคองเกรส ฮิปโป ตู้เซฟ รวมมิตรเทียมทานก๋ากั่นวิวปูอัด วัคค์บูม ม็อบเมคอัพแฟรีสจ๊วต สติกเกอร์ซูเปอร์นายแบบสามช่า ล็อบบี้ล็อบบี้ รองรับ มั้ยชาร์จแฮปปี้คอรัปชั่น ซิตี้ซี้สกรัมวานิลา วอเตอร์สเตริโอจังโก้บอยคอตต์อวอร์ด ซังเตเพียวภคันทลาพาธด็อกเตอร์"
				);
		
		List<String> names = Arrays.asList(
				"เมี่ยงคำท็อปบู๊ทยาวี",
				"สามช่า นิรันดร์ฮาร์ด",
				"วาทกรรมแคร์คอนเทนเนอร์",
				"บอดี้ มิวสิคซัพพลายเออร์มือถือ",
				"ล็อตคอลเล็กชั่นตุ๊กสตรอเบอรีเซลส์แมน",
				"โชว์รูมแหม็บเคลียร์วาฟเฟิลคลิป",
				"ไลท์คลาสสิกเห็นด้วย",
				"อพาร์ทเมนต์ทอล์คอวอร์ดกลาสไฮเวย์",
				"ธุหร่ำชีส จุ๊ยเพลย์บอยลิมูซีน",
				"เจไดปัจเจกชนเพทนาการ",
				"โกะเพลซโปรโมเตอร์โฮป",
				"แพนงเชิญเฟอร์รี่แบ็กโฮ",
				"ดีไซน์เนอร์บราเคลียร์",
				"โหลน เซ่นไหว้",
				"เพรสกลาสแอปเปิลเชฟ",
				"แฟนซีรัมรีไทร์วัจนะเห่ย",
				"เคส ลอร์ดช็อปปิ้งตื้บ",
				"ปาสคาลคลิปจึ๊กโรแมนติค",
				"บ๋อย เทคโนแครตแจม",
				"เหมยมยุราภิรมย์คอร์รัปชันเกจิดราม่า",
				"โหลยโท่ยพาสปอร์ตน้องใหม่ซาดิสต์",
				"แพกเกจเทป ซาร์ดีนหงวนออยล์",
				"สะบึมส์ ระโงกว้อยสามช่าเซลส์",
				"สเตเดียม การันตี พิซซ่า",
				"สหรัฐ มอบตัวเซ็กส์ลิสต์จิ๊กโก๋ ",
				"ปาร์ตี้โปรโมชั่นแมชีนเลคเชอร์สามช่า",
				"วาริชศาสตร์ฟรังก์ว่ะสี่แยก",
				"ซีนคอนเทนเนอร์ออร์แกน",
				"บึ้มโหงวเฮ้งไทม์ปูอัด",
				"ฮอตดอกวอฟเฟิลออร์แกน",
				"บาบูนซิตีเรซินดีเจชาร์จ",
				"อพาร์ทเมนท์ ตังค์ลอร์ดเปราะบางบรรพชน",
				"เทรดจอหงวนแคนูแมมโบ้อิ่มแปร้",
				"แยมโรลไฟลท์ตู้เซฟเฟรชชี่ฟินิกซ์",
				"โรลออน สามแยกเยอบีราพีเรียดฮองเฮาซูเปอร์",
				"คอรัปชั่น สไปเดอร์โปรเจ็กเตอร์ปาร์ตี้โปรโมชั่น",
				"ติงต๊องอาว์ฮัลโลวีนอุปการคุณ",
				"ขั้นตอนกุนซือ แฮนด์สามช่า",
				"ทิปโปรเจคท์เทคเยอบีราโบว์",
				"ถูกต้องสเตชั่นโอเปอเรเตอร์",
				"วอร์รูมแคนูแบดอึ้ม",
				"รีทัช วอล์กเพียบแปร้",
				"มอนสเตอร์วิว ไฮเปอร์",
				"ปิยมิตรแป๋วบลูเบอร์รี่ควิกออดิทอเรียม",
				"เกรย์ฟลุทเลคเชอร์โปรเจกต์แอโรบิค",
				"เวิร์คแชมปิยองเวิลด์",
				"คันยิไฮเปอร์ พลาซ่าเอสเปรสโซคาเฟ่เก๊ะ อิ่มแปร้"
				);
		
		List<Integer> managementCost = Arrays.asList(5, 6, 7, 10, 12, 34, 40, 70, 33, 20);
		List<Double> discountList = Arrays.asList(0.0, 0.1, 0.1, 0.2,  0.2, 0.1, 0.1, 0.0, 0.0, 0.0, 0.0, 0.3, 0.1, 0.2, 0.4, 0.0, 0.5, 0.6);
		
		bouquets.addAll(bouquets);

		bouquets.forEach(b -> {
			int randomDescription = ThreadLocalRandom.current().nextInt(0, productDescription.size());
			int randomManagementCost = ThreadLocalRandom.current().nextInt(0, managementCost.size() );
			int randomDiscount = ThreadLocalRandom.current().nextInt(0, discountList.size());
			Product p = Product.builder().bouquet(b)
					.description(productDescription.get(randomDescription))
					.managementCost(managementCost.get(randomManagementCost))
					.marginRate(1 + ThreadLocalRandom.current().nextInt(0, 3 + 1))
					.productName(names.get(ThreadLocalRandom.current().nextInt(0, names.size())))
					.remain(ThreadLocalRandom.current().nextInt(20, 100 + 1))
					.discount(discountList.get(randomDiscount))
					.bouquet(b)
					.build();
			
			products.add(this.productService.getProductRepository().save(p));
		});
		
		return products;
	}
	
	public ArrayList<ProductOrder> productOrderTableSeeder() {
		ArrayList<ProductOrder> productOrders = new ArrayList<ProductOrder>();
		int num = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		for (int i = 0; i < num; i++) {
			productOrders.add(this.productOrderService.insert(ProductOrder.builder()
					.build()));
		}
		
		return productOrders;
	}
	
	public ArrayList<ProductOrderLine> productOrderLineTableSeeder(ArrayList<Product> products) {
		ArrayList<ProductOrderLine> orderLine = new ArrayList<ProductOrderLine>();
		ArrayList<ProductOrder> orders = new ArrayList<ProductOrder>();
		
		int orderSize = ThreadLocalRandom.current().nextInt(20, 50 + 1);
		int productSize = products.size();
		
		for (int i = 0; i < orderSize; i++) {
			ProductOrder po = null;
			
			Collection<ProductOrderLine> localOrderLine = new ArrayList<ProductOrderLine>();
			int itemQuantity = ThreadLocalRandom.current().nextInt(0, productSize);
			Collection<Product> orderProducts = new ArrayList<Product>();

			for (int j = 0; j < itemQuantity; j++) {
				Product p = products.get(ThreadLocalRandom.current().nextInt(0, productSize));
				while (orderProducts.contains(p)) {
					p = products.get(ThreadLocalRandom.current().nextInt(0, productSize));
				}

				ProductOrderLine pol = this.productOrderLineService.insert(ProductOrderLine.builder()
						.product(p)
						.quantity(ThreadLocalRandom.current().nextInt(1, 5))
						.build());

				localOrderLine.add(pol);
				orderLine.add(pol);
			}
			
			po = this.productOrderService.insert(ProductOrder.builder().productOrderLine(localOrderLine).build());
			orders.add(po);
			this.productOrders.add(po);
		}

		return orderLine;
	}
	
}
