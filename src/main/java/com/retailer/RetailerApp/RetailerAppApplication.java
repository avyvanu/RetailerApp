package com.retailer.RetailerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RetailerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerAppApplication.class, args);
	}

	@GetMapping("/reward/{rewardValue}")
	public int getReward(@PathVariable int rewardValue) {

		return doCalculateReward(rewardValue);
	}
	
	private int doCalculateReward(int purchaseTotal) {

		int rewardsPoints = 0;
		if (purchaseTotal >= 100) {
			rewardsPoints = (purchaseTotal - 100) * 2;
		}
		if (purchaseTotal >= 50) {
			if (purchaseTotal > 100) {
				rewardsPoints = rewardsPoints + 50;
			} else {
				rewardsPoints = rewardsPoints + (purchaseTotal - 50);
			}
		}

		return rewardsPoints;
	}

}
