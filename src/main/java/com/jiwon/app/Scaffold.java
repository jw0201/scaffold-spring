package com.jiwon.app;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiwon.app.service.ElasticSearchService;

public class Scaffold {
	
	/**
	 * @param args
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws ParseException, InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String cluster_name = options(args);
		
		if (cluster_name != null) {
			ElasticSearchService es = (ElasticSearchService) context.getBean(ElasticSearchService.class);   
			es.setElasticsearch_cluster_name(cluster_name);
		}
	}
	
	private static String options(String[] args) throws ParseException {
		Options options = new Options();

		// add option
		options.addOption("esname", true, "ElastisSearch Cluster Name");
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = parser.parse( options, args);
		
		// get option value
		return  cmd.getOptionValue("esname");

	}
}
