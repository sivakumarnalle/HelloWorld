package com.javainuse.main;

import java.io.FileInputStream;
import java.util.Map;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.javainuse.model.Product;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			SpreadsheetCompiler sc = new SpreadsheetCompiler();
			String outcome = sc.compile(
					new FileInputStream(
							"D:\\eclipse-workspace\\drools-hello-world-table\\src\\main\\resources\\rules\\rules.csv"),
					InputType.CSV);
			System.out.println(outcome);

			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			Map<String, String> atrbMap = product.getAtrbMap();
			atrbMap.put("CASE_TYPE", "gold");
			atrbMap.put("PLACE_OF_SERVICE", "100");
			atrbMap.put("LEVEL_OF_SERVICE", "siva");

			FactHandle fact1 = kSession.insert(product);
			kSession.setGlobal("product", product);

			kSession.fireAllRules();

			System.out.println(
					"The discount for the jewellery product " + product.getType() + " is " + product.getDiscount());

			System.out.println("The rule id for the jewellery product " + product.getType() + " is "
					+ product.getAtrbMap().get("RULE_ID"));

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
